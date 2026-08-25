package de.uni_bremen.pi2;

/**
 * Die Klasse implementiert ein Array dynamischer Größe, d.h. ein Array, das
 * beliebig viele Elemente aufnehmen kann. Intern wird ein normales Array
 * verwendet, dessen Kapazität immer dann verdoppelt wird, wenn sie nicht mehr
 * ausreicht. Die Elemente können mit {@link #append(Object)} hinzugefügt und
 * mit {@link #get(int)} wieder ausgelesen werden.
 * @param <E> Der Typ der Elemente, die gespeichert werden können.
 */
public class DynamicArray<E>
{
    /** Das Array, das die Elemente speichert. Kann größer als size sein. */
    private E[] data;

    /** Die Anzahl der Elemente, die tatsächlich gespeichert sind. */
    private int size = 0;

    /**
     * Erzeugt ein leeres Array dynamischer Größe. Die Anfangskapazität ist 0.
     */
    @SuppressWarnings("unchecked")
    public DynamicArray()
    {
        data = (E[]) new Object[0];
    }

    /**
     * Liefert die Anzahl der gespeicherten Elemente zurück.
     * @return Die Anzahl der Elemente, die mit {@link #get(int)} ausgelesen
     *         werden können.
     */
    public int size()
    {
        return size;
    }

    /**
     * Liefert die aktuelle Kapazität des internen Arrays zurück, d.h. die
     * Anzahl der Elemente, die gespeichert werden könnten, ohne dass das
     * interne Array vergrößert werden müsste.
     * @return Die Länge des internen Arrays.
     */
    public int capacity()
    {
        return data.length;
    }

    /**
     * Hängt ein Element hinten an das Array an. Reicht die Kapazität des
     * internen Arrays dafür nicht mehr aus, wird ein neues Array angelegt und
     * der bisherige Inhalt dorthin kopiert. Die neue Kapazität ist 1, wenn die
     * bisherige 0 war, ansonsten die doppelte bisherige Kapazität. Kann nicht
     * mehr verdoppelt werden, ohne den Wertebereich von int zu verlassen, wird
     * die Kapazität auf Integer.MAX_VALUE gesetzt.
     * @param element Das Element, das angehängt wird. Darf null sein.
     */
    public void append(final E element)
    {
        // TODO: Aufgabe 1a (Zeilen 52-62 der Musterlösung)
    }

    /**
     * Liefert das Element an einer bestimmten Position zurück.
     * @param index Die Position des Elements. Muss kleiner als die Anzahl der
     *         gespeicherten Elemente sein.
     * @return Das Element an der Position index.
     * @throws ArrayIndexOutOfBoundsException Wenn index nicht kleiner als die
     *         Anzahl der gespeicherten Elemente ist.
     */
    public E get(final int index)
    {
        // TODO: Aufgabe 1b (Zeilen 74-77 der Musterlösung)
        return null;
    }
}
