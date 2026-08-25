package de.uni_bremen.pi2;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/** Test-Klasse für die Klasse {@link Sort}. */
public class SortTest
{
    /**
     * Element mit Schlüssel und Kennung. Verglichen wird nur der Schlüssel,
     * die Kennung dient dazu, die Stabilität eines Sortierverfahrens zu prüfen.
     */
    private static final class Item implements Comparable<Item>
    {
        final int key;
        final int tag;

        Item(final int key, final int tag)
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
            return key + "/" + tag;
        }
    }

    /**
     * Prüft, dass das Ergebnis aufsteigend sortiert ist und dieselben Elemente
     * enthält wie vorher. Letzteres deckt Fehler auf, bei denen Elemente
     * überschrieben oder dupliziert werden (z.B. falsche arraycopy-Längen).
     * @param original Der Zustand des Arrays vor dem Sortieren.
     * @param actual Das sortierte Array.
     * @param <T> Der Typ der Elemente.
     */
    private static <T extends Comparable<T>> void assertSortedPermutation(final T[] original,
                                                                          final T[] actual)
    {
        final T[] expected = Arrays.copyOf(original, original.length);
        Arrays.sort(expected);
        assertArrayEquals(expected, actual,
                "Erwartet: " + Arrays.toString(expected) + ", war: " + Arrays.toString(actual));
    }

    /**
     * Liefert ein Array mit pseudo-zufälligen Zahlen. Der feste Startwert sorgt
     * dafür, dass fehlschlagende Tests reproduzierbar sind.
     * @param length Die Länge des Arrays.
     * @param bound Die Zahlen liegen im Bereich [0, bound).
     * @param seed Der Startwert des Zufallszahlengenerators.
     * @return Das gefüllte Array.
     */
    private static Integer[] random(final int length, final int bound, final long seed)
    {
        final Random random = new Random(seed);
        final Integer[] a = new Integer[length];
        for (int i = 0; i < length; ++i) {
            a[i] = random.nextInt(bound);
        }
        return a;
    }


    // ------------------------------------------------------------------
    // Aufgabe 1: insertionSort
    // ------------------------------------------------------------------

    @Test
    void insertionSortLeeresArray()
    {
        final Integer[] a = {};
        Sort.insertionSort(a);
        assertEquals(0, a.length);
    }

    @Test
    void insertionSortEinElement()
    {
        final Integer[] a = {42};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{42}, a);
    }

    @Test
    void insertionSortZweiElementeVertauscht()
    {
        final Integer[] a = {2, 1};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{1, 2}, a);
    }

    @Test
    void insertionSortBereitsSortiert()
    {
        final Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, a);
    }

    @Test
    void insertionSortAbsteigend()
    {
        final Integer[] a = {7, 6, 5, 4, 3, 2, 1};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, a);
    }

    @Test
    void insertionSortAlleGleich()
    {
        final Integer[] a = {5, 5, 5, 5, 5};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, a);
    }

    @Test
    void insertionSortMitDuplikaten()
    {
        final Integer[] original = {3, 1, 3, 2, 1, 2, 3, 1};
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.insertionSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void insertionSortNeuesMinimumWandertNachVorn()
    {
        // Das letzte Element muss über das gesamte Array geschoben werden.
        final Integer[] a = {2, 3, 4, 5, 1};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
    }

    @Test
    void insertionSortNeuesMaximumBleibtLiegen()
    {
        // Hier darf gar nichts verschoben werden (Länge 0 bei arraycopy).
        final Integer[] a = {1, 2, 3, 4, 5, 99};
        Sort.insertionSort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 99}, a);
    }

    @Test
    void insertionSortStrings()
    {
        final String[] original = {"Kirsche", "Apfel", "Banane", "Apfel", "Dattel"};
        final String[] a = Arrays.copyOf(original, original.length);
        Sort.insertionSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void insertionSortZufall()
    {
        for (int length = 0; length < 60; ++length) {
            final Integer[] original = random(length, 1000, length);
            final Integer[] a = Arrays.copyOf(original, original.length);
            Sort.insertionSort(a);
            assertSortedPermutation(original, a);
        }
    }

    @Test
    void insertionSortZufallVieleDuplikate()
    {
        final Integer[] original = random(200, 5, 4711);
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.insertionSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void insertionSortIstStabil()
    {
        // Gleiche Schlüssel, aufsteigende Kennungen in der Eingabe.
        final Item[] a = {
                new Item(2, 0), new Item(1, 1), new Item(2, 2), new Item(1, 3),
                new Item(2, 4), new Item(0, 5), new Item(1, 6), new Item(0, 7)
        };
        Sort.insertionSort(a);

        // Schlüssel aufsteigend ...
        for (int i = 1; i < a.length; ++i) {
            assertTrue(a[i - 1].key <= a[i].key,
                    "Nicht sortiert an Position " + i + ": " + Arrays.toString(a));
        }

        // ... und bei gleichem Schlüssel die ursprüngliche Reihenfolge erhalten.
        for (int i = 1; i < a.length; ++i) {
            if (a[i - 1].key == a[i].key) {
                assertTrue(a[i - 1].tag < a[i].tag,
                        "Nicht stabil an Position " + i + ": " + Arrays.toString(a));
            }
        }
    }

    @Test
    void insertionSortStabilBeiVielenGleichen()
    {
        final int length = 100;
        final Item[] a = new Item[length];
        for (int i = 0; i < length; ++i) {
            a[i] = new Item(i % 3, i);
        }
        Sort.insertionSort(a);

        for (int i = 1; i < a.length; ++i) {
            assertTrue(a[i - 1].key < a[i].key || a[i - 1].tag < a[i].tag,
                    "Nicht stabil/sortiert an Position " + i);
        }
    }


    // ------------------------------------------------------------------
    // Aufgabe 2: quickSort
    // ------------------------------------------------------------------

    @Test
    void quickSortLeeresArray()
    {
        final Integer[] a = {};
        Sort.quickSort(a);
        assertEquals(0, a.length);
    }

    @Test
    void quickSortEinElement()
    {
        final Integer[] a = {42};
        Sort.quickSort(a);
        assertArrayEquals(new Integer[]{42}, a);
    }

    @Test
    void quickSortZweiElementeVertauscht()
    {
        final Integer[] a = {2, 1};
        Sort.quickSort(a);
        assertArrayEquals(new Integer[]{1, 2}, a);
    }

    @Test
    void quickSortBereitsSortiert()
    {
        final Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        Sort.quickSort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, a);
    }

    @Test
    void quickSortAbsteigend()
    {
        final Integer[] a = {7, 6, 5, 4, 3, 2, 1};
        Sort.quickSort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, a);
    }

    @Test
    void quickSortAlleGleich()
    {
        // Hier muss selectPivot null liefern und die Rekursion sofort enden.
        final Integer[] a = {5, 5, 5, 5, 5, 5, 5, 5};
        Sort.quickSort(a);
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5, 5, 5, 5}, a);
    }

    @Test
    void quickSortNurZweiVerschiedeneWerte()
    {
        final Integer[] original = {1, 0, 1, 1, 0, 0, 1, 0, 0, 1};
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void quickSortMinimumAmAnfang()
    {
        // Das erste Element ist das kleinste: selectPivot darf es nicht wählen.
        final Integer[] original = {0, 9, 3, 7, 1, 8, 2};
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void quickSortMinimumMehrfachAmAnfang()
    {
        final Integer[] original = {0, 0, 0, 0, 5, 0, 0, 3};
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void quickSortGrossesMinimumAmEnde()
    {
        final Integer[] original = {5, 5, 5, 5, 5, 5, 1};
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void quickSortStrings()
    {
        final String[] original = {"Kirsche", "Apfel", "Banane", "Apfel", "Dattel", "Apfel"};
        final String[] a = Arrays.copyOf(original, original.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void quickSortZufall()
    {
        for (int length = 0; length < 60; ++length) {
            final Integer[] original = random(length, 1000, length);
            final Integer[] a = Arrays.copyOf(original, original.length);
            Sort.quickSort(a);
            assertSortedPermutation(original, a);
        }
    }

    @Test
    void quickSortZufallVieleDuplikate()
    {
        for (int seed = 0; seed < 20; ++seed) {
            final Integer[] original = random(300, 3, seed);
            final Integer[] a = Arrays.copyOf(original, original.length);
            Sort.quickSort(a);
            assertSortedPermutation(original, a);
        }
    }

    @Test
    void quickSortGrossesArray()
    {
        // Läuft die Rekursion aus dem Ruder (Endlosrekursion), gibt es hier
        // einen StackOverflowError statt eines sortierten Arrays.
        final Integer[] original = random(20000, 100000, 12345);
        final Integer[] a = Arrays.copyOf(original, original.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void quickSortGrossesArraySortiert()
    {
        final Integer[] a = new Integer[10000];
        for (int i = 0; i < a.length; ++i) {
            a[i] = i;
        }
        final Integer[] original = Arrays.copyOf(a, a.length);
        Sort.quickSort(a);
        assertSortedPermutation(original, a);
    }

    @Test
    void insertionSortUndQuickSortLiefernDasGleiche()
    {
        final Integer[] original = random(500, 50, 999);
        final Integer[] a = Arrays.copyOf(original, original.length);
        final Integer[] b = Arrays.copyOf(original, original.length);
        Sort.insertionSort(a);
        Sort.quickSort(b);
        assertArrayEquals(a, b);
    }
}
