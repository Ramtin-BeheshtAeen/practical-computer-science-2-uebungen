package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse LinkedList (Einfügen eines
 * Elements in eine einfach verkettete Liste), Klausur SoSe 2026, Aufgabe 2
 * (20 Punkte).
 *
 * Die Tests folgen den Zeilen der Bewertung: leere Liste (2), Anfang (4,5),
 * hinter dem ersten (4,5), vor dem letzten (4,5), am Ende (4,5).
 */
public class LinkedListTest
{
    /**
     * Baut eine Liste aus den angegebenen Werten.
     * @param values Die Werte in Listenreihenfolge.
     * @return Das erste Element oder null bei keinen Werten.
     */
    @SafeVarargs
    private static <E> Elem<E> list(final E... values)
    {
        Elem<E> first = null;
        for (int i = values.length - 1; i >= 0; --i) {
            first = new Elem<>(values[i], first);
        }
        return first;
    }

    /**
     * Wandelt eine Liste in eine Zeichenkette wie "[1, 2, 3]" um.
     * @param first Das erste Element der Liste.
     * @return Die Zeichenkette.
     */
    private static String str(final Elem<?> first)
    {
        final StringBuilder s = new StringBuilder("[");
        for (Elem<?> e = first; e != null; e = e.getNext()) {
            s.append(e.getValue());
            if (e.getNext() != null) {
                s.append(", ");
            }
        }
        return s.append("]").toString();
    }

    /** Das Einfügen in eine leere Liste funktioniert korrekt (2 P.). */
    @Test
    public void testLeereListe()
    {
        final Elem<Integer> result = LinkedList.insert(null, 0, 1);
        assertEquals("[1]", str(result));
        assertNull(result.getNext());
    }

    /** Das Einfügen am Anfang einer nicht-leeren Liste funktioniert korrekt (4,5 P.). */
    @Test
    public void testAnfang()
    {
        final Elem<Integer> first = list(1, 2, 3);
        final Elem<Integer> result = LinkedList.insert(first, 0, 0);
        assertEquals("[0, 1, 2, 3]", str(result));
        assertSame(first, result.getNext(), "Die alte Liste wird angehängt, nicht kopiert.");
    }

    /** Das Einfügen hinter dem ersten Listenelement funktioniert korrekt (4,5 P.). */
    @Test
    public void testHinterDemErsten()
    {
        final Elem<Integer> first = list(1, 3, 4);
        final Elem<Integer> result = LinkedList.insert(first, 1, 2);
        assertEquals("[1, 2, 3, 4]", str(result));
        assertSame(first, result, "Der Kopf der Liste bleibt erhalten.");
    }

    /** Das Einfügen vor dem letzten Listenelement funktioniert korrekt (4,5 P.). */
    @Test
    public void testVorDemLetzten()
    {
        final Elem<Integer> first = list(1, 2, 4);
        final Elem<Integer> last = first.getNext().getNext();
        final Elem<Integer> result = LinkedList.insert(first, 2, 3);
        assertEquals("[1, 2, 3, 4]", str(result));
        assertSame(last, result.getNext().getNext().getNext(),
                "Das letzte Element bleibt dasselbe Objekt.");
    }

    /** Das Einfügen am Ende einer Liste funktioniert korrekt (4,5 P.). */
    @Test
    public void testEnde()
    {
        final Elem<Integer> first = list(1, 2, 3);
        final Elem<Integer> result = LinkedList.insert(first, 3, 4);
        assertEquals("[1, 2, 3, 4]", str(result));
        assertSame(first, result);
    }

    /** Einfügen in eine einelementige Liste, vorne und hinten. */
    @Test
    public void testEinelementig()
    {
        assertEquals("[0, 1]", str(LinkedList.insert(list(1), 0, 0)));
        assertEquals("[1, 2]", str(LinkedList.insert(list(1), 1, 2)));
    }

    /** Mehrfaches Einfügen ergibt die erwartete Reihenfolge. */
    @Test
    public void testMehrfach()
    {
        Elem<String> first = null;
        first = LinkedList.insert(first, 0, "c");   // [c]
        first = LinkedList.insert(first, 0, "a");   // [a, c]
        first = LinkedList.insert(first, 1, "b");   // [a, b, c]
        first = LinkedList.insert(first, 3, "d");   // [a, b, c, d]
        assertEquals("[a, b, c, d]", str(first));
    }
}
