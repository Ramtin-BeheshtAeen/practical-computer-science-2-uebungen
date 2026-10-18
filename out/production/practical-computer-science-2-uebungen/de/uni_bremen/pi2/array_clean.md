
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
        // TODO: Aufgabe 1
        // Schritt 1 – nur wenn voll (size == capacity()):
        //     neues Array der Größe ___ anlegen  (verdoppeln, aber mindestens +1),
        //     die size alten Elemente hinüberkopieren, data umhängen.
        // Schritt 2 – IMMER:
        //     element an die erste freie Stelle schreiben: data[___] = element;
        //     size erhöhen.
        // Kein System.out, kein else-Zweig mit neuem Array!
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
        // TODO: Aufgabe 1
        // Außerhalb heißt: kleiner als ___ oder mindestens ___.
        return null;
    }
}
