package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Partition (Array aufteilen
 * anhand eines Pivot-Elements), Klausur WiSe 2022/23, Aufgabe 3 (20 Punkte).
 */
public class PartitionTest
{
    /**
     * Prüft, dass das Array korrekt aufgeteilt ist: links des zurückgegebenen
     * Index steht nur Kleineres als das Pivot, rechts davon (inklusive) nur
     * Größeres oder Gleiches.
     * @param pivot Das Pivot-Element.
     * @param values Die Werte des Arrays.
     */
    private void assertPartitions(final Integer pivot, final Integer... values)
    {
        final Integer[] array = values.clone();
        final int index = Partition.partition(array, pivot);
        assertTrue(index >= 0 && index <= array.length,
                "Rückgabeindex außerhalb des gültigen Bereichs: " + index);
        for (int i = 0; i < index; ++i) {
            assertTrue(array[i].compareTo(pivot) < 0,
                    "Element " + array[i] + " links von Index " + index + " ist nicht kleiner als "
                            + pivot + ".");
        }
        for (int i = index; i < array.length; ++i) {
            assertTrue(array[i].compareTo(pivot) >= 0,
                    "Element " + array[i] + " ab Index " + index + " ist kleiner als " + pivot + ".");
        }
        // Es dürfen nur Elemente umgeordnet, keine hinzugefügt/entfernt werden.
        final Integer[] sortedBefore = values.clone();
        final Integer[] sortedAfter = array.clone();
        java.util.Arrays.sort(sortedBefore);
        java.util.Arrays.sort(sortedAfter);
        assertArrayEquals(sortedBefore, sortedAfter, "Die Multimenge der Elemente hat sich geändert.");
    }

    /** Alle Elemente sind kleiner als das Pivot. */
    @Test
    public void testAlleKleiner()
    {
        assertPartitions(10, 1, 2, 3, 4, 5);
    }

    /** Alle Elemente sind größer oder gleich dem Pivot. */
    @Test
    public void testAlleGroesserGleich()
    {
        assertPartitions(0, 1, 2, 3, 4, 5);
    }

    /** Eine gemischte Belegung wird korrekt aufgeteilt. */
    @Test
    public void testGemischt()
    {
        assertPartitions(5, 8, 2, 9, 1, 5, 7, 3, 6);
    }

    /** Ein Array mit Duplikaten des Pivots wird korrekt aufgeteilt. */
    @Test
    public void testDuplikate()
    {
        assertPartitions(4, 4, 4, 1, 4, 7, 4, 2);
    }

    /** Ein einzelnes Element wird korrekt behandelt. */
    @Test
    public void testEinElement()
    {
        assertPartitions(5, 3);
        assertPartitions(5, 9);
    }

    /** Ein bereits aufgeteiltes Array bleibt korrekt aufgeteilt. */
    @Test
    public void testBereitsAufgeteilt()
    {
        assertPartitions(5, 1, 2, 3, 7, 8, 9);
    }

    /** Viele zufällige Arrays werden korrekt aufgeteilt. */
    @Test
    public void testZufall()
    {
        final java.util.Random random = new java.util.Random(2022);
        for (int test = 0; test < 500; ++test) {
            final Integer[] values = new Integer[1 + random.nextInt(30)];
            for (int i = 0; i < values.length; ++i) {
                values[i] = random.nextInt(20) - 10;
            }
            assertPartitions(random.nextInt(20) - 10, values);
        }
    }
}
