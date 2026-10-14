package de.uni_bremen.pi2;

/**
 * Aufgabe 1: Anhängen an Array dynamischer Größe (20 %).
 *
 * Es dürfen keine Klassen der Laufzeitbibliothek außer den hier
 * bereits genannten verwendet werden.
 *
 * @param <E> Der Typ der Elemente, die im Array gespeichert werden
 *           können.
 */
public class Array<E>
{

    // NUR ZUM DEBUGGEN – vor der Abgabe löschen!
    private void debug(final String branch, final E element)
    {
        String s = "add(" + element + ") → " + branch
                + " | size=" + size + " cap=" + data.length + " | [";
        for (int i = 0; i < data.length; i++) {
            s += (i < size ? data[i] : "_");
            if (i < data.length - 1) {
                s += ", ";
            }
        }
        System.out.println(s + "]");
    }
    /** Die Daten des Arrays werden hier gespeichert. */
    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[0];

    /** Die tatsächlich genutzte Größe des Arrays. */
    private int size = 0;

    /**
     * Die Größe des Arrays.
     * @return Die Größe als Anzahl der gespeicherten Elemente.
     */
    public int size()
    {
        return size;
    }

    /**
     * Die Kapazität, d.h. die Größe des reservierten Speichers.
     * @return Die Kapazität als Anzahl der gespeicherten Elemente.
     */
    public int capacity()
    {
        return data.length;
    }

    // Alles oberhalb muss so bleiben.
    // Implementiert die folgenden zwei Methoden:

    /**
     * Fügt ein neues Element an das Array an. Reicht der Platz im
     * internen Datenspeicher nicht mehr aus, wird dieser in
     * seiner Größe verdoppelt, wächst aber mindestens um ein
     * Element.
     * @param element Das Element, das an das bisherige Array
     *                angehängt wird.
     */
    public void add(final E element)
    {
        E[] newData = null;

        if (capacity() == 0 ){
            newData = (E[]) new Object[(capacity() + 1)];
            newData[data.length] = element;
            data = newData;
            size++;
            debug("cap 0", element);

        } else if (size + 1 > capacity() ) {
            newData = (E[]) new Object[capacity() * 2];

            for(int i = 0; i < data.length ; i++){
                //System.out.println(get(i));
                newData[i] = get(i);
                //System.out.println("we are in else if and no size " + newData[i]);
            }

            newData[data.length] = element;
            data = newData;
            size++;
            debug("voll", element);

        } else {
            newData = (E[]) new Object[capacity()];

            for(int i = 0; i < size ; i++){
                newData[i] = get(i);
                //System.out.println("we are in else and we have size " + newData[i]);
            }
            //data.length is how many slots the array has. That’s the capacity, and here it’s 4.
            // newData[data.length] = element;
            newData[size] = element;
            data = newData;
            size++;
            debug("Platz", element);
        }


    }

    /**
     * Liefert ein Element des Arrays zurück.
     * @param index Der Index des Elements, das ausgelesen wird.
     * @return Der Wert des Elements am angegebenen Index.
     * @throws ArrayIndexOutOfBoundsException Der Index liegt außerhalb
     * der Grenzen des Arrays.
     */
    public E get(final int index)
    {
        if(index > size - 1){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

}