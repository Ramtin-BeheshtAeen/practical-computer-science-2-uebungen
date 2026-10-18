package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für Merge, Klausur SoSe 2019 / SoSe 2021.
 */
public class MergeTest
{
    /** Beide leer. */
    @Test
    public void testBeideLeer()
    {
        assertArrayEquals(new Integer[0], Merge.merge(new Integer[0], new Integer[0]));
    }

    /** Eines der beiden Arrays ist leer. */
    @Test
    public void testEinesLeer()
    {
        assertArrayEquals(new Integer[] {1, 2, 3}, Merge.merge(new Integer[] {1, 2, 3}, new Integer[0]));
        assertArrayEquals(new Integer[] {1, 2, 3}, Merge.merge(new Integer[0], new Integer[] {1, 2, 3}));
    }

    /** Abwechselnde Elemente. */
    @Test
    public void testAbwechselnd()
    {
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6},
                Merge.merge(new Integer[] {1, 3, 5}, new Integer[] {2, 4, 6}));
    }

    /** Ein Array komplett vor dem anderen, unterschiedliche Längen. */
    @Test
    public void testHintereinander()
    {
        assertArrayEquals(new Integer[] {1, 2, 7, 8, 9},
                Merge.merge(new Integer[] {7, 8, 9}, new Integer[] {1, 2}));
        assertArrayEquals(new Integer[] {1, 2, 7, 8, 9},
                Merge.merge(new Integer[] {1, 2}, new Integer[] {7, 8, 9}));
    }

    /** Gleiche Elemente, Reste am Ende. */
    @Test
    public void testGleicheUndReste()
    {
        assertArrayEquals(new Integer[] {1, 2, 2, 2, 3, 10, 11, 12},
                Merge.merge(new Integer[] {2, 2, 10, 11, 12}, new Integer[] {1, 2, 3}));
    }

    /** Bei Gleichheit kommt das Element aus array1 zuerst. */
    @Test
    public void testStabil()
    {
        final String a = new String("x");
        final String b = new String("x");
        final String[] result = Merge.merge(new String[] {a}, new String[] {b});
        assertSame(a, result[0]);
        assertSame(b, result[1]);
    }
}
