package de.uni_bremen.pi2;

/**
 * Ein Knoten eines Binärbaums (Nachbau der Hilfsklasse aus der Klausur).
 * @param <E> Der Typ des gespeicherten Werts.
 */
public class Node<E>
{
    /** Der Wert. */
    private final E value;

    /** Der linke Teilbaum oder null. */
    private final Node<E> left;

    /** Der rechte Teilbaum oder null. */
    private final Node<E> right;

    /**
     * Erzeugt einen Knoten ohne Kinder.
     * @param value Der Wert.
     */
    public Node(final E value)
    {
        this(value, null, null);
    }

    /**
     * Erzeugt einen Knoten mit Kindern.
     * @param value Der Wert.
     * @param left Der linke Teilbaum oder null.
     * @param right Der rechte Teilbaum oder null.
     */
    public Node(final E value, final Node<E> left, final Node<E> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /** @return Der Wert. */
    public E getValue()
    {
        return value;
    }

    /** @return Der linke Teilbaum oder null. */
    public Node<E> getLeft()
    {
        return left;
    }

    /** @return Der rechte Teilbaum oder null. */
    public Node<E> getRight()
    {
        return right;
    }
}
