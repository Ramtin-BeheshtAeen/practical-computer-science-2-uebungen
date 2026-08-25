package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse List (Entfernen aus einer
 * einfach verketteten Liste), Klausur WiSe 2022/23, Aufgabe 2 (20 Punkte).
 */
public class ListTest
{
    /** Das Entfernen des ersten Elements liefert die Restliste. */
    @Test
    public void testErstesElement()
    {
        assertEquals("[2, 3]", Elem.toString(List.remove(Elem.of(1, 2, 3), 0)));
    }

    /** Das Entfernen des einzigen Elements liefert die leere Liste. */
    @Test
    public void testEinzigesElement()
    {
        assertNull(List.remove(Elem.of(1), 0));
    }

    /** Das Entfernen eines Elements in der Mitte funktioniert korrekt. */
    @Test
    public void testMitte()
    {
        assertEquals("[1, 3, 4]", Elem.toString(List.remove(Elem.of(1, 2, 3, 4), 1)));
        assertEquals("[1, 2, 4]", Elem.toString(List.remove(Elem.of(1, 2, 3, 4), 2)));
    }

    /** Das Entfernen des letzten Elements funktioniert korrekt. */
    @Test
    public void testLetztesElement()
    {
        assertEquals("[1, 2]", Elem.toString(List.remove(Elem.of(1, 2, 3), 2)));
    }

    /** Das Entfernen aus einer längeren Liste funktioniert an jeder Position. */
    @Test
    public void testAllePositionen()
    {
        for (int index = 0; index < 6; ++index) {
            final java.util.ArrayList<Integer> expected = new java.util.ArrayList<>(
                    java.util.List.of(0, 1, 2, 3, 4, 5));
            expected.remove(index);
            assertEquals(expected.toString(),
                    Elem.toString(List.remove(Elem.of(0, 1, 2, 3, 4, 5), index)));
        }
    }

    /** Nach dem Entfernen des Kopfes bleiben die übrigen Elemente verkettet. */
    @Test
    public void testKopfEntfernenKette()
    {
        final Elem<Integer> result = List.remove(Elem.of(9, 8, 7, 6), 0);
        assertEquals(Integer.valueOf(8), result.getValue());
        assertEquals(Integer.valueOf(7), result.getNext().getValue());
        assertEquals(Integer.valueOf(6), result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }
}
