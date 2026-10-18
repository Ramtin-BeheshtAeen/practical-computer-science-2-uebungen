package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für Dijkstra, Klausur SoSe 2022 / WiSe 2023/24 / SoSe 2026,
 * Aufgabe 5 (20 Punkte). Die Tests folgen den Bewertungskriterien:
 * Nachbar des Startknotens (5), Knoten mit mehreren Alternativen (5),
 * komplexerer Graph (10).
 */
public class DijkstraTest
{
    /** Abkürzung für "keine Kante". */
    private static final Integer N = null;

    /** Abkürzung für "nicht erreichbar". */
    private static final int INF = Integer.MAX_VALUE;

    /** Der Startknoten allein hat Distanz 0. */
    @Test
    public void testNurStart()
    {
        assertArrayEquals(new int[] {0}, Dijkstra.shortestDistances(new Integer[][] {{N}}, 0));
    }

    /** Der kürzeste Weg zu einem Nachbarn des Startknotens (5 P.). */
    @Test
    public void testNachbar()
    {
        final Integer[][] m = {
            {N, 4},
            {N, N}
        };
        assertArrayEquals(new int[] {0, 4}, Dijkstra.shortestDistances(m, 0));
    }

    /** Der kürzeste Weg zu einem Knoten mit mehreren Alternativen (5 P.). */
    @Test
    public void testMehrereAlternativen()
    {
        // 0 -10-> 1 direkt, oder 0 -3-> 2 -2-> 3 -4-> 1 = 9
        final Integer[][] m = {
            {N, 10, 3, N},
            {N, N, N, N},
            {N, N, N, 2},
            {N, 4, N, N}
        };
        assertArrayEquals(new int[] {0, 9, 3, 5}, Dijkstra.shortestDistances(m, 0));
    }

    /** Eine teurere Strecke darf eine billigere nicht überschreiben. */
    @Test
    public void testKeineVerschlechterung()
    {
        final Integer[][] m = {
            {N, 1, 5},
            {N, N, 1},
            {N, N, N}
        };
        assertArrayEquals(new int[] {0, 1, 2}, Dijkstra.shortestDistances(m, 0));
    }

    /** Die kürzesten Wege zu allen Knoten in einem komplexeren Graphen (10 P.). */
    @Test
    public void testKomplexerGraph()
    {
        // Ungerichteter Graph (Kanten in beide Richtungen), 6 Knoten.
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
        assertArrayEquals(new int[] {0, 7, 9, 20, 20, 11}, Dijkstra.shortestDistances(m, 0));
        assertArrayEquals(new int[] {20, 21, 11, 6, 0, 9}, Dijkstra.shortestDistances(m, 4));
    }

    /** Ein anderer Startknoten und ein nicht erreichbarer Knoten. */
    @Test
    public void testAndererStartUnerreichbar()
    {
        final Integer[][] m = {
            {N, 2, N, N},
            {N, N, 3, N},
            {1, N, N, N},
            {N, N, N, N}
        };
        assertArrayEquals(new int[] {1, 3, 0, INF}, Dijkstra.shortestDistances(m, 2));
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
