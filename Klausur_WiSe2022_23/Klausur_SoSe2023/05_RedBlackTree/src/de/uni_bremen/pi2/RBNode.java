package de.uni_bremen.pi2;

/**
 * Ein Knoten eines Rot-Schwarz-balancierten Binärbaums. Diese Klasse ist
 * bereits vollständig implementiert und muss nicht verändert werden.
 * @param <E> Der Typ der in dem Knoten gespeicherten Daten.
 */
public class RBNode<E>
{
    /** Die möglichen Farben von Knoten. */
    public enum Color
    {
        BLACK,
        RED
    }

    /** Die in dem Knoten gespeicherten Daten. */
    private final E data;

    /** Der linke Kindknoten. Ist null, wenn es keinen gibt. */
    private final RBNode<E> left;

    /** Der rechte Kindknoten. Ist null, wenn es keinen gibt. */
    private final RBNode<E> right;

    /** Die Farbe dieses Knotens. */
    private final Color color;

    /**
     * Erzeugt einen neuen Knoten.
     * @param data Die in dem Knoten gespeicherten Daten.
     * @param left Der linke Kindknoten. Ist null, wenn es keinen gibt.
     * @param right Der rechte Kindknoten. Ist null, wenn es keinen gibt.
     * @param color Die Farbe des Knotens.
     */
    public RBNode(final E data, final RBNode<E> left, final RBNode<E> right, final Color color)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.color = color;
    }

    /**
     * Liefert die in dem Knoten gespeicherten Daten.
     * @return Die gespeicherten Daten.
     */
    public E getData()
    {
        return data;
    }

    /**
     * Liefert den linken Kindknoten.
     * @return Der linke Kindknoten oder null, wenn es keinen gibt.
     */
    public RBNode<E> getLeft()
    {
        return left;
    }

    /**
     * Liefert den rechten Kindknoten.
     * @return Der rechte Kindknoten oder null, wenn es keinen gibt.
     */
    public RBNode<E> getRight()
    {
        return right;
    }

    /**
     * Ist dieser Knoten schwarz?
     * @return true, wenn der Knoten schwarz ist, sonst false.
     */
    public boolean isBlack()
    {
        return color == Color.BLACK;
    }
}
