package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für BinarySearch, Klausur SoSe 2022, Aufgabe 3 (20 Punkte).
 * Die Tests folgen den Bewertungskriterien: leeres Array (2), fehlender Wert
 * Mitte/Anfang/Ende (je 3), vorhandener Wert Mitte/Anfang/Ende (je 3).
 */
public class BinarySearchTest
{
    /** Das Test-Array: 1, 3, 5, ..., 17. */
    private static final Integer[] ARRAY = {1, 3, 5, 7, 9, 11, 13, 15, 17};

    /** Bei der Suche in einem leeren Array wird -1 zurückgegeben (2 P.). */
    @Test
    public void testLeeresArray()
    {
        assertEquals(-1, BinarySearch.binarySearch(new Integer[0], 5));
    }

    /** Fehlender Wert in der Mitte: richtige Position (3 P.). */
    @Test
    public void testFehlendMitte()
    {
        assertEquals(-1 - 4, BinarySearch.binarySearch(ARRAY, 8));
        assertEquals(-1 - 5, BinarySearch.binarySearch(ARRAY, 10));
    }

    /** Fehlender Wert am Anfang: richtige Position (3 P.). */
    @Test
    public void testFehlendAnfang()
    {
        assertEquals(-1 - 0, BinarySearch.binarySearch(ARRAY, 0));
        assertEquals(-1 - 1, BinarySearch.binarySearch(ARRAY, 2));
    }

    /** Fehlender Wert am Ende: richtige Position (3 P.). */
    @Test
    public void testFehlendEnde()
    {
        assertEquals(-1 - 9, BinarySearch.binarySearch(ARRAY, 18));
        assertEquals(-1 - 8, BinarySearch.binarySearch(ARRAY, 16));
    }

    /** Vorhandener Wert in der Mitte wird gefunden (3 P.). */
    @Test
    public void testVorhandenMitte()
    {
        assertEquals(4, BinarySearch.binarySearch(ARRAY, 9));
        assertEquals(5, BinarySearch.binarySearch(ARRAY, 11));
    }

    /** Vorhandener Wert am Anfang wird gefunden (3 P.). */
    @Test
    public void testVorhandenAnfang()
    {
        assertEquals(0, BinarySearch.binarySearch(ARRAY, 1));
    }

    /** Vorhandener Wert am Ende wird gefunden (3 P.). */
    @Test
    public void testVorhandenEnde()
    {
        assertEquals(8, BinarySearch.binarySearch(ARRAY, 17));
    }

    /** Ein einelementiges Array: davor, gleich, dahinter. */
    @Test
    public void testEinElement()
    {
        final Integer[] one = {7};
        assertEquals(-1, BinarySearch.binarySearch(one, 3));
        assertEquals(0, BinarySearch.binarySearch(one, 7));
        assertEquals(-2, BinarySearch.binarySearch(one, 9));
    }

    /** Für jeden fehlenden Wert ergibt sich genau die Einfügeposition. */
    @Test
    public void testAlleEinfuegepositionen()
    {
        for (int k = 0; k <= 18; k += 2) {
            assertEquals(-1 - k / 2, BinarySearch.binarySearch(ARRAY, k), "Schlüssel " + k);
        }
    }
}
