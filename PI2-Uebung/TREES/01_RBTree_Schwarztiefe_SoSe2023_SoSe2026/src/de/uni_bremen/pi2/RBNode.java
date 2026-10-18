package de.uni_bremen.pi2;

/**
 * Ein Knoten eines Rot-Schwarz-Baums.
 *
 * Nachbau der Hilfsklasse aus der Klausur (die Originaldatei liegt im
 * Stud.IP). Die Musterlösung benutzt isBlack(), getLeft() und getRight().
 */
public class RBNode
{
    /** Ist dieser Knoten schwarz? Sonst ist er rot. */
    private final boolean black;

    /** Der linke Teilbaum. null ist ein Blatt. */
    private final RBNode left;

    /** Der rechte Teilbaum. null ist ein Blatt. */
    private final RBNode right;

    /**
     * Konstruktor.
     * @param black Ist der Knoten schwarz (true) oder rot (false)?
     * @param left Der linke Teilbaum oder null.
     * @param right Der rechte Teilbaum oder null.
     */
    public RBNode(final boolean black, final RBNode left, final RBNode right)
    {
        this.black = black;
        this.left = left;
        this.right = right;
    }

    /** @return true, wenn schwarz, false, wenn rot. */
    public boolean isBlack()
    {
        return black;
    }

    /** @return Der linke Teilbaum oder null. */
    public RBNode getLeft()
    {
        return left;
    }

    /** @return Der rechte Teilbaum oder null. */
    public RBNode getRight()
    {
        return right;
    }
}
