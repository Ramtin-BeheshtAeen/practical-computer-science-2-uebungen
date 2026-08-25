package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse BinarySearch, Klausur
 * SoSe 2022, Aufgabe 3 (20 Punkte).
 *
 * Bei nicht gefundenem Schlüssel liefert die Methode -1 - Einfügeposition.
 */
public class BinarySearchTest
{
    /** In einem leeren Array wird nichts gefunden; die Einfügeposition ist 0. */
    @Test
    public void testLeeresArray()
    {
        assertEquals(-1, BinarySearch.binarySearch(new Integer[] {}, 5));
    }

    /** Ein vorhandener Schlüssel wird an seiner Position gefunden. */
    @Test
    public void testGefunden()
    {
        final Integer[] array = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(array, 1));
        assertEquals(2, BinarySearch.binarySearch(array, 5));
        assertEquals(4, BinarySearch.binarySearch(array, 9));
    }

    /** Ein Schlüssel kleiner als alle Elemente hat die Einfügeposition 0. */
    @Test
    public void testKleinerAlsAlle()
    {
        final Integer[] array = {2, 4, 6, 8};
        assertEquals(-1, BinarySearch.binarySearch(array, 1));
    }

    /** Ein Schlüssel größer als alle Elemente hat die Einfügeposition am Ende. */
    @Test
    public void testGroesserAlsAlle()
    {
        final Integer[] array = {2, 4, 6, 8};
        assertEquals(-1 - 4, BinarySearch.binarySearch(array, 9));
    }

    /** Ein Schlüssel zwischen zwei Elementen hat die richtige Einfügeposition. */
    @Test
    public void testDazwischen()
    {
        final Integer[] array = {2, 4, 6, 8};
        assertEquals(-1 - 1, BinarySearch.binarySearch(array, 3));
        assertEquals(-1 - 2, BinarySearch.binarySearch(array, 5));
        assertEquals(-1 - 3, BinarySearch.binarySearch(array, 7));
    }

    /** In einem einelementigen Array wird korrekt gesucht. */
    @Test
    public void testEinElement()
    {
        final Integer[] array = {5};
        assertEquals(0, BinarySearch.binarySearch(array, 5));
        assertEquals(-1, BinarySearch.binarySearch(array, 3));
        assertEquals(-1 - 1, BinarySearch.binarySearch(array, 7));
    }

    /**
     * Für jeden Schlüssel gilt: wird er gefunden, steht er an der gelieferten
     * Position; wird er nicht gefunden, ergibt die Einfügeposition ein weiterhin
     * sortiertes Array.
     */
    @Test
    public void testKonsistenzMitEinfuegeposition()
    {
        final Integer[] array = {0, 2, 4, 6, 8, 10, 12};
        for (int key = -2; key <= 14; ++key) {
            final int result = BinarySearch.binarySearch(array, key);
            if (result >= 0) {
                assertEquals(Integer.valueOf(key), array[result], "Falsche Fundstelle für " + key);
            }
            else {
                final int insert = -1 - result;
                assertTrue(insert >= 0 && insert <= array.length, "Einfügeposition außerhalb: " + insert);
                if (insert > 0) {
                    assertTrue(array[insert - 1] < key, "Element vor Einfügeposition nicht kleiner.");
                }
                if (insert < array.length) {
                    assertTrue(array[insert] > key, "Element an Einfügeposition nicht größer.");
                }
            }
        }
    }
}
