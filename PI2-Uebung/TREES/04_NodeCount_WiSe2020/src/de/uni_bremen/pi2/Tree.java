package de.uni_bremen.pi2;

/**
 * Aufgabe 3: NodeCount (20 %).
 * Wiederholungsklausur WiSe 2019/20 (Variante: null zählt NICHT).
 *
 * Es dürfen keine Methoden der Laufzeitbibliothek verwendet werden.
 */
public class Tree
{
    /**
     * Bestimmt die Anzahl der Knoten eines Binärbaums.
     * @param root Die Wurzel des Baums. Kann null sein.
     * @param <E> Der Typ der in den Knoten gespeicherten Werte.
     * @return Die Anzahl der Knoten. Ein leerer Baum (null) hat 0 Knoten.
     */
    public static <E> int nodeCount(final Node<E> root)
    {
        if (root == null){
            return 0;
        }
        int left = nodeCount(root.getLeft());
        int right = nodeCount(root.getRight());
        return left + right + 1;

    }
}
