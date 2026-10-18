package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für Tree.treeHeight, Klausur SoSe 2022 / WiSe 2023/24, Aufgabe 4
 * (20 Punkte). Bewertung: Höhe 0 (5), Höhe 1 (5), komplexerer Baum (10).
 */
public class TreeTest
{
    /**
     * Erzeugt einen inneren Knoten.
     * @param left Linker Teilbaum.
     * @param right Rechter Teilbaum.
     * @return Der Knoten.
     */
    private static Node<String> node(final Node<String> left, final Node<String> right)
    {
        return new Node<>("x", left, right);
    }

    /** @return Ein Blatt-Knoten. */
    private static Node<String> leaf()
    {
        return new Node<>("x");
    }

    /** Die Höhe 0 wird korrekt bestimmt (5 P.). */
    @Test
    public void testHoehe0()
    {
        assertEquals(0, Tree.treeHeight(null));
    }

    /** Die Höhe 1 wird korrekt bestimmt (5 P.). */
    @Test
    public void testHoehe1()
    {
        assertEquals(1, Tree.treeHeight(leaf()));
    }

    /** Die Höhe eines komplexeren Baums wird korrekt bestimmt (10 P.). */
    @Test
    public void testKomplexererBaum()
    {
        assertEquals(2, Tree.treeHeight(node(leaf(), leaf())));
        // links Höhe 1, rechts Höhe 2 -> gesamt 3
        assertEquals(3, Tree.treeHeight(node(leaf(), node(leaf(), leaf()))));
        // linkslastig
        assertEquals(4, Tree.treeHeight(node(node(node(leaf(), null), null), leaf())));
    }

    /** Ein reiner Rechtspfad hat die Höhe gleich seiner Knotenzahl. */
    @Test
    public void testRechtspfad()
    {
        Node<String> root = null;
        for (int i = 0; i < 10; ++i) {
            root = node(null, root);
        }
        assertEquals(10, Tree.treeHeight(root));
    }

    /** Ein vollständiger Baum mit 31 Knoten hat Höhe 5. */
    @Test
    public void testVollstaendig()
    {
        assertEquals(5, Tree.treeHeight(full(5)));
    }

    /**
     * Baut einen vollständigen Baum.
     * @param h Die Höhe.
     * @return Die Wurzel.
     */
    private static Node<String> full(final int h)
    {
        return h == 0 ? null : node(full(h - 1), full(h - 1));
    }
}
