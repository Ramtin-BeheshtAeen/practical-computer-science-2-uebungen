package de.uni_bremen.pi2;

/**
 * Der Knoten eines Binärbaums. Bereits vollständig implementiert.
 * @param <E> Der Typ des Werts, der im Knoten gespeichert werden kann.
 */
public class Node<E>
{
    /** Der im Knoten gespeicherte Wert. */
    private final E info;

    /** Der linke Kindknoten. Ist null, wenn es keinen gibt. */
    private final Node<E> left;

    /** Der rechte Kindknoten. Ist null, wenn es keinen gibt. */
    private final Node<E> right;

    /**
     * Konstruktor für ein Blatt (Knoten ohne Kinder).
     * @param info Der im Knoten gespeicherte Wert.
     */
    public Node(final E info)
    {
        this(info, null, null);
    }

    /**
     * Konstruktor für einen Knoten.
     * @param info Der im Knoten gespeicherte Wert.
     * @param left Der linke Kindknoten. Ist null, wenn es keinen gibt.
     * @param right Der rechte Kindknoten. Ist null, wenn es keinen gibt.
     */
    public Node(final E info, final Node<E> left, final Node<E> right)
    {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    /**
     * Liefert die im Knoten gespeicherte Information.
     * @return Der gespeicherte Wert.
     */
    public E getInfo()
    {
        return info;
    }

    /**
     * Liefert den linken Kindknoten.
     * @return Der linke Kindknoten oder null.
     */
    public Node<E> getLeft()
    {
        return left;
    }

    /**
     * Liefert den rechten Kindknoten.
     * @return Der rechte Kindknoten oder null.
     */
    public Node<E> getRight()
    {
        return right;
    }
}
