package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

/**
 * Tests für die Klasse List. Jede Operation wird in beiden Varianten
 * (iterativ und rekursiv) mit denselben Testfällen geprüft.
 */
public class ListTest
{
    // ------------------------------------------------------------------
    // Gemeinsame Testrümpfe
    // ------------------------------------------------------------------

    /** Prüft alle Fälle für eine concat-Implementierung. */
    private void checkConcat(final BiFunction<Elem<Integer>, Elem<Integer>, Elem<Integer>> concat)
    {
        // Erste Liste leer.
        assertEquals("[1, 2, 3]", Elem.toString(concat.apply(null, Elem.of(1, 2, 3))));

        // Zweite Liste leer.
        assertEquals("[1, 2, 3]", Elem.toString(concat.apply(Elem.of(1, 2, 3), null)));

        // Beide Listen leer.
        assertNull(concat.apply(null, null));

        // Keine der beiden Listen leer.
        assertEquals("[1, 2, 3, 4, 5]",
                Elem.toString(concat.apply(Elem.of(1, 2, 3), Elem.of(4, 5))));

        // Zwei einelementige Listen.
        assertEquals("[1, 2]", Elem.toString(concat.apply(Elem.of(1), Elem.of(2))));

        // Längere Listen, Reihenfolge bleibt erhalten.
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]",
                Elem.toString(concat.apply(Elem.of(1, 2, 3, 4), Elem.of(5, 6, 7, 8))));

        // Die zweite Liste wird angehängt, nicht kopiert.
        final Elem<Integer> second = Elem.of(4, 5);
        final Elem<Integer> result = concat.apply(Elem.of(1, 2, 3), second);
        assertTrue(result.getNext().getNext().getNext() == second,
                "Die zweite Liste soll direkt angehängt, nicht kopiert werden.");

        // Der Kopf der ersten Liste bleibt der Kopf des Ergebnisses.
        final Elem<Integer> firstHead = Elem.of(1, 2);
        assertTrue(concat.apply(firstHead, Elem.of(3)) == firstHead,
                "Bei nicht leerer erster Liste soll deren erstes Element zurückgegeben werden.");
    }

    /** Prüft alle Fälle für eine insert-Implementierung. */
    private void checkInsert(final BiFunction<Elem<Integer>, Integer, Elem<Integer>> insert)
    {
        // In die leere Liste einfügen.
        assertEquals("[1]", Elem.toString(insert.apply(null, 1)));

        // Vorne einfügen.
        assertEquals("[0, 1, 2, 3]", Elem.toString(insert.apply(Elem.of(1, 2, 3), 0)));

        // In der Mitte einfügen.
        assertEquals("[1, 2, 3, 4]", Elem.toString(insert.apply(Elem.of(1, 3, 4), 2)));

        // Hinten einfügen.
        assertEquals("[1, 2, 3, 4]", Elem.toString(insert.apply(Elem.of(1, 2, 3), 4)));

        // In eine einelementige Liste, vorne und hinten.
        assertEquals("[1, 2]", Elem.toString(insert.apply(Elem.of(2), 1)));
        assertEquals("[1, 2]", Elem.toString(insert.apply(Elem.of(1), 2)));

        // Ein bereits vorhandener Wert wird zusätzlich eingefügt.
        assertEquals("[1, 2, 2, 3]", Elem.toString(insert.apply(Elem.of(1, 2, 3), 2)));

        // Mehrfaches Einfügen ergibt eine sortierte Liste.
        Elem<Integer> list = null;
        for (final int value : new int[] {5, 1, 4, 2, 3}) {
            list = insert.apply(list, value);
        }
        assertEquals("[1, 2, 3, 4, 5]", Elem.toString(list));

        // Die vorhandenen Elemente werden weiterverwendet, nicht kopiert.
        final Elem<Integer> tail = Elem.of(3, 4);
        assertTrue(insert.apply(tail, 5).getNext().getNext().getValue() == 5,
                "Der neue Wert soll hinten eingehängt werden.");
    }

    // ------------------------------------------------------------------
    // concat
    // ------------------------------------------------------------------

    /** Die iterative Variante von concat arbeitet korrekt. */
    @Test
    public void testConcatIterative()
    {
        checkConcat(List::concatIterative);
    }

    /** Die rekursive Variante von concat arbeitet korrekt. */
    @Test
    public void testConcatRecursive()
    {
        checkConcat(List::concatRecursive);
    }

    // ------------------------------------------------------------------
    // insert
    // ------------------------------------------------------------------

    /** Die iterative Variante von insert arbeitet korrekt. */
    @Test
    public void testInsertIterative()
    {
        checkInsert(List::insertIterative);
    }

    /** Die rekursive Variante von insert arbeitet korrekt. */
    @Test
    public void testInsertRecursive()
    {
        checkInsert(List::insertRecursive);
    }
}