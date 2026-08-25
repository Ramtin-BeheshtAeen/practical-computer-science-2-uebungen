package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse List (Aneinanderhängen zweier
 * einfach verketteter Listen), Klausur SoSe 2022, Aufgabe 2 (20 Punkte).
 */
public class ListTest
{
    /** Das Ergebnis ist richtig, wenn die erste Liste leer ist (5/5 Punkte). */
    @Test
    public void testErsteListeLeer()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.concat(null, Elem.of(1, 2, 3))));
    }

    /** Das Ergebnis ist richtig, wenn die zweite Liste leer ist (5/5 Punkte). */
    @Test
    public void testZweiteListeLeer()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.concat(Elem.of(1, 2, 3), null)));
    }

    /** Das Ergebnis ist richtig, wenn beide Listen leer sind. */
    @Test
    public void testBeideLeer()
    {
        assertNull(List.concat(null, null));
    }

    /** Das Ergebnis ist richtig, wenn keine der beiden Listen leer ist (10/10 Punkte). */
    @Test
    public void testKeineLeer()
    {
        assertEquals("[1, 2, 3, 4, 5]", Elem.toString(List.concat(Elem.of(1, 2, 3), Elem.of(4, 5))));
    }

    /** Das Aneinanderhängen zweier einelementiger Listen funktioniert. */
    @Test
    public void testEinelementig()
    {
        assertEquals("[1, 2]", Elem.toString(List.concat(Elem.of(1), Elem.of(2))));
    }

    /** Die zweite Liste wird tatsächlich angehängt, nicht kopiert. */
    @Test
    public void testZweiteListeAngehaengt()
    {
        final Elem<Integer> second = Elem.of(4, 5);
        final Elem<Integer> result = List.concat(Elem.of(1, 2, 3), second);
        // Das vierte Element des Ergebnisses ist genau das erste der zweiten Liste.
        assertTrue(result.getNext().getNext().getNext() == second,
                "Die zweite Liste soll direkt angehängt, nicht kopiert werden.");
    }

    /** Das Verketten längerer Listen erhält die Reihenfolge. */
    @Test
    public void testLaengereListen()
    {
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]",
                Elem.toString(List.concat(Elem.of(1, 2, 3, 4), Elem.of(5, 6, 7, 8))));
    }
}
