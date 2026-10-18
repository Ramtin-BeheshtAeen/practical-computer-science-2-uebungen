package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für ShortestPath, Wiederholungsklausur WiSe 2019/20, Aufgabe 4
 * (20 Punkte). Gleiche Graphen wie beim aktuellen Dijkstra – das Ergebnis
 * muss identisch sein.
 */
public class ShortestPathTest
{
    /** Abkürzung für "keine Kante". */
    private static final Integer N = null;

    /** Abkürzung für "nicht erreichbar". */
    private static final int INF = Integer.MAX_VALUE;

    /** Nur der Startknoten. */
    @Test
    public void testNurStart()
    {
        assertArrayEquals(new int[] {0, INF}, ShortestPath.shortestDistances(new Integer[][] {{N, N}, {N, N}}, 0));
    }

    /** Ein Nachbar des Startknotens. */
    @Test
    public void testNachbar()
    {
        final Integer[][] m = {
            {N, 4},
            {N, N}
        };
        assertArrayEquals(new int[] {0, 4}, ShortestPath.shortestDistances(m, 0));
    }

    /** Der Umweg ist kürzer als die direkte Kante. */
    @Test
    public void testMehrereAlternativen()
    {
        final Integer[][] m = {
            {N, 10, 3, N},
            {N, N, N, N},
            {N, N, N, 2},
            {N, 4, N, N}
        };
        assertArrayEquals(new int[] {0, 9, 3, 5}, ShortestPath.shortestDistances(m, 0));
    }

    /** Ein Knoten, der zweimal geöffnet wird, zählt nur mit der kürzeren Distanz. */
    @Test
    public void testDoppeltGeoeffnet()
    {
        final Integer[][] m = {
            {N, 1, 5},
            {N, N, 1},
            {N, N, N}
        };
        assertArrayEquals(new int[] {0, 1, 2}, ShortestPath.shortestDistances(m, 0));
    }

    /** Ein komplexerer Graph mit Zyklen. */
    @Test
    public void testKomplexerGraph()
    {
        final Integer[][] m = new Integer[6][6];
        edge(m, 0, 1, 7);
        edge(m, 0, 2, 9);
        edge(m, 0, 5, 14);
        edge(m, 1, 2, 10);
        edge(m, 1, 3, 15);
        edge(m, 2, 3, 11);
        edge(m, 2, 5, 2);
        edge(m, 3, 4, 6);
        edge(m, 4, 5, 9);
        assertArrayEquals(new int[] {0, 7, 9, 20, 20, 11}, ShortestPath.shortestDistances(m, 0));
    }

    /**
     * Trägt eine ungerichtete Kante ein.
     * @param m Die Matrix.
     * @param a Der eine Knoten.
     * @param b Der andere Knoten.
     * @param d Die Distanz.
     */
    private static void edge(final Integer[][] m, final int a, final int b, final int d)
    {
        m[a][b] = d;
        m[b][a] = d;
    }
}
