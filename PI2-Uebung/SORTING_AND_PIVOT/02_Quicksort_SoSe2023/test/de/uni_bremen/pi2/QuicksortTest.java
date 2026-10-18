package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Tests für Quicksort, Klausur SoSe 2023, Aufgabe 4 (20 Punkte).
 * Bewertung: 2 Elemente (4), zufällig vorsortiert (8), absteigend
 * vorsortiert (8). Leeres und einelementiges Array müssen funktionieren.
 */
public class QuicksortTest
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
        Quicksort.quicksort(actual);
        assertArrayEquals(expected, actual, "Eingabe " + Arrays.toString(values));
    }

    /** Leeres und einelementiges Array. */
    @Test
    public void testLeerUndEins()
    {
        check(new Integer[0]);
        check(new Integer[] {42});
    }

    /** Ein Array mit 2 Elementen wird korrekt sortiert (4 P.). */
    @Test
    public void testZweiElemente()
    {
        check(new Integer[] {2, 1});
        check(new Integer[] {1, 2});
        check(new Integer[] {3, 3});
    }

    /** Ein zufällig vorsortiertes Array wird korrekt sortiert (8 P.). */
    @Test
    public void testZufaellig()
    {
        final Random random = new Random(2026);
        for (int n = 3; n <= 40; ++n) {
            final Integer[] values = new Integer[n];
            for (int i = 0; i < n; ++i) {
                values[i] = random.nextInt(20);
            }
            check(values);
        }
    }

    /** Ein absteigend vorsortiertes Array wird korrekt sortiert (8 P.). */
    @Test
    public void testAbsteigend()
    {
        final Integer[] values = new Integer[30];
        for (int i = 0; i < values.length; ++i) {
            values[i] = values.length - i;
        }
        check(values);
    }

    /** Bereits aufsteigend sortiert. */
    @Test
    public void testAufsteigend()
    {
        check(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8});
    }

    /** Zeichenketten. */
    @Test
    public void testStrings()
    {
        final String[] words = {"kiwi", "apfel", "mango", "birne"};
        Quicksort.quicksort(words);
        assertArrayEquals(new String[] {"apfel", "birne", "kiwi", "mango"}, words);
    }
}
