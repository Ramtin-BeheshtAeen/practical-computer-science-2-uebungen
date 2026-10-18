package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Tests für Partition, Klausur WiSe 2022/23 / SoSe 2026, Aufgabe 3 (20 Punkte).
 */
public class PartitionTest
{
    /**
     * Teilt auf und prüft alles: Rückgabewert, beide Teile, keine Elemente
     * verloren oder dazugekommen.
     * @param values Die Ausgangswerte.
     * @param pivot Das Pivot-Element.
     */
    private static void check(final Integer[] values, final int pivot)
    {
        final Integer[] array = values.clone();
        final int result = Partition.partition(array, pivot);

        int smaller = 0;
        for (final int v : values) {
            if (v < pivot) {
                ++smaller;
            }
        }
        final String desc = Arrays.toString(values) + " mit Pivot " + pivot + " -> " + Arrays.toString(array);
        assertEquals(smaller, result, "Rückgabewert für " + desc);
        for (int i = 0; i < result && i < array.length; ++i) {
            assertTrue(array[i] < pivot, "Index " + i + " müsste < Pivot sein: " + desc);
        }
        for (int i = Math.max(result, 0); i < array.length; ++i) {
            assertTrue(array[i] >= pivot, "Index " + i + " müsste >= Pivot sein: " + desc);
        }
        final Integer[] a = values.clone();
        final Integer[] b = array.clone();
        Arrays.sort(a);
        Arrays.sort(b);
        assertArrayEquals(a, b, "Es dürfen nur Elemente vertauscht werden: " + desc);
    }

    /** Leeres Array. */
    @Test
    public void testLeer()
    {
        check(new Integer[0], 5);
    }

    /** Ein Element, kleiner bzw. größer bzw. gleich. */
    @Test
    public void testEinElement()
    {
        check(new Integer[] {3}, 5);
        check(new Integer[] {7}, 5);
        check(new Integer[] {5}, 5);
    }

    /** Alle kleiner oder alle größer. */
    @Test
    public void testAlleAufEinerSeite()
    {
        check(new Integer[] {1, 2, 3, 4}, 10);
        check(new Integer[] {6, 7, 8, 9}, 5);
    }

    /** Bereits richtig aufgeteilt bzw. genau verkehrt herum. */
    @Test
    public void testSortiertUndUmgekehrt()
    {
        check(new Integer[] {1, 2, 3, 7, 8, 9}, 5);
        check(new Integer[] {9, 8, 7, 3, 2, 1}, 5);
    }

    /** Gemischt, Pivot kommt im Array vor (auch mehrfach). */
    @Test
    public void testGemischtMitPivot()
    {
        check(new Integer[] {5, 1, 8, 5, 3, 9, 2, 5}, 5);
        check(new Integer[] {4, 4, 4, 4}, 4);
    }

    /** Gemischte Arrays mit verschiedenen Pivots. */
    @Test
    public void testGemischt()
    {
        final Integer[] values = {12, 3, 7, 15, 1, 9, 4, 10, 6, 2, 14};
        for (int pivot = 0; pivot <= 16; ++pivot) {
            check(values, pivot);
        }
    }
}
