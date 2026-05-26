package de.uni_bremen.pi2;

public class MoveToFront<E> extends SetNaive<E> {

    @Override
    public boolean contains(final E element)
    {
        // Hier das Suchen ohne Umordnung der Liste implementieren.
        // Hierzu darf nicht der Iterator genutzt werden.

        /* Ramtin */
        // TODO: Create an temporary pointer of head
        // TODO: Looping through nodes
        // TODO: Compare
        // TODO: Move or Return

        /* Special cases to consider:
         * 1.Is the list empty
         * 2.Is the searching element directly the head is?
         */
        //first case
        if (getHead() == null) {
            return false;
        }
        // second case:
        if(getHead().getElement().equals(element)){
            return true;
        }
        // We have already checked the head so the current will be one next to the head:
        Node<E> previous = getHead();
        Node<E> current  = getHead().getNext();

        //Start moving the head until it reaches the last node, which connected to null:
        while (current.getElement() != null){
            if (current.getElement().equals(element)){
                //connect left side item of our founded to the right side node of founded element:
                current.setNext(current.getNext());
                //connect founded element to the head:
                current.setNext(getHead());
                // setting the current element as head:
                setHead(current);

                return true;
            }

            previous = current;
            current  = current.getNext();
        }

        return false; // Ersetzen
    }
}

