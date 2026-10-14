package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Array (Anhängen an Array
 * dynamischer Größe), Klausur SoSe 2026, Aufgabe 1 (20 Punkte).
 *
 * Die Tests folgen den Zeilen der Bewertung:
 * Größe (2 + 4), Kapazität (2 + 4), Auslesen (2 + 4), jenseits der Größe (2).
 */
public class ArrayTest
{
    /** Erwartete Kapazitäten nach dem 1., 2., ..., 5. add. */
    private static final int[] CAPACITIES = {1, 2, 4, 4, 8};

    /**
     * Erzeugt ein Array mit den Werten "a", "b", ... in dieser Reihenfolge.
     * @param n Die Anzahl der Elemente.
     * @return Das gefüllte Array.
     */
    private Array<String> filled(final int n)
    {
        final Array<String> array = new Array<>();
        for (int i = 0; i < n; ++i) {
            array.add(String.valueOf((char) ('a' + i)));
        }
        return array;
    }

    /** Ein neues Array ist leer und hat keine Kapazität. */
    @Test
    public void testLeer()
    {
        final Array<String> array = new Array<>();
        assertEquals(0, array.size());
        assertEquals(0, array.capacity());
    }

    // ------------------------------------------------------------------
    // Größe
    // ------------------------------------------------------------------

    /** Die Größe verhält sich beim Hinzufügen des ersten Elements korrekt (2 P.). */
    @Test
    public void testGroesseErstesElement()
    {
        assertEquals(1, filled(1).size());
    }

    /** Die Größe verhält sich beim Hinzufügen von 4 weiteren Elementen korrekt (4 P.). */
    @Test
    public void testGroesseVierWeitere()
    {
        final Array<String> array = filled(1);
        for (int i = 2; i <= 5; ++i) {
            array.add("x" + i);
            assertEquals(i, array.size(), "Größe nach " + i + " Elementen");
        }
    }

    // ------------------------------------------------------------------
    // Kapazität
    // ------------------------------------------------------------------

    /** Die Kapazität verhält sich beim Hinzufügen des ersten Elements korrekt (2 P.). */
    @Test
    public void testKapazitaetErstesElement()
    {
        assertEquals(1, filled(1).capacity(),
                "Aus Kapazität 0 muss mindestens um ein Element gewachsen werden.");
    }

    /** Die Kapazität verhält sich beim Hinzufügen von 4 weiteren Elementen korrekt (4 P.). */
    @Test
    public void testKapazitaetVierWeitere()
    {
        final Array<String> array = filled(1);
        for (int i = 2; i <= 5; ++i) {
            array.add("x" + i);
            assertEquals(CAPACITIES[i - 1], array.capacity(),
                    "Kapazität nach " + i + " Elementen");
        }
    }

    /** Ist noch Platz, ändert sich die Kapazität nicht. */
    @Test
    public void testKapazitaetBleibtBeiFreiemPlatz()
    {
        final Array<String> array = filled(3);   // Kapazität 4, ein Platz frei
        array.add("d");
        assertEquals(4, array.capacity());
        assertEquals(4, array.size());
    }

    // ------------------------------------------------------------------
    // Auslesen
    // ------------------------------------------------------------------

    /** Das Auslesen verhält sich nach dem Hinzufügen des ersten Elements korrekt (2 P.). */
    @Test
    public void testAuslesenErstesElement()
    {
        assertEquals("a", filled(1).get(0));
    }

    /** Das Auslesen verhält sich nach dem Hinzufügen von 4 weiteren Elementen korrekt (4 P.). */
    @Test
    public void testAuslesenVierWeitere()
    {
        final Array<String> array = filled(1);
        for (int i = 2; i <= 5; ++i) {
            array.add(String.valueOf((char) ('a' + i - 1)));
            for (int j = 0; j < i; ++j) {
                assertEquals(String.valueOf((char) ('a' + j)), array.get(j),
                        "Element " + j + " nach " + i + " Elementen");
            }
        }
    }

    /** Auch nach mehreren Verdopplungen bleiben alle Werte erhalten. */
    @Test
    public void testVieleElemente()
    {
        final Array<Integer> array = new Array<>();
        for (int i = 0; i < 100; ++i) {
            array.add(i);
        }
        assertEquals(100, array.size());
        assertEquals(128, array.capacity());
        for (int i = 0; i < 100; ++i) {
            assertEquals(Integer.valueOf(i), array.get(i));
        }
    }

    /** null darf als Element gespeichert werden. */
    @Test
    public void testNullElement()
    {
        final Array<String> array = new Array<>();
        array.add(null);
        assertEquals(1, array.size());
        assertNull(array.get(0));
    }

    // ------------------------------------------------------------------
    // Auslesen jenseits der Größe
    // ------------------------------------------------------------------

    /** Das Auslesen jenseits der Größe wird korrekt erkannt (2 P.). */
    @Test
    public void testAuslesenJenseitsDerGroesse()
    {
        // Leeres Array.
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Array<String>().get(0));

        // Index == size, obwohl die Kapazität größer ist (3 Elemente, Kapazität 4).
        final Array<String> array = filled(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(3),
                "Index 3 liegt im Speicher, aber jenseits der Größe.");

        // Weit dahinter.
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(10));
    }

    /** Negative Indizes liegen ebenfalls außerhalb. */
    @Test
    public void testNegativerIndex()
    {
        final Array<String> array = filled(2);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(-1));
    }
}
