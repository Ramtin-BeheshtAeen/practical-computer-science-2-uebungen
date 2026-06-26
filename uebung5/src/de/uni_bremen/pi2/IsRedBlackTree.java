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
        // Definiert hier weitere Konstanten für die vier Eigenschaften,
        // die ihr prüfen könnt und die somit nicht erfüllt sein könnten.
        // Die fünfte Eigenschaft "Blätter sind schwarz" ist per
        // Definition immer erfüllt (Blätter sind null-Referenzen) und
        // kann somit nicht überprüft werden.

        /** Prüfung erfolgreich. */
        OK,
        /** Ein Knoten hat keine (null) Farbe. */
        MISSING_COLOR,

        /** Die Wurzel ist nicht schwarz. */
        ROOT_NOT_BLACK,

        /** Ein roter Knoten hat einen roten Kindknoten. */
        RED_HAS_RED_CHILD,

        /** Die Schwarzhöhe ist auf beiden Seiten eines Knotens unterschiedlich. */
        UNEQUAL_BLACK_HEIGHT

    }

    private static class NotRedBlackException extends RuntimeException
    {
        private final Result result;

        NotRedBlackException(final Result result)
        {
            this.result = result;
        }

        Result getResult()
        {
            return result;
        }
    }

    /**
     * Die Methode überprüft die Rot-Schwarz-Eigenschaften.
     * @param tree Der Baum, dessen Eigenschaften geprüft werden.
     * @return Das Ergebnis der Prüfung.
     * @param <E> Der Typ der im Baum gespeicherten Werte.
     */
    public static <E extends Comparable<E>> int checkNode(final Node<E> node ){
        int blackHeight = 0;
        if (node != null) {
            int leftHeight  =  checkNode(node.children[LEFT]);
            int rightHeight = checkNode(node.children[RIGHT]);
            //you don't walk through both simultaneously. So you only need one of leftHeight
            //Checl of the tree is healthy and have same black height at both sides
            if (leftHeight != rightHeight) {
                throw new NotRedBlackException(UNEQUAL_BLACK_HEIGHT);
            }
            blackHeight += leftHeight;

            if( node != null && ((RBNode<E>) node).color == BLACK  ){
                blackHeight++;
            }
        }
        else {
            //we are at the leaves
            blackHeight++;
        }

        return blackHeight;
    }

    public static <E extends Comparable<E>> Result check(final RBTree<E> tree)
    {
        // Every Node is either Black or White:
        //color must be non-null (let's call it property #1)
        //red node ⇒ both children non-red (#3)
        //black-height consistent on both sides (#4)



        return OK; // Das ist zu optimistisch!
    }
}
