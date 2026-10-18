package de.uni_bremen.pi2;

/**
 * Ein Element einer Menge. Jede Menge ist ein Baum, in dem jeder Knoten auf
 * seinen Elternknoten zeigt. Die Wurzel zeigt auf sich selbst.
 * (Nachbau der Hilfsklasse aus der Klausur.)
 */
public class Node
{
    /** Der Elternknoten. Bei der Wurzel der Knoten selbst. */
    private Node parent = this;

    /** @return Der Elternknoten (bei der Wurzel der Knoten selbst). */
    public Node getParent()
    {
        return parent;
    }

    /**
     * Setzt den Elternknoten.
     * @param parent Der neue Elternknoten.
     */
    public void setParent(final Node parent)
    {
        this.parent = parent;
    }
}
