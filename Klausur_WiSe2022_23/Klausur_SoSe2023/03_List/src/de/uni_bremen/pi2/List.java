package de.uni_bremen.pi2;

/**
 * Die Klasse enthält Operationen auf einfach verketteten Listen.
 */
public class List
{
    /**
     * Fügt einen Wert an einer bestimmten Position in eine einfach verkettete
     * Liste ein. Iterative Lösung.
     *
     * Ist der Index 0, wird ein neues erstes Element erzeugt. Ansonsten wird
     * das Element vor der Einfügeposition gesucht und dahinter eingehängt.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param index Die Position, an der eingefügt wird. Ist mindestens 0 und
     *         höchstens so groß wie die Länge der Liste.
     * @param value Der Wert, der eingefügt wird. Darf null sein.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Einfügen.
     */
    public static <E> Elem<E> insertIterative(final Elem<E> first, final int index, final E value)
    {
        // TODO: Aufgabe 3a (Zeilen 24-30 der Musterlösung, linke Spalte)
        return null;
    }

    /**
     * Fügt einen Wert an einer bestimmten Position in eine einfach verkettete
     * Liste ein. Rekursive Lösung.
     *
     * Ist der Index 0, wird ein neues erstes Element erzeugt. Ist die Liste
     * leer, gibt es nichts, wohinter eingefügt werden könnte. Ansonsten wird
     * rekursiv in den Rest der Liste eingefügt.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param index Die Position, an der eingefügt wird. Ist mindestens 0 und
     *         höchstens so groß wie die Länge der Liste.
     * @param value Der Wert, der eingefügt wird. Darf null sein.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Einfügen.
     */
    public static <E> Elem<E> insertRecursive(final Elem<E> first, final int index, final E value)
    {
        // TODO: Aufgabe 3b (rechte Spalte der Musterlösung)
        return null;
    }
}
