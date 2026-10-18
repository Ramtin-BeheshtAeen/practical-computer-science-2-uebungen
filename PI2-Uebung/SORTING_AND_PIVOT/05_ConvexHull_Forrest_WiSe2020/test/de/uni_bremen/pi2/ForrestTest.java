package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Tests für Forrest, Wiederholungsklausur WiSe 2019/20, Aufgabe 5 (30 %).
 */
public class ForrestTest
{
    /**
     * Erzeugt Bäume aus Koordinatenpaaren.
     * @param xy x0, y0, x1, y1, ...
     * @return Die Bäume.
     */
    private static Tree[] trees(final int... xy)
    {
        final Tree[] result = new Tree[xy.length / 2];
        for (int i = 0; i < result.length; ++i) {
            result[i] = new Tree(xy[2 * i], xy[2 * i + 1]);
        }
        return result;
    }

    /**
     * Prüft den Zaun.
     * @param expected Die erwarteten Pfähle als "(x,y)" in Reihenfolge.
     * @param forest Die Bäume.
     */
    private static void check(final String expected, final Tree[] forest)
    {
        assertEquals(expected, Arrays.toString(Forrest.fence(forest)));
    }

    /** Drei Bäume sind alle auf dem Zaun. */
    @Test
    public void testDreieck()
    {
        check("[(1,0), (5,3), (0,4)]", trees(0, 4, 5, 3, 1, 0));
    }

    /** Bäume im Inneren gehören nicht zum Zaun. */
    @Test
    public void testDreieckMitInnerem()
    {
        check("[(1,0), (5,3), (0,4)]", trees(2, 2, 0, 4, 1, 2, 5, 3, 1, 0));
    }

    /** Raute mit Baum in der Mitte. */
    @Test
    public void testRaute()
    {
        check("[(2,0), (4,2), (2,4), (0,2)]", trees(0, 2, 2, 2, 4, 2, 2, 4, 2, 0, 1, 2));
    }

    /** Fünfeck mit vielen inneren Bäumen – hier muss zurückgenommen werden. */
    @Test
    public void testFuenfeck()
    {
        check("[(3,0), (6,2), (5,6), (1,6), (0,2)]",
                trees(3, 3, 2, 2, 5, 6, 4, 4, 1, 6, 3, 5, 0, 2, 4, 1, 6, 2, 2, 1, 3, 0));
    }

    /** Der südlichste Baum steht ganz am Ende des Arrays. */
    @Test
    public void testSuedlichsterAmEnde()
    {
        check("[(3,0), (6,2), (5,6), (1,6), (0,2)]", trees(1, 6, 5, 6, 0, 2, 6, 2, 3, 0));
    }
}
