package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für UnionFind.union, Klausur SoSe 2021, Aufgabe 3b.
 */
public class UnionFindTest
{
    /**
     * Sucht die Wurzel (unabhängig von deiner Lösung).
     * @param n Ein Knoten.
     * @return Die Wurzel seines Baums.
     */
    private static Node root(Node n)
    {
        int steps = 0;
        while (n.getParent() != n) {
            n = n.getParent();
            assertTrue(++steps < 1000, "Zyklus in den Elternverweisen");
        }
        return n;
    }

    /**
     * Erzeugt n einzelne Mengen.
     * @param n Die Anzahl.
     * @return Die Knoten.
     */
    private static Node[] nodes(final int n)
    {
        final Node[] result = new Node[n];
        for (int i = 0; i < n; ++i) {
            result[i] = new Node();
        }
        return result;
    }

    /** Zwei einzelne Knoten werden vereinigt. */
    @Test
    public void testZweiEinzelne()
    {
        final Node[] n = nodes(2);
        UnionFind.union(n[0], n[1]);
        assertSame(root(n[0]), root(n[1]));
    }

    /** Vereinigung über innere Knoten: es müssen die WURZELN verbunden werden. */
    @Test
    public void testUeberInnereKnoten()
    {
        final Node[] n = nodes(4);
        UnionFind.union(n[0], n[1]);
        UnionFind.union(n[2], n[3]);
        // n[0] und n[2] sind evtl. keine Wurzeln mehr.
        UnionFind.union(n[0], n[2]);
        final Node r = root(n[0]);
        for (final Node node : n) {
            assertSame(r, root(node));
        }
    }

    /** Andere Mengen bleiben unberührt. */
    @Test
    public void testAndereMengenBleiben()
    {
        final Node[] n = nodes(4);
        UnionFind.union(n[0], n[1]);
        assertNotSame(root(n[0]), root(n[2]));
        assertSame(n[2], root(n[2]));
        assertSame(n[3], root(n[3]));
    }

    /** Vereinigung innerhalb derselben Menge erzeugt keinen Zyklus. */
    @Test
    public void testSchonVereinigt()
    {
        final Node[] n = nodes(3);
        UnionFind.union(n[0], n[1]);
        UnionFind.union(n[1], n[2]);
        UnionFind.union(n[0], n[2]);
        UnionFind.union(n[2], n[2]);
        final Node r = root(n[0]);
        assertSame(r, root(n[1]));
        assertSame(r, root(n[2]));
    }

    /** Eine lange Kette von Vereinigungen. */
    @Test
    public void testKette()
    {
        final Node[] n = nodes(20);
        for (int i = 1; i < n.length; ++i) {
            UnionFind.union(n[i], n[i - 1]);
        }
        final Node r = root(n[0]);
        for (final Node node : n) {
            assertSame(r, root(node));
        }
    }

    /**
     * Prüft, dass zwei Knoten verschieden sind.
     * @param a Der eine.
     * @param b Der andere.
     */
    private static void assertNotSame(final Node a, final Node b)
    {
        assertTrue(a != b, "Die Mengen dürfen nicht vereinigt sein");
    }
}
