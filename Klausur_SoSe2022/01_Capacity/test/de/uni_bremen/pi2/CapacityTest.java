package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Capacity (Vergrößern der
 * Kapazität eines Arrays dynamischer Größe), Klausur SoSe 2022, Aufgabe 1
 * (20 Punkte).
 */
public class CapacityTest
{
    /** Die Größe bleibt gleich, wenn gerade keine Vergrößerung notwendig ist (4/4 Punkte). */
    @Test
    public void testKeineVergroesserungNoetig()
    {
        assertEquals(4, Capacity.grow(4, 0));
        assertEquals(4, Capacity.grow(4, 3));
        assertEquals(8, Capacity.grow(8, 7));
    }

    /** Die Größe verändert sich um eine Stufe, wenn dies gerade notwendig ist (4/4 Punkte). */
    @Test
    public void testEineStufe()
    {
        assertEquals(8, Capacity.grow(4, 4));
        assertEquals(8, Capacity.grow(4, 7));
        assertEquals(2, Capacity.grow(1, 1));
    }

    /** Die Kapazität verändert sich um mehrere Stufen, wenn nötig. */
    @Test
    public void testMehrereStufen()
    {
        assertEquals(16, Capacity.grow(1, 15));
        assertEquals(16, Capacity.grow(2, 10));
        assertEquals(32, Capacity.grow(1, 16));
    }

    /** Eine Anfangskapazität von 0 funktioniert (4/4 Punkte). */
    @Test
    public void testAnfangskapazitaetNull()
    {
        assertEquals(1, Capacity.grow(0, 0));
        assertEquals(4, Capacity.grow(0, 3));
        assertEquals(8, Capacity.grow(0, 4));
    }

    /** Das Erreichen der Maximalkapazität funktioniert (4/4 Punkte). */
    @Test
    public void testMaximalkapazitaet()
    {
        assertEquals(Integer.MAX_VALUE, Capacity.grow(0, Integer.MAX_VALUE - 1));
        assertEquals(Integer.MAX_VALUE, Capacity.grow(1 << 30, Integer.MAX_VALUE - 1));
        assertEquals(Integer.MAX_VALUE, Capacity.grow(Integer.MAX_VALUE, Integer.MAX_VALUE - 1));
    }

    /** Die neue Kapazität passt immer echt über den geforderten Index. */
    @Test
    public void testKapazitaetReichtImmer()
    {
        for (int current = 0; current <= 64; ++current) {
            for (int index = 0; index <= 200; ++index) {
                final int result = Capacity.grow(current, index);
                assertTrue(result > index,
                        "grow(" + current + ", " + index + ") = " + result + " passt nicht über " + index);
            }
        }
    }
}
