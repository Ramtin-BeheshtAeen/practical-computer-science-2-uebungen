package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Tests für MergeSort, Wiederholungsklausur WiSe 2019/20 / Klausur SoSe 2021.
 */
public class MergeSortTest
{
    /**
     * Sortiert eine Kopie und vergleicht mit Arrays.sort.
     * @param values Die Werte.
     */
    private static void check(final Integer[] values)
    {
        final Integer[] expected = values.clone();
        Arrays.sort(expected);
        final Integer[] actual = values.clone();
        MergeSort.mergeSort(actual);
        assertArrayEquals(expected, actual, "Eingabe " + Arrays.toString(values));
    }

    /** Leeres und einelementiges Array. */
    @Test
    public void testLeerUndEins()
    {
        check(new Integer[0]);
        check(new Integer[] {42});
    }

    /** Zwei und drei Elemente. */
    @Test
    public void testKlein()
    {
        check(new Integer[] {2, 1});
        check(new Integer[] {3, 1, 2});
    }

    /** Zufällige Arrays verschiedener (auch ungerader) Länge. */
    @Test
    public void testZufaellig()
    {
        final Random random = new Random(2020);
        for (int n = 3; n <= 40; ++n) {
            final Integer[] values = new Integer[n];
            for (int i = 0; i < n; ++i) {
                values[i] = random.nextInt(20);
            }
            check(values);
        }
    }

    /** Absteigend vorsortiert. */
    @Test
    public void testAbsteigend()
    {
        final Integer[] values = new Integer[31];
        for (int i = 0; i < values.length; ++i) {
            values[i] = values.length - i;
        }
        check(values);
    }

    /** MergeSort ist stabil: gleiche Schlüssel behalten ihre Reihenfolge. */
    @Test
    public void testStabil()
    {
        final Item[] items = {new Item(2, 'a'), new Item(1, 'b'), new Item(2, 'c'), new Item(1, 'd')};
        MergeSort.mergeSort(items);
        assertEquals("1b 1d 2a 2c", items[0] + " " + items[1] + " " + items[2] + " " + items[3]);
    }

    /** Ein Element mit Schlüssel und Markierung, verglichen nur über den Schlüssel. */
    private static class Item implements Comparable<Item>
    {
        /** Der Schlüssel. */
        final int key;

        /** Die Markierung. */
        final char tag;

        /**
         * Konstruktor.
         * @param key Der Schlüssel.
         * @param tag Die Markierung.
         */
        Item(final int key, final char tag)
        {
            this.key = key;
            this.tag = tag;
        }

        @Override
        public int compareTo(final Item other)
        {
            return Integer.compare(key, other.key);
        }

        @Override
        public String toString()
        {
            return "" + key + tag;
        }
    }
}
