package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse List.
 * Die Tests decken die Klausur SoSe 2023, Aufgabe 3 ab (20 Punkte).
 * Es werden jeweils die iterative und die rekursive Lösung geprüft.
 */
public class ListTest
{
    /**
     * Führt beide Varianten des Einfügens aus und prüft das Ergebnis. Da beide
     * Varianten die Ausgangsliste verändern dürfen, wird für jede Variante eine
     * eigene Liste aus den übergebenen Werten erzeugt.
     * @param expected Die erwartete Liste als Zeichenkette.
     * @param index Die Einfügeposition.
     * @param value Der einzufügende Wert.
     * @param values Die Werte der Ausgangsliste.
     */
    private void assertInserts(final String expected, final int index, final Integer value,
            final Integer... values)
    {
        assertEquals(expected, Elem.toString(List.insertIterative(Elem.of(values), index, value)),
                "Iterative Lösung liefert ein falsches Ergebnis.");
        assertEquals(expected, Elem.toString(List.insertRecursive(Elem.of(values), index, value)),
                "Rekursive Lösung liefert ein falsches Ergebnis.");
    }

    /** Das Einfügen in eine leere Liste funktioniert korrekt. */
    @Test
    public void testLeereListe()
    {
        assertEquals("[7]", Elem.toString(List.insertIterative(null, 0, 7)));
        assertEquals("[7]", Elem.toString(List.insertRecursive(null, 0, 7)));
    }

    /** Das Einfügen an Position 0 erzeugt einen neuen Listenkopf. */
    @Test
    public void testAnfang()
    {
        assertInserts("[0, 1, 2, 3]", 0, 0, 1, 2, 3);
    }

    /** Das Einfügen an Position 1 funktioniert korrekt. */
    @Test
    public void testZweitePosition()
    {
        assertInserts("[1, 9, 2, 3]", 1, 9, 1, 2, 3);
    }

    /** Das Einfügen in der Mitte der Liste funktioniert korrekt. */
    @Test
    public void testMitte()
    {
        assertInserts("[1, 2, 9, 3, 4]", 2, 9, 1, 2, 3, 4);
    }

    /** Das Einfügen am Ende der Liste funktioniert korrekt. */
    @Test
    public void testEnde()
    {
        assertInserts("[1, 2, 3, 9]", 3, 9, 1, 2, 3);
    }

    /** Das Einfügen in eine einelementige Liste funktioniert an beiden Positionen. */
    @Test
    public void testEinelementigeListe()
    {
        assertInserts("[9, 1]", 0, 9, 1);
        assertInserts("[1, 9]", 1, 9, 1);
    }

    /** Das Einfügen von null als Wert funktioniert. */
    @Test
    public void testNullWert()
    {
        assertInserts("[1, null, 2]", 1, null, 1, 2);
    }

    /** Das Einfügen in eine längere Liste funktioniert an jeder Position. */
    @Test
    public void testAllePositionen()
    {
        for (int index = 0; index <= 6; ++index) {
            final java.util.ArrayList<Integer> expected = new java.util.ArrayList<>(
                    java.util.List.of(0, 1, 2, 3, 4, 5));
            expected.add(index, 99);
            assertInserts(expected.toString(), index, 99, 0, 1, 2, 3, 4, 5);
        }
    }

    /**
     * Die Ausgangsliste darf beim iterativen Einfügen wiederverwendet werden,
     * ohne dass ein zuvor eingefügtes Element noch enthalten ist.
     */
    @Test
    public void testUnabhaengigeAufrufe()
    {
        final Elem<Integer> list = Elem.of(1, 2, 3);
        assertEquals("[1, 9, 2, 3]", Elem.toString(List.insertRecursive(list, 1, 9)));
        assertEquals("[1, 8, 2, 3]", Elem.toString(List.insertRecursive(Elem.of(1, 2, 3), 1, 8)));
    }
}
