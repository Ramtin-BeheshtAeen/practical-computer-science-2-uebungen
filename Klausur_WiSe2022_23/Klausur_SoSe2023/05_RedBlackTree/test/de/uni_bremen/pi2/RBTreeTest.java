package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse RBTree.
 * Die Tests decken die Klausur SoSe 2023, Aufgabe 5 ab (20 Punkte).
 */
public class RBTreeTest
{
    /**
     * Erzeugt einen schwarzen Knoten.
     * @param left Der linke Kindknoten. Darf null sein.
     * @param right Der rechte Kindknoten. Darf null sein.
     * @return Der erzeugte Knoten.
     */
    private RBNode<String> black(final RBNode<String> left, final RBNode<String> right)
    {
        return new RBNode<>("B", left, right, RBNode.Color.BLACK);
    }

    /**
     * Erzeugt einen roten Knoten.
     * @param left Der linke Kindknoten. Darf null sein.
     * @param right Der rechte Kindknoten. Darf null sein.
     * @return Der erzeugte Knoten.
     */
    private RBNode<String> red(final RBNode<String> left, final RBNode<String> right)
    {
        return new RBNode<>("R", left, right, RBNode.Color.RED);
    }

    /** Ein leerer Baum hat die Schwarztiefe 0. */
    @Test
    public void testLeererBaum()
    {
        assertEquals(0, RBTree.blackDepthOfLeafs(null));
    }

    /** Ein Baum aus einer einzelnen schwarzen Wurzel hat die Schwarztiefe 1. */
    @Test
    public void testSchwarzeWurzel()
    {
        assertEquals(1, RBTree.blackDepthOfLeafs(black(null, null)));
    }

    /** Ein Baum aus einer einzelnen roten Wurzel hat die Schwarztiefe 0. */
    @Test
    public void testRoteWurzel()
    {
        assertEquals(0, RBTree.blackDepthOfLeafs(red(null, null)));
    }

    /** Eine schwarze Wurzel mit zwei roten Blättern hat die Schwarztiefe 1. */
    @Test
    public void testSchwarzeWurzelMitRotenKindern()
    {
        assertEquals(1, RBTree.blackDepthOfLeafs(black(red(null, null), red(null, null))));
    }

    /** Eine schwarze Wurzel mit zwei schwarzen Kindern hat die Schwarztiefe 2. */
    @Test
    public void testDreiSchwarzeKnoten()
    {
        assertEquals(2, RBTree.blackDepthOfLeafs(black(black(null, null), black(null, null))));
    }

    /** Ein Knoten mit nur einem schwarzen Kind ist ungültig. */
    @Test
    public void testEinseitigSchwarz()
    {
        assertEquals(-1, RBTree.blackDepthOfLeafs(black(black(null, null), null)));
        assertEquals(-1, RBTree.blackDepthOfLeafs(black(null, black(null, null))));
    }

    /** Ein Knoten mit nur einem roten Kind ist gültig, da Rot nicht zählt. */
    @Test
    public void testEinseitigRot()
    {
        assertEquals(1, RBTree.blackDepthOfLeafs(black(red(null, null), null)));
    }

    /** Ein größerer gültiger Rot-Schwarz-Baum liefert die richtige Schwarztiefe. */
    @Test
    public void testGueltigerGrossererBaum()
    {
        assertEquals(2, RBTree.blackDepthOfLeafs(
                black(red(black(null, null), black(null, null)), black(null, null))));
    }

    /** Ein Baum mit unterschiedlichen Schwarztiefen liefert -1. */
    @Test
    public void testUnterschiedlicheTiefen()
    {
        assertEquals(-1, RBTree.blackDepthOfLeafs(
                black(black(black(null, null), black(null, null)), black(null, null))));
    }

    /** Ein Fehler tief im linken Teilbaum wird nach oben weitergereicht. */
    @Test
    public void testFehlerImLinkenTeilbaum()
    {
        assertEquals(-1, RBTree.blackDepthOfLeafs(
                black(black(black(null, null), null), black(black(null, null), black(null, null)))));
    }

    /** Ein Fehler tief im rechten Teilbaum wird nach oben weitergereicht. */
    @Test
    public void testFehlerImRechtenTeilbaum()
    {
        assertEquals(-1, RBTree.blackDepthOfLeafs(
                black(black(black(null, null), black(null, null)), black(null, black(null, null)))));
    }

    /** Ein vollständiger schwarzer Baum der Höhe 4 hat die Schwarztiefe 4. */
    @Test
    public void testVollstaendigerBaum()
    {
        RBNode<String> node = null;
        for (int i = 0; i < 4; ++i) {
            node = black(node, node);
        }
        assertEquals(4, RBTree.blackDepthOfLeafs(node));
    }

    /** Rote Knoten zwischen schwarzen Knoten verändern die Schwarztiefe nicht. */
    @Test
    public void testRoteZwischenschichten()
    {
        final RBNode<String> subtree = red(black(null, null), black(null, null));
        assertEquals(2, RBTree.blackDepthOfLeafs(black(subtree, subtree)));
    }
}
