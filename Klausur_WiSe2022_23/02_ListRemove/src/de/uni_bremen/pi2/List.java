package de.uni_bremen.pi2;

/**
 * Die Klasse enthält Operationen auf einfach verketteten Listen.
 */
public class List
{
    /**
     * Entfernt das Element an einer bestimmten Position aus einer einfach
     * verketteten Liste. Rekursive Lösung.
     *
     * Ist der Index 0, wird das erste Element entfernt, d.h. der Nachfolger
     * wird zum neuen ersten Element. Andernfalls wird rekursiv aus dem Rest der
     * Liste entfernt.
     *
     * @param first Das erste Element der Liste. Ist nicht null, und der Index
     *         ist kleiner als die Länge der Liste.
     * @param index Die Position des Elements, das entfernt wird. Ist mindestens
     *         0 und kleiner als die Länge der Liste.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Entfernen.
     */
    public static <E> Elem<E> remove(final Elem<E> first, final int index)
    {
        // TODO: Aufgabe 2 (Zeilen 25-29 der Musterlösung)
        return null;
    }
}
