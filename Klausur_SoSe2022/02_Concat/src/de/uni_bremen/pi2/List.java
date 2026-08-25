package de.uni_bremen.pi2;

/**
 * Die Klasse enthält Operationen auf einfach verketteten Listen.
 */
public class List
{
    /**
     * Hängt zwei einfach verkettete Listen aneinander. Die zweite Liste wird an
     * das Ende der ersten Liste angehängt. Rekursive Lösung.
     *
     * Ist die erste Liste leer, ist das Ergebnis die zweite Liste. Andernfalls
     * wird der Rest der ersten Liste rekursiv mit der zweiten Liste verkettet.
     *
     * @param first Das erste Element der ersten Liste. Darf null sein.
     * @param second Das erste Element der zweiten Liste. Darf null sein.
     * @param <E> Der Typ der Werte in den Listen.
     * @return Das erste Element der zusammengehängten Liste.
     */
    public static <E> Elem<E> concat(final Elem<E> first, final Elem<E> second)
    {
        // TODO: Aufgabe 2 (Zeilen 25-29 der Musterlösung)
        return null;
    }
}
