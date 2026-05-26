package de.uni_bremen.pi2;

/**
 * Dies ist der Anfang einer Implementierung der naiven Selbstanordnungsstrategie.
 * Er muss erweitert werden. Für die anderen Strategien sollen ähnliche Klassen
 * erzeugt werden.
 */
public class SetNaive<E> extends Set<E>
{
    /**
     * Fügt der Menge ein neues Element hinzu. Die Methode wird von "add"
     * aufgerufen, wenn das Element noch nicht vorhanden ist.
     * @param element Das Element, das hinzugefügt wird.
     */
    @Override
    void addToList(final E element)
    {
        // Hier das Einfügen an den Anfang implementieren.

        /*
        * TODO: 1. Create the new node
        * TODO: 2. Update the Set's head to be the new node
        * */


        /* Ramtin: */
        // Create new Node:
        Node<E> newElement = new Node<>(element , getHead());
        // Setting new Node as the head:
        setHead(newElement);


    }

    /**
     * Testet, ob ein bestimmtes Element in der Menge gespeichert ist.
     * @param element Das Element, das nach dem gesucht wird. Das Element darf
     *                auch "null" sein, wäre dann aber garantiert nicht enthalten.
     * @return        Ist das gesuchte Element in der Menge enthalten?
     */
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
        while (current != null){
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
