package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für MinimumSpanningTree, Klausur WiSe 2022/23, Aufgabe 5 (20 Punkte).
 * Alle Kantengewichte sind verschieden, daher ist der Baum eindeutig.
 */
public class MinimumSpanningTreeTest
{
    /**
     * Trägt eine ungerichtete Kante ein.
     * @param m Die Matrix.
     * @param a Der eine Knoten.
     * @param b Der andere Knoten.
     * @param w Das Gewicht.
     */
    private static void edge(final Integer[][] m, final int a, final int b, final int w)
    {
        m[a][b] = w;
        m[b][a] = w;
    }

    /** Ein einzelner Knoten ist sein eigener Vorgänger. */
    @Test
    public void testEinKnoten()
    {
        assertArrayEquals(new int[] {0}, MinimumSpanningTree.minimumSpanningTree(new Integer[1][1], 0));
    }

    /** Zwei verbundene Knoten. */
    @Test
    public void testZweiKnoten()
    {
        final Integer[][] m = new Integer[2][2];
        edge(m, 0, 1, 5);
        assertArrayEquals(new int[] {0, 0}, MinimumSpanningTree.minimumSpanningTree(m, 0));
        assertArrayEquals(new int[] {1, 1}, MinimumSpanningTree.minimumSpanningTree(m, 1));
    }

    /** Im Dreieck wird die teuerste Kante weggelassen. */
    @Test
    public void testDreieck()
    {
        final Integer[][] m = new Integer[3][3];
        edge(m, 0, 1, 1);
        edge(m, 1, 2, 2);
        edge(m, 0, 2, 3);
        assertArrayEquals(new int[] {0, 0, 1}, MinimumSpanningTree.minimumSpanningTree(m, 0));
    }

    /** Ein Knoten wird über einen billigeren Umweg angeschlossen. */
    @Test
    public void testUmwegBilliger()
    {
        //   0 --10-- 1
        //   |        |
        //   1        2
        //   |        |
        //   2 --3--- 3
        final Integer[][] m = new Integer[4][4];
        edge(m, 0, 1, 10);
        edge(m, 0, 2, 1);
        edge(m, 2, 3, 3);
        edge(m, 3, 1, 2);
        assertArrayEquals(new int[] {0, 3, 0, 2}, MinimumSpanningTree.minimumSpanningTree(m, 0));
    }

    /** Ein komplexerer Graph mit 6 Knoten. */
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
        edge(m, 4, 5, 8);
        // Baum: 0-1 (7), 0-2 (9), 2-5 (2), 5-4 (8), 4-3 (6)
        assertArrayEquals(new int[] {0, 0, 0, 4, 5, 2}, MinimumSpanningTree.minimumSpanningTree(m, 0));
    }

    /** Ein nicht erreichbarer Knoten behält -1. */
    @Test
    public void testNichtErreichbar()
    {
        final Integer[][] m = new Integer[3][3];
        edge(m, 0, 1, 4);
        assertArrayEquals(new int[] {0, 0, -1}, MinimumSpanningTree.minimumSpanningTree(m, 0));
    }
}
