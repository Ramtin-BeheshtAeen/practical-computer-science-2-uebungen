package de.uni_bremen.pi2;

import static de.uni_bremen.pi2.Node.*; // LEFT, RIGHT
import static de.uni_bremen.pi2.RBNode.Color.*; // RED, BLACK
import static de.uni_bremen.pi2.IsRedBlackTree.Result.*; // OK ...

/** Klasse zum Überprüfen der Eigenschaften von Rot-Schwarz-Bäumen. */
public class IsRedBlackTree
{
    /** Das Ergebnis eines Tests. */
    public enum Result
    {
        /** Prüfung erfolgreich. */
        OK,

        // Definiert hier weitere Konstanten für die vier Eigenschaften,
        // die ihr prüfen könnt und die somit nicht erfüllt sein könnten.
        // Die fünfte Eigenschaft "Blätter sind schwarz" ist per
        // Definition immer erfüllt (Blätter sind null-Referenzen) und
        // kann somit nicht überprüft werden.
    }

    /**
     * Die Methode überprüft die Rot-Schwarz-Eigenschaften.
     * @param tree Der Baum, dessen Eigenschaften geprüft werden.
     * @return Das Ergebnis der Prüfung.
     * @param <E> Der Typ der im Baum gespeicherten Werte.
     */
    public static <E extends Comparable<E>> Result check(final RBTree<E> tree)
    {
        return OK; // Das ist zu optimistisch!
    }
}
