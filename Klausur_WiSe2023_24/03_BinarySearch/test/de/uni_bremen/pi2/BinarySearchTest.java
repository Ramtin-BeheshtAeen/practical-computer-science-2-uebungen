package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse BinarySearch (binäre Suche
 * mit Comparator), Klausur WiSe 2023/24, Aufgabe 3 (20 Punkte).
 *
 * Bei nicht gefundenem Schlüssel liefert die Methode -1.
 */
public class BinarySearchTest
{
    /** Die natürliche aufsteigende Ordnung für Integer. */
    private final Comparator<Integer> order = Comparator.naturalOrder();

    /** In einem leeren Array wird nichts gefunden. */
    @Test
    public void testLeeresArray()
    {
        assertEquals(-1, BinarySearch.binarySearch(new Integer[] {}, 5, order));
    }

    /** Ein vorhandener Schlüssel wird an seiner Position gefunden. */
    @Test
    public void testGefunden()
    {
        final Integer[] array = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(array, 1, order));
        assertEquals(1, BinarySearch.binarySearch(array, 3, order));
        assertEquals(2, BinarySearch.binarySearch(array, 5, order));
        assertEquals(3, BinarySearch.binarySearch(array, 7, order));
        assertEquals(4, BinarySearch.binarySearch(array, 9, order));
    }

    /** Ein nicht vorhandener Schlüssel liefert -1. */
    @Test
    public void testNichtGefunden()
    {
        final Integer[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(array, 0, order));
        assertEquals(-1, BinarySearch.binarySearch(array, 2, order));
        assertEquals(-1, BinarySearch.binarySearch(array, 4, order));
        assertEquals(-1, BinarySearch.binarySearch(array, 8, order));
        assertEquals(-1, BinarySearch.binarySearch(array, 10, order));
    }

    /** In einem einelementigen Array wird korrekt gesucht. */
    @Test
    public void testEinElement()
    {
        final Integer[] array = {5};
        assertEquals(0, BinarySearch.binarySearch(array, 5, order));
        assertEquals(-1, BinarySearch.binarySearch(array, 3, order));
        assertEquals(-1, BinarySearch.binarySearch(array, 7, order));
    }

    /** Der erste und der letzte Schlüssel werden gefunden. */
    @Test
    public void testRaender()
    {
        final Integer[] array = {2, 4, 6, 8, 10, 12};
        assertEquals(0, BinarySearch.binarySearch(array, 2, order));
        assertEquals(5, BinarySearch.binarySearch(array, 12, order));
    }

    /** Die Suche funktioniert auch mit einer absteigenden Ordnung. */
    @Test
    public void testAbsteigendeOrdnung()
    {
        final Integer[] array = {9, 7, 5, 3, 1};
        final Comparator<Integer> descending = Comparator.reverseOrder();
        assertEquals(0, BinarySearch.binarySearch(array, 9, descending));
        assertEquals(2, BinarySearch.binarySearch(array, 5, descending));
        assertEquals(4, BinarySearch.binarySearch(array, 1, descending));
        assertEquals(-1, BinarySearch.binarySearch(array, 6, descending));
    }

    /** Die Suche funktioniert mit einer Ordnung nach String-Länge. */
    @Test
    public void testEigeneOrdnung()
    {
        final String[] array = {"a", "bb", "ccc", "dddd"};
        final Comparator<String> byLength = Comparator.comparingInt(String::length);
        assertEquals(0, BinarySearch.binarySearch(array, "x", byLength));
        assertEquals(2, BinarySearch.binarySearch(array, "yyy", byLength));
        assertEquals(-1, BinarySearch.binarySearch(array, "zzzzz", byLength));
    }

    /** In jedem sortierten Array wird jeder vorhandene Wert gefunden und jeder fehlende mit -1 erkannt. */
    @Test
    public void testSystematisch()
    {
        final Integer[] array = {0, 2, 4, 6, 8, 10, 12, 14};
        for (int key = -2; key <= 16; ++key) {
            final int result = BinarySearch.binarySearch(array, key, order);
            if (key >= 0 && key <= 14 && key % 2 == 0) {
                assertEquals(key / 2, result, "Falsche Fundstelle für " + key);
            }
            else {
                assertEquals(-1, result, "Für " + key + " sollte -1 geliefert werden.");
            }
        }
    }
}
