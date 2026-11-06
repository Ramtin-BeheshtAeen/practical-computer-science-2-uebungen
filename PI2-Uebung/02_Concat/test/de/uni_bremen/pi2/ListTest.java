package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests für die Klasse List. Jeder Testfall ist eine eigene Methode, damit im
 * Testlauf direkt sichtbar ist, welcher Fall fehlschlägt.
 *
 * Aufgabe 3: Einfügen an einer Position (iterativ und rekursiv).
 * Aufgabe 1: Entfernen des ersten Elements mit einem bestimmten Wert.
 * Aufgabe 2: Entfernen an einer Position (iterativ und rekursiv).
 */
public class ListTest
{
    // ==================================================================
    // SoSe 2022, Aufgabe 2  concatIterative
    // ==================================================================

    /** Ist die erste Liste leer, ist das Ergebnis die zweite Liste. */
    @Test
    public void testConcatIterativeErsteListeLeer()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.concatIterative(null, Elem.of(1, 2, 3))));
    }

    /** Ist die zweite Liste leer, ist das Ergebnis die erste Liste. */
    @Test
    public void testConcatIterativeZweiteListeLeer()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.concatIterative(Elem.of(1, 2, 3), null)));
    }

    /** Sind beide Listen leer, ist das Ergebnis leer. */
    @Test
    public void testConcatIterativeBeideLeer()
    {
        assertNull(List.concatIterative(null, null));
    }

    /** Zwei nicht leere Listen werden aneinandergehängt. */
    @Test
    public void testConcatIterativeKeineLeer()
    {
        assertEquals("[1, 2, 3, 4, 5]",
                Elem.toString(List.concatIterative(Elem.of(1, 2, 3), Elem.of(4, 5))));
    }

    /** Zwei einelementige Listen werden aneinandergehängt. */
    @Test
    public void testConcatIterativeEinelementig()
    {
        assertEquals("[1, 2]", Elem.toString(List.concatIterative(Elem.of(1), Elem.of(2))));
    }

    /** Die zweite Liste wird angehängt, nicht kopiert. */
    @Test
    public void testConcatIterativeZweiteListeAngehaengt()
    {
        final Elem<Integer> second = Elem.of(4, 5);
        final Elem<Integer> result = List.concatIterative(Elem.of(1, 2, 3), second);
        assertTrue(result.getNext().getNext().getNext() == second,
                "Die zweite Liste soll direkt angehängt, nicht kopiert werden.");
    }

    /** Der Kopf der ersten Liste bleibt der Kopf des Ergebnisses. */
    @Test
    public void testConcatIterativeKopfBleibt()
    {
        final Elem<Integer> head = Elem.of(1, 2);
        assertTrue(List.concatIterative(head, Elem.of(3)) == head,
                "Bei nicht leerer erster Liste soll deren erstes Element zurückgegeben werden.");
    }

    /** Längere Listen, die Reihenfolge bleibt erhalten. */
    @Test
    public void testConcatIterativeLaengereListen()
    {
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]",
                Elem.toString(List.concatIterative(Elem.of(1, 2, 3, 4), Elem.of(5, 6, 7, 8))));
    }

    // ==================================================================
    // SoSe 2022, Aufgabe 2  concatRecursive
    // ==================================================================

    /** Ist die erste Liste leer, ist das Ergebnis die zweite Liste. */
    @Test
    public void testConcatRecursiveErsteListeLeer()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.concatRecursive(null, Elem.of(1, 2, 3))));
    }

    /** Ist die zweite Liste leer, ist das Ergebnis die erste Liste. */
    @Test
    public void testConcatRecursiveZweiteListeLeer()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.concatRecursive(Elem.of(1, 2, 3), null)));
    }

    /** Sind beide Listen leer, ist das Ergebnis leer. */
    @Test
    public void testConcatRecursiveBeideLeer()
    {
        assertNull(List.concatRecursive(null, null));
    }

    /** Zwei nicht leere Listen werden aneinandergehängt. */
    @Test
    public void testConcatRecursiveKeineLeer()
    {
        assertEquals("[1, 2, 3, 4, 5]",
                Elem.toString(List.concatRecursive(Elem.of(1, 2, 3), Elem.of(4, 5))));
    }

    /** Zwei einelementige Listen werden aneinandergehängt. */
    @Test
    public void testConcatRecursiveEinelementig()
    {
        assertEquals("[1, 2]", Elem.toString(List.concatRecursive(Elem.of(1), Elem.of(2))));
    }

    /** Die zweite Liste wird angehängt, nicht kopiert. */
    @Test
    public void testConcatRecursiveZweiteListeAngehaengt()
    {
        final Elem<Integer> second = Elem.of(4, 5);
        final Elem<Integer> result = List.concatRecursive(Elem.of(1, 2, 3), second);
        assertTrue(result.getNext().getNext().getNext() == second,
                "Die zweite Liste soll direkt angehängt, nicht kopiert werden.");
    }

    /** Der Kopf der ersten Liste bleibt der Kopf des Ergebnisses. */
    @Test
    public void testConcatRecursiveKopfBleibt()
    {
        final Elem<Integer> head = Elem.of(1, 2);
        assertTrue(List.concatRecursive(head, Elem.of(3)) == head,
                "Bei nicht leerer erster Liste soll deren erstes Element zurückgegeben werden.");
    }

    /** Längere Listen, die Reihenfolge bleibt erhalten. */
    @Test
    public void testConcatRecursiveLaengereListen()
    {
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]",
                Elem.toString(List.concatRecursive(Elem.of(1, 2, 3, 4), Elem.of(5, 6, 7, 8))));
    }

    // ==================================================================
    // Aufgabe 3a  insertIterative
    // ==================================================================

    /** In die leere Liste einfügen. */
    @Test
    public void testInsertIterativeLeereListe()
    {
        assertEquals("[1]", Elem.toString(List.insertIterative(null, 0, 1)));
    }

    /** Vorne einfügen. */
    @Test
    public void testInsertIterativeVorne()
    {
        assertEquals("[0, 1, 2, 3]", Elem.toString(List.insertIterative(Elem.of(1, 2, 3), 0, 0)));
    }

    /** In der Mitte einfügen. */
    @Test
    public void testInsertIterativeMitte()
    {
        assertEquals("[1, 9, 2, 3]", Elem.toString(List.insertIterative(Elem.of(1, 2, 3), 1, 9)));
        assertEquals("[1, 2, 9, 3]", Elem.toString(List.insertIterative(Elem.of(1, 2, 3), 2, 9)));
    }

    /** Hinten einfügen, Index gleich der Länge der Liste. */
    @Test
    public void testInsertIterativeHinten()
    {
        assertEquals("[1, 2, 3, 9]", Elem.toString(List.insertIterative(Elem.of(1, 2, 3), 3, 9)));
    }

    /** In eine einelementige Liste einfügen, vorne und hinten. */
    @Test
    public void testInsertIterativeEinelementig()
    {
        assertEquals("[9, 1]", Elem.toString(List.insertIterative(Elem.of(1), 0, 9)));
        assertEquals("[1, 9]", Elem.toString(List.insertIterative(Elem.of(1), 1, 9)));
    }

    /** Der eingefügte Wert darf null sein. */
    @Test
    public void testInsertIterativeWertNull()
    {
        assertEquals("[1, null, 2]", Elem.toString(List.insertIterative(Elem.of(1, 2), 1, null)));
    }

    /** Bei Index 0 entsteht ein neuer Listenkopf vor der alten Liste. */
    @Test
    public void testInsertIterativeNeuerKopf()
    {
        final Elem<Integer> list = Elem.of(1, 2);
        assertTrue(List.insertIterative(list, 0, 9).getNext() == list,
                "Bei Index 0 soll die alte Liste hinter das neue Element gehängt werden.");
    }

    /** Bei Index > 0 wird das bisherige erste Element zurückgegeben. */
    @Test
    public void testInsertIterativeKopfBleibt()
    {
        final Elem<Integer> head = Elem.of(1, 2);
        assertTrue(List.insertIterative(head, 1, 9) == head,
                "Bei Index > 0 soll das bisherige erste Element zurückgegeben werden.");
    }

    /** Die Elemente hinter der Einfügestelle werden weiterverwendet. */
    @Test
    public void testInsertIterativeNichtKopiert()
    {
        final Elem<Integer> list = Elem.of(1, 2);
        final Elem<Integer> zweites = list.getNext();
        assertTrue(List.insertIterative(list, 1, 9).getNext().getNext() == zweites,
                "Die Elemente hinter der Einfügestelle sollen dieselben bleiben.");
    }

    /** Längere Liste. */
    @Test
    public void testInsertIterativeLaengereListe()
    {
        assertEquals("[1, 2, 3, 9, 4, 5]",
                Elem.toString(List.insertIterative(Elem.of(1, 2, 3, 4, 5), 3, 9)));
    }

    // ==================================================================
    // Aufgabe 3b  insertRecursive
    // ==================================================================

    /** In die leere Liste einfügen. */
    @Test
    public void testInsertRecursiveLeereListe()
    {
        assertEquals("[1]", Elem.toString(List.insertRecursive(null, 0, 1)));
    }

    /** Vorne einfügen. */
    @Test
    public void testInsertRecursiveVorne()
    {
        assertEquals("[0, 1, 2, 3]", Elem.toString(List.insertRecursive(Elem.of(1, 2, 3), 0, 0)));
    }

    /** In der Mitte einfügen. */
    @Test
    public void testInsertRecursiveMitte()
    {
        assertEquals("[1, 9, 2, 3]", Elem.toString(List.insertRecursive(Elem.of(1, 2, 3), 1, 9)));
        assertEquals("[1, 2, 9, 3]", Elem.toString(List.insertRecursive(Elem.of(1, 2, 3), 2, 9)));
    }

    /** Hinten einfügen, Index gleich der Länge der Liste. */
    @Test
    public void testInsertRecursiveHinten()
    {
        assertEquals("[1, 2, 3, 9]", Elem.toString(List.insertRecursive(Elem.of(1, 2, 3), 3, 9)));
    }

    /** In eine einelementige Liste einfügen, vorne und hinten. */
    @Test
    public void testInsertRecursiveEinelementig()
    {
        assertEquals("[9, 1]", Elem.toString(List.insertRecursive(Elem.of(1), 0, 9)));
        assertEquals("[1, 9]", Elem.toString(List.insertRecursive(Elem.of(1), 1, 9)));
    }

    /** Der eingefügte Wert darf null sein. */
    @Test
    public void testInsertRecursiveWertNull()
    {
        assertEquals("[1, null, 2]", Elem.toString(List.insertRecursive(Elem.of(1, 2), 1, null)));
    }

    /** Bei Index 0 entsteht ein neuer Listenkopf vor der alten Liste. */
    @Test
    public void testInsertRecursiveNeuerKopf()
    {
        final Elem<Integer> list = Elem.of(1, 2);
        assertTrue(List.insertRecursive(list, 0, 9).getNext() == list,
                "Bei Index 0 soll die alte Liste hinter das neue Element gehängt werden.");
    }

    /** Bei Index > 0 wird das bisherige erste Element zurückgegeben. */
    @Test
    public void testInsertRecursiveKopfBleibt()
    {
        final Elem<Integer> head = Elem.of(1, 2);
        assertTrue(List.insertRecursive(head, 1, 9) == head,
                "Bei Index > 0 soll das bisherige erste Element zurückgegeben werden.");
    }

    /** Die Elemente hinter der Einfügestelle werden weiterverwendet. */
    @Test
    public void testInsertRecursiveNichtKopiert()
    {
        final Elem<Integer> list = Elem.of(1, 2);
        final Elem<Integer> zweites = list.getNext();
        assertTrue(List.insertRecursive(list, 1, 9).getNext().getNext() == zweites,
                "Die Elemente hinter der Einfügestelle sollen dieselben bleiben.");
    }

    /** Längere Liste. */
    @Test
    public void testInsertRecursiveLaengereListe()
    {
        assertEquals("[1, 2, 3, 9, 4, 5]",
                Elem.toString(List.insertRecursive(Elem.of(1, 2, 3, 4, 5), 3, 9)));
    }

    // ==================================================================
    // Aufgabe 1  removeKey
    // ==================================================================

    /** Aus der leeren Liste entfernen liefert die leere Liste. */
    @Test
    public void testRemoveKeyLeereListe()
    {
        assertNull(List.removeKey(null, 1));
    }

    /** Das erste Element wird entfernt. */
    @Test
    public void testRemoveKeyErstesElement()
    {
        assertEquals("[2, 3]", Elem.toString(List.removeKey(Elem.of(1, 2, 3), 1)));
    }

    /** Ein Element in der Mitte wird entfernt. */
    @Test
    public void testRemoveKeyMittleresElement()
    {
        assertEquals("[1, 3]", Elem.toString(List.removeKey(Elem.of(1, 2, 3), 2)));
    }

    /** Das letzte Element wird entfernt. */
    @Test
    public void testRemoveKeyLetztesElement()
    {
        assertEquals("[1, 2]", Elem.toString(List.removeKey(Elem.of(1, 2, 3), 3)));
    }

    /** Aus einer einelementigen Liste entsteht die leere Liste. */
    @Test
    public void testRemoveKeyEinelementig()
    {
        assertNull(List.removeKey(Elem.of(1), 1));
    }

    /** Ist der Wert nicht enthalten, bleibt die Liste inhaltlich unverändert. */
    @Test
    public void testRemoveKeyWertNichtEnthalten()
    {
        assertEquals("[1, 2, 3]", Elem.toString(List.removeKey(Elem.of(1, 2, 3), 9)));
    }

    /** Nur das erste Vorkommen wird entfernt. */
    @Test
    public void testRemoveKeyNurErstesVorkommen()
    {
        assertEquals("[1, 3, 2]", Elem.toString(List.removeKey(Elem.of(1, 2, 3, 2), 2)));
    }

    /** Der Vergleich erfolgt über equals, nicht über ==. */
    @Test
    public void testRemoveKeyVergleichMitEquals()
    {
        assertEquals("[a, c]", Elem.toString(List.removeKey(Elem.of("a", "b", "c"),
                new String("b"))));
    }

    /** Die übergebene Liste wird nicht verändert. */
    @Test
    public void testRemoveKeyOriginalUnveraendert()
    {
        final Elem<Integer> original = Elem.of(1, 2, 3);
        List.removeKey(original, 2);
        assertEquals("[1, 2, 3]", Elem.toString(original),
                "Die ursprüngliche Liste soll unverändert bleiben.");
    }

    /** Die Elemente vor dem entfernten Element werden neu erzeugt. */
    @Test
    public void testRemoveKeyElementeDavorKopiert()
    {
        final Elem<Integer> original = Elem.of(1, 2, 3);
        final Elem<Integer> result = List.removeKey(original, 2);
        assertTrue(result != original,
                "Vor dem entfernten Element sollen neue Elemente entstehen.");
        assertEquals(1, result.getValue());
    }

    /** Die Elemente hinter dem entfernten Element werden weiterverwendet. */
    @Test
    public void testRemoveKeyElementeDahinterWeiterverwendet()
    {
        final Elem<Integer> original = Elem.of(1, 2, 3);
        final Elem<Integer> drittes = original.getNext().getNext();
        assertTrue(List.removeKey(original, 2).getNext() == drittes,
                "Hinter dem entfernten Element soll die alte Liste weiterverwendet werden.");
    }

    /** Längere Liste, Reihenfolge bleibt erhalten. */
    @Test
    public void testRemoveKeyLaengereListe()
    {
        assertEquals("[1, 2, 3, 5, 6]",
                Elem.toString(List.removeKey(Elem.of(1, 2, 3, 4, 5, 6), 4)));
    }

    // ==================================================================
    // Aufgabe 2a  removeIterative
    // ==================================================================

    /** Das erste Element wird entfernt. */
    @Test
    public void testRemoveIterativeErstesElement()
    {
        assertEquals("[2, 3]", Elem.toString(List.removeIterative(Elem.of(1, 2, 3), 0)));
    }

    /** Ein Element in der Mitte wird entfernt. */
    @Test
    public void testRemoveIterativeMittleresElement()
    {
        assertEquals("[1, 3]", Elem.toString(List.removeIterative(Elem.of(1, 2, 3), 1)));
    }

    /** Das letzte Element wird entfernt. */
    @Test
    public void testRemoveIterativeLetztesElement()
    {
        assertEquals("[1, 2]", Elem.toString(List.removeIterative(Elem.of(1, 2, 3), 2)));
    }

    /** Aus einer einelementigen Liste entsteht die leere Liste. */
    @Test
    public void testRemoveIterativeEinelementig()
    {
        assertNull(List.removeIterative(Elem.of(1), 0));
    }

    /** Bei Index 0 ist das Ergebnis genau der Rest der Liste. */
    @Test
    public void testRemoveIterativeRestZurueck()
    {
        final Elem<Integer> list = Elem.of(1, 2, 3);
        final Elem<Integer> rest = list.getNext();
        assertTrue(List.removeIterative(list, 0) == rest,
                "Bei Index 0 soll der Rest der Liste zurückgegeben werden.");
    }

    /** Bei Index > 0 bleibt der Kopf der Liste erhalten. */
    @Test
    public void testRemoveIterativeKopfBleibt()
    {
        final Elem<Integer> head = Elem.of(1, 2, 3);
        assertTrue(List.removeIterative(head, 1) == head,
                "Bei Index > 0 soll das erste Element zurückgegeben werden.");
    }

    /** Die übrigen Elemente werden weiterverwendet, nicht kopiert. */
    @Test
    public void testRemoveIterativeNichtKopiert()
    {
        final Elem<Integer> original = Elem.of(1, 2, 3);
        final Elem<Integer> drittes = original.getNext().getNext();
        assertTrue(List.removeIterative(original, 1).getNext() == drittes,
                "Die übrigen Elemente sollen dieselben bleiben.");
    }

    /** Zweimal hintereinander entfernen. */
    @Test
    public void testRemoveIterativeMehrfach()
    {
        Elem<Integer> list = Elem.of(1, 2, 3, 4);
        list = List.removeIterative(list, 0);
        list = List.removeIterative(list, 2);
        assertEquals("[2, 3]", Elem.toString(list));
    }

    /** Längere Liste. */
    @Test
    public void testRemoveIterativeLaengereListe()
    {
        assertEquals("[1, 2, 3, 5, 6]",
                Elem.toString(List.removeIterative(Elem.of(1, 2, 3, 4, 5, 6), 3)));
    }

    // ==================================================================
    // Aufgabe 2b  removeRecursive
    // ==================================================================

    /** Das erste Element wird entfernt. */
    @Test
    public void testRemoveRecursiveErstesElement()
    {
        assertEquals("[2, 3]", Elem.toString(List.removeRecursive(Elem.of(1, 2, 3), 0)));
    }

    /** Ein Element in der Mitte wird entfernt. */
    @Test
    public void testRemoveRecursiveMittleresElement()
    {
        assertEquals("[1, 3]", Elem.toString(List.removeRecursive(Elem.of(1, 2, 3), 1)));
    }

    /** Das letzte Element wird entfernt. */
    @Test
    public void testRemoveRecursiveLetztesElement()
    {
        assertEquals("[1, 2]", Elem.toString(List.removeRecursive(Elem.of(1, 2, 3), 2)));
    }

    /** Aus einer einelementigen Liste entsteht die leere Liste. */
    @Test
    public void testRemoveRecursiveEinelementig()
    {
        assertNull(List.removeRecursive(Elem.of(1), 0));
    }

    /** Bei Index 0 ist das Ergebnis genau der Rest der Liste. */
    @Test
    public void testRemoveRecursiveRestZurueck()
    {
        final Elem<Integer> list = Elem.of(1, 2, 3);
        final Elem<Integer> rest = list.getNext();
        assertTrue(List.removeRecursive(list, 0) == rest,
                "Bei Index 0 soll der Rest der Liste zurückgegeben werden.");
    }

    /** Bei Index > 0 bleibt der Kopf der Liste erhalten. */
    @Test
    public void testRemoveRecursiveKopfBleibt()
    {
        final Elem<Integer> head = Elem.of(1, 2, 3);
        assertTrue(List.removeRecursive(head, 1) == head,
                "Bei Index > 0 soll das erste Element zurückgegeben werden.");
    }

    /** Die übrigen Elemente werden weiterverwendet, nicht kopiert. */
    @Test
    public void testRemoveRecursiveNichtKopiert()
    {
        final Elem<Integer> original = Elem.of(1, 2, 3);
        final Elem<Integer> drittes = original.getNext().getNext();
        assertTrue(List.removeRecursive(original, 1).getNext() == drittes,
                "Die übrigen Elemente sollen dieselben bleiben.");
    }

    /** Zweimal hintereinander entfernen. */
    @Test
    public void testRemoveRecursiveMehrfach()
    {
        Elem<Integer> list = Elem.of(1, 2, 3, 4);
        list = List.removeRecursive(list, 0);
        list = List.removeRecursive(list, 2);
        assertEquals("[2, 3]", Elem.toString(list));
    }

    /** Längere Liste. */
    @Test
    public void testRemoveRecursiveLaengereListe()
    {
        assertEquals("[1, 2, 3, 5, 6]",
                Elem.toString(List.removeRecursive(Elem.of(1, 2, 3, 4, 5, 6), 3)));
    }
}