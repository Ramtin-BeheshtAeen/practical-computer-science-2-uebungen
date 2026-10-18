package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * Tests für BinarySearch, Klausur WiSe 2023/24, Aufgabe 3 (20 Punkte).
 * Die Tests folgen den Bewertungskriterien: leeres Array (2), fehlender Wert
 * Mitte/Anfang/Ende (je 3), vorhandener Wert Mitte/Anfang/Ende (je 3).
 */
public class BinarySearchTest
{
    /** Aufsteigende Ordnung. */
    private static final Comparator<Integer> UP = (a, b) -> Integer.compare(a, b);

    /** Absteigende Ordnung – prüft, dass wirklich order benutzt wird. */
    private static final Comparator<Integer> DOWN = (a, b) -> Integer.compare(b, a);

    /** Das Test-Array: 1, 3, 5, ..., 17. */
    private static final Integer[] ARRAY = {1, 3, 5, 7, 9, 11, 13, 15, 17};

    /** Bei der Suche in einem leeren Array wird -1 zurückgegeben (2 P.). */
    @Test
    public void testLeeresArray()
    {
        assertEquals(-1, BinarySearch.binarySearch(new Integer[0], 5, UP));
    }

    /** Fehlender Wert in der Mitte des Arrays liefert -1 (3 P.). */
    @Test
    public void testFehlendMitte()
    {
        assertEquals(-1, BinarySearch.binarySearch(ARRAY, 8, UP));
        assertEquals(-1, BinarySearch.binarySearch(ARRAY, 10, UP));
    }

    /** Fehlender Wert am Anfang des Arrays liefert -1 (3 P.). */
    @Test
    public void testFehlendAnfang()
    {
        assertEquals(-1, BinarySearch.binarySearch(ARRAY, 0, UP));
        assertEquals(-1, BinarySearch.binarySearch(ARRAY, 2, UP));
    }

    /** Fehlender Wert am Ende des Arrays liefert -1 (3 P.). */
    @Test
    public void testFehlendEnde()
    {
        assertEquals(-1, BinarySearch.binarySearch(ARRAY, 18, UP));
        assertEquals(-1, BinarySearch.binarySearch(ARRAY, 16, UP));
    }

    /** Vorhandener Wert in der Mitte wird gefunden (3 P.). */
    @Test
    public void testVorhandenMitte()
    {
        assertEquals(4, BinarySearch.binarySearch(ARRAY, 9, UP));
        assertEquals(3, BinarySearch.binarySearch(ARRAY, 7, UP));
    }

    /** Vorhandener Wert am Anfang wird gefunden (3 P.). */
    @Test
    public void testVorhandenAnfang()
    {
        assertEquals(0, BinarySearch.binarySearch(ARRAY, 1, UP));
    }

    /** Vorhandener Wert am Ende wird gefunden (3 P.). */
    @Test
    public void testVorhandenEnde()
    {
        assertEquals(8, BinarySearch.binarySearch(ARRAY, 17, UP));
    }

    /** Alle Werte werden gefunden, auch bei gerader Länge. */
    @Test
    public void testAlleWerte()
    {
        final Integer[] even = {2, 4, 6, 8, 10, 12};
        for (int i = 0; i < even.length; ++i) {
            assertEquals(i, BinarySearch.binarySearch(even, even[i], UP), "Wert " + even[i]);
        }
        assertEquals(0, BinarySearch.binarySearch(new Integer[] {7}, 7, UP));
        assertEquals(-1, BinarySearch.binarySearch(new Integer[] {7}, 8, UP));
    }

    /** Die Suche nutzt die übergebene Ordnung, nicht die natürliche. */
    @Test
    public void testAndereOrdnung()
    {
        final Integer[] down = {9, 7, 5, 3, 1};
        assertEquals(0, BinarySearch.binarySearch(down, 9, DOWN));
        assertEquals(3, BinarySearch.binarySearch(down, 3, DOWN));
        assertEquals(-1, BinarySearch.binarySearch(down, 4, DOWN));
    }
}
