package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für BinarySearch, Klausur SoSe 2019, Aufgabe 2 (20 Punkte).
 */
public class BinarySearchTest
{
    /** Das Test-Array: 1, 3, 5, ..., 17. */
    private static final Integer[] ARRAY = {1, 3, 5, 7, 9, 11, 13, 15, 17};

    /** Leeres Array. */
    @Test
    public void testLeeresArray()
    {
        assertEquals(-1, BinarySearch.binarySearch(new Integer[0], 5));
    }

    /** Jedes vorhandene Element wird an seinem Index gefunden. */
    @Test
    public void testAlleVorhanden()
    {
        for (int i = 0; i < ARRAY.length; ++i) {
            assertEquals(i, BinarySearch.binarySearch(ARRAY, ARRAY[i]), "Wert " + ARRAY[i]);
        }
    }

    /** Fehlende Werte vor, zwischen und hinter den Elementen. */
    @Test
    public void testAlleFehlend()
    {
        for (int k = 0; k <= 18; k += 2) {
            assertEquals(-1, BinarySearch.binarySearch(ARRAY, k), "Schlüssel " + k);
        }
    }

    /** Gerade Länge und ein einzelnes Element. */
    @Test
    public void testRandfaelle()
    {
        final Integer[] even = {10, 20, 30, 40};
        assertEquals(0, BinarySearch.binarySearch(even, 10));
        assertEquals(3, BinarySearch.binarySearch(even, 40));
        assertEquals(-1, BinarySearch.binarySearch(even, 25));
        assertEquals(0, BinarySearch.binarySearch(new Integer[] {7}, 7));
        assertEquals(-1, BinarySearch.binarySearch(new Integer[] {7}, 6));
    }

    /** Funktioniert auch mit Zeichenketten. */
    @Test
    public void testStrings()
    {
        final String[] words = {"apfel", "birne", "kiwi", "mango", "pflaume"};
        assertEquals(2, BinarySearch.binarySearch(words, "kiwi"));
        assertEquals(-1, BinarySearch.binarySearch(words, "banane"));
    }
}
