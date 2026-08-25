package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Tree (Höhe eines
 * Binärbaums), Klausur WiSe 2023/24, Aufgabe 4 (20 Punkte).
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

    /** Ein leerer Baum hat die Höhe 0. */
    @Test
    public void testLeererBaum()
    {
        assertEquals(0, Tree.treeHeight(null));
    }

    /** Ein Baum aus nur einer Wurzel hat die Höhe 1. */
    @Test
    public void testNurWurzel()
    {
        assertEquals(1, Tree.treeHeight(new Node<>("a")));
    }

    /** Ein Baum mit zwei Ebenen hat die Höhe 2. */
    @Test
    public void testZweiEbenen()
    {
        assertEquals(2, Tree.treeHeight(node(new Node<>("a"), new Node<>("b"))));
    }

    /** Die Höhe ergibt sich aus dem tieferen der beiden Teilbäume. */
    @Test
    public void testTiefererTeilbaumZaehlt()
    {
        // links Höhe 1, rechts Höhe 2 -> gesamt 3
        final Node<String> right = node(new Node<>("b"), new Node<>("c"));
        assertEquals(3, Tree.treeHeight(node(new Node<>("a"), right)));
    }

    /** Ein linkslastiger Baum wird korrekt vermessen. */
    @Test
    public void testLinkslastig()
    {
        final Node<String> left = node(node(new Node<>("d"), null), null);
        assertEquals(4, Tree.treeHeight(node(left, new Node<>("b"))));
    }

    /** Ein reiner Rechtspfad hat die Höhe gleich seiner Knotenzahl. */
    @Test
    public void testRechtspfad()
    {
        Node<String> node = new Node<>("end");
        for (int i = 0; i < 9; ++i) {
            node = node(null, node);
        }
        assertEquals(10, Tree.treeHeight(node));
    }

    /** Ein vollständiger Baum der Höhe 5. */
    @Test
    public void testVollstaendig()
    {
        Node<String> level = new Node<>("leaf");
        for (int i = 0; i < 4; ++i) {
            level = node(level, level);
        }
        assertEquals(5, Tree.treeHeight(level));
    }
}
