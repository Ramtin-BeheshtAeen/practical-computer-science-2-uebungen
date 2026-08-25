package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Tree (Anzahl der Knoten in
 * einem Binärbaum), Klausur WiSe 2022/23, Aufgabe 4 (20 Punkte).
 */
public class TreeTest
{
    /**
     * Erzeugt einen Knoten mit Kindern.
     * @param left Der linke Kindknoten.
     * @param right Der rechte Kindknoten.
     * @return Der erzeugte Knoten.
     */
    private Node<String> node(final Node<String> left, final Node<String> right)
    {
        return new Node<>("x", left, right);
    }

    /** Ein leerer Baum hat 0 Knoten. */
    @Test
    public void testLeererBaum()
    {
        assertEquals(0, Tree.nodeCount(null));
    }

    /** Ein Baum aus nur einer Wurzel hat 1 Knoten. */
    @Test
    public void testNurWurzel()
    {
        assertEquals(1, Tree.nodeCount(new Node<>("a")));
    }

    /** Eine Wurzel mit einem linken Kind hat 2 Knoten. */
    @Test
    public void testNurLinks()
    {
        assertEquals(2, Tree.nodeCount(node(new Node<>("a"), null)));
    }

    /** Eine Wurzel mit einem rechten Kind hat 2 Knoten. */
    @Test
    public void testNurRechts()
    {
        assertEquals(2, Tree.nodeCount(node(null, new Node<>("a"))));
    }

    /** Ein vollständiger Baum der Höhe 2 hat 3 Knoten. */
    @Test
    public void testKleinerBaum()
    {
        assertEquals(3, Tree.nodeCount(node(new Node<>("a"), new Node<>("b"))));
    }

    /** Ein unausgeglichener Baum wird korrekt gezählt. */
    @Test
    public void testUnausgeglichen()
    {
        // Wurzel -> links (Blatt), rechts -> (links Blatt, rechts Blatt)
        assertEquals(5, Tree.nodeCount(
                node(new Node<>("a"), node(new Node<>("b"), new Node<>("c")))));
    }

    /** Ein vollständiger Baum der Höhe 4 hat 15 Knoten. */
    @Test
    public void testVollstaendig()
    {
        Node<String> level = new Node<>("leaf");
        for (int i = 0; i < 3; ++i) {
            level = node(level, level);
        }
        assertEquals(15, Tree.nodeCount(level));
    }

    /** Ein reiner Linkspfad (entartete Liste) wird korrekt gezählt. */
    @Test
    public void testLinkspfad()
    {
        Node<String> node = new Node<>("end");
        for (int i = 0; i < 9; ++i) {
            node = node(node, null);
        }
        assertEquals(10, Tree.nodeCount(node));
    }
}
