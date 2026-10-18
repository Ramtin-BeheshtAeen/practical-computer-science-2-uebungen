package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für Tree.nodeCount, Wiederholungsklausur WiSe 2019/20, Aufgabe 3
 * (20 Punkte). Hier zählt null nicht als Knoten.
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

    /** Leerer Baum. */
    @Test
    public void testLeer()
    {
        assertEquals(0, Tree.nodeCount(null));
    }

    /** Nur Wurzel. */
    @Test
    public void testNurWurzel()
    {
        assertEquals(1, Tree.nodeCount(leaf()));
    }

    /** Zwei Ebenen. */
    @Test
    public void testZweiEbenen()
    {
        assertEquals(3, Tree.nodeCount(node(leaf(), leaf())));
        assertEquals(2, Tree.nodeCount(node(null, leaf())));
    }

    /** Komplexerer Baum: beide Teilbäume werden addiert, nicht das Maximum. */
    @Test
    public void testKomplexer()
    {
        final Node<String> t = node(node(leaf(), null), node(leaf(), leaf()));
        assertEquals(6, Tree.nodeCount(t));

        Node<String> full = null;
        for (int i = 0; i < 5; ++i) {
            full = node(full, copy(full));
        }
        assertEquals(31, Tree.nodeCount(full));
    }

    /**
     * Kopiert einen Baum.
     * @param n Die Wurzel.
     * @return Die Kopie.
     */
    private static Node<String> copy(final Node<String> n)
    {
        return n == null ? null : node(copy(n.getLeft()), copy(n.getRight()));
    }
}
