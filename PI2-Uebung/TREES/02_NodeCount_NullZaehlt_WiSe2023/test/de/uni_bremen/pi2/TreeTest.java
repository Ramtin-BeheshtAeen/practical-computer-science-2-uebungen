package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für Tree.nodeCount, Klausur WiSe 2022/23, Aufgabe 4 (20 Punkte).
 * Achtung: null zählt hier als Knoten. Ein Baum mit n echten Knoten hat
 * also n + (n + 1) = 2n + 1 Knoten.
 */
public class TreeTest
{
    /** @return Innerer Knoten. */
    private static Node<String> node(final Node<String> left, final Node<String> right)
    {
        return new Node<>("x", left, right);
    }

    /** @return Ein Knoten ohne Kinder. */
    private static Node<String> leaf()
    {
        return new Node<>("x");
    }

    /** Leerer Baum: nur das Blatt null. */
    @Test
    public void testLeer()
    {
        assertEquals(1, Tree.nodeCount(null));
    }

    /** Nur Wurzel: Wurzel plus zwei null-Blätter. */
    @Test
    public void testNurWurzel()
    {
        assertEquals(3, Tree.nodeCount(leaf()));
    }

    /** Zwei Ebenen. */
    @Test
    public void testZweiEbenen()
    {
        assertEquals(7, Tree.nodeCount(node(leaf(), leaf())));
        assertEquals(5, Tree.nodeCount(node(leaf(), null)));
    }

    /** Komplexerer Baum: 2n + 1 bei n echten Knoten. */
    @Test
    public void testKomplexer()
    {
        // 6 echte Knoten
        final Node<String> t = node(node(leaf(), null), node(leaf(), leaf()));
        assertEquals(13, Tree.nodeCount(t));

        Node<String> path = null;
        for (int i = 0; i < 10; ++i) {
            path = node(path, null);
        }
        assertEquals(21, Tree.nodeCount(path));
    }
}
