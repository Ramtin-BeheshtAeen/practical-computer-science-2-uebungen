package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für RBTree, Klausur SoSe 2023 / SoSe 2026 (20 Punkte).
 * Die Tests folgen den Zeilen der Bewertung: nur Wurzel (1), nur-schwarzer
 * Baum der Höhe 1 (2), plus roter Knoten (4), plus schwarzer Knoten = Fehler
 * (4), komplexere Bäume (4), komplexere Bäume mit Fehler (4), zwei Fehler (1).
 *
 * Zählweise wie in der Musterlösung: jeder schwarze Knoten auf dem Weg
 * zählt, auch die Wurzel; null zählt 0.
 */
public class RBTreeTest
{
    /** @return Schwarzer Knoten mit Kindern. */
    private static RBNode b(final RBNode left, final RBNode right)
    {
        return new RBNode(true, left, right);
    }

    /** @return Roter Knoten mit Kindern. */
    private static RBNode r(final RBNode left, final RBNode right)
    {
        return new RBNode(false, left, right);
    }

    /** @return Schwarzer Knoten ohne Kinder. */
    private static RBNode b()
    {
        return b(null, null);
    }

    /** @return Roter Knoten ohne Kinder. */
    private static RBNode r()
    {
        return r(null, null);
    }

    // ------------------------------------------------------------------
    // Gültige Bäume
    // ------------------------------------------------------------------

    /** Ein leerer Baum (nur ein Blatt) hat Schwarztiefe 0. */
    @Test
    public void testLeererBaum()
    {
        assertEquals(0, RBTree.blackDepthOfLeafs(null));
    }

    /** Ein Baum, der nur aus der Wurzel besteht (1 P.). */
    @Test
    public void testNurWurzel()
    {
        assertEquals(1, RBTree.blackDepthOfLeafs(b()));
        assertEquals(0, RBTree.blackDepthOfLeafs(r()));
    }

    /** Ein nur-schwarzer Baum der Höhe 1 (2 P.). */
    @Test
    public void testNurSchwarzHoehe1()
    {
        //      B
        //     / \
        //    B   B
        assertEquals(2, RBTree.blackDepthOfLeafs(b(b(), b())));
    }

    /** Derselbe Baum mit einem zusätzlichen roten Knoten (2 Fälle, 4 P.). */
    @Test
    public void testZusaetzlicherRoterKnoten()
    {
        assertEquals(2, RBTree.blackDepthOfLeafs(b(b(r(), null), b())));
        assertEquals(2, RBTree.blackDepthOfLeafs(b(b(), b(null, r()))));
    }

    /** Komplexere Bäume aus roten und schwarzen Knoten (2 Fälle, 4 P.). */
    @Test
    public void testKomplexereBaeume()
    {
        //              B
        //          /       \
        //         R         B
        //       /   \      / \
        //      B     B    B   R
        //     / \   / \      / \
        //    B   B R   B    B   B
        //         / \
        //        B   B
        final RBNode t1 = b(
                r(b(b(), b()), b(r(b(), b()), b())),
                b(b(), r(b(), b())));
        assertEquals(3, RBTree.blackDepthOfLeafs(t1));

        //             B
        //          /     \
        //         B       B
        //        / \     / \
        //       B   B   R   B
        //          /   / \
        //         R   B   B
        final RBNode t2 = b(
                b(b(), b(r(), null)),
                b(r(b(), b()), b()));
        assertEquals(3, RBTree.blackDepthOfLeafs(t2));
    }

    /** Rote Knoten zählen nicht mit, auch nicht viele. */
    @Test
    public void testRoteKnotenZaehlenNicht()
    {
        assertEquals(1, RBTree.blackDepthOfLeafs(b(r(), r())));
        assertEquals(0, RBTree.blackDepthOfLeafs(r(r(), r())));
    }

    // ------------------------------------------------------------------
    // Ungültige Bäume
    // ------------------------------------------------------------------

    /** Sind die zusätzlichen Knoten stattdessen schwarz, wird der Fehler erkannt (2 Fälle, 4 P.). */
    @Test
    public void testZusaetzlicherSchwarzerKnoten()
    {
        assertEquals(-1, RBTree.blackDepthOfLeafs(b(b(b(), null), b())));
        assertEquals(-1, RBTree.blackDepthOfLeafs(b(b(), b(null, b()))));
    }

    /** Ein Baum mit nur einem schwarzen Kind ist ungültig. */
    @Test
    public void testEinSeitigSchwarz()
    {
        assertEquals(-1, RBTree.blackDepthOfLeafs(b(b(), null)));
        assertEquals(-1, RBTree.blackDepthOfLeafs(r(null, b())));
    }

    /** Komplexere Bäume mit jeweils einem Fehler (2 Fälle, 4 P.). */
    @Test
    public void testKomplexereBaeumeMitFehler()
    {
        // Wie t1 oben, aber der tiefe rote Knoten ist schwarz -> ein Pfad zu lang.
        final RBNode t1 = b(
                r(b(b(), b()), b(b(b(), b()), b())),
                b(b(), r(b(), b())));
        assertEquals(-1, RBTree.blackDepthOfLeafs(t1));

        // Wie t2 oben, aber der schwarze Knoten ganz rechts fehlt -> ein Pfad zu kurz.
        final RBNode t2 = b(
                b(b(), b(r(), null)),
                b(r(b(), b()), null));
        assertEquals(-1, RBTree.blackDepthOfLeafs(t2));
    }

    /** Ein Baum mit zwei Fehlern wird als ungültig erkannt (1 P.). */
    @Test
    public void testZweiFehler()
    {
        // Beide Teilbäume sind in sich ungültig und liefern -1.
        // Wer nur left == right prüft, hält -1 == -1 für "gleich" und zählt
        // weiter – genau diese Falle prüft der Test.
        assertEquals(-1, RBTree.blackDepthOfLeafs(b(b(b(), null), b(b(), null))));
        assertEquals(-1, RBTree.blackDepthOfLeafs(r(b(b(), null), b(null, b()))));
    }
}
