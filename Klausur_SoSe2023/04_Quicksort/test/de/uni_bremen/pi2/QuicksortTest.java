package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Quicksort.
 * Die Tests decken die Klausur SoSe 2023, Aufgabe 4 ab (20 Punkte).
 */
public class QuicksortTest
{
    /**
     * Sortiert eine Kopie des Arrays und vergleicht das Ergebnis mit dem
     * Ergebnis von Arrays.sort.
     * @param values Die Werte, die sortiert werden.
     */
    private void assertSorts(final Integer... values)
    {
        final Integer[] actual = values.clone();
        final Integer[] expected = values.clone();
        Arrays.sort(expected);
        Quicksort.quicksort(actual);
        assertArrayEquals(expected, actual,
                "Falsch sortiert. Eingabe war " + Arrays.toString(values) + ".");
    }

    /** Ein leeres Array wird korrekt behandelt. */
    @Test
    public void testLeeresArray()
    {
        assertSorts();
    }

    /** Ein Array mit einem Element wird korrekt behandelt. */
    @Test
    public void testEinElement()
    {
        assertSorts(42);
    }

    /** Ein Array mit zwei Elementen wird in beiden Reihenfolgen sortiert. */
    @Test
    public void testZweiElemente()
    {
        assertSorts(1, 2);
        assertSorts(2, 1);
    }

    /** Ein bereits sortiertes Array bleibt sortiert. */
    @Test
    public void testBereitsSortiert()
    {
        assertSorts(1, 2, 3, 4, 5, 6, 7, 8);
    }

    /** Ein absteigend sortiertes Array wird korrekt umgedreht. */
    @Test
    public void testAbsteigend()
    {
        assertSorts(8, 7, 6, 5, 4, 3, 2, 1);
    }

    /** Ein Array aus lauter gleichen Elementen wird korrekt behandelt. */
    @Test
    public void testAlleGleich()
    {
        assertSorts(5, 5, 5, 5, 5, 5);
    }

    /** Ein Array mit Duplikaten wird korrekt sortiert. */
    @Test
    public void testDuplikate()
    {
        assertSorts(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
    }

    /** Ein Array mit negativen Zahlen wird korrekt sortiert. */
    @Test
    public void testNegativeZahlen()
    {
        assertSorts(0, -3, 7, -1, -3, 2, -8);
    }

    /** Auch andere Typen als Integer werden sortiert. */
    @Test
    public void testStrings()
    {
        final String[] array = {"delta", "alpha", "echo", "charlie", "bravo"};
        Quicksort.quicksort(array);
        assertArrayEquals(new String[] {"alpha", "bravo", "charlie", "delta", "echo"}, array);
    }

    /** Viele zufällige Arrays werden korrekt sortiert. */
    @Test
    public void testZufall()
    {
        final Random random = new Random(2023);
        for (int test = 0; test < 500; ++test) {
            final Integer[] values = new Integer[random.nextInt(50)];
            for (int i = 0; i < values.length; ++i) {
                values[i] = random.nextInt(30) - 15;
            }
            assertSorts(values);
        }
    }

    /** Ein großes Array wird korrekt sortiert. */
    @Test
    public void testGrossesArray()
    {
        final Random random = new Random(1);
        final Integer[] values = new Integer[10000];
        for (int i = 0; i < values.length; ++i) {
            values[i] = random.nextInt();
        }
        assertSorts(values);
    }
}
