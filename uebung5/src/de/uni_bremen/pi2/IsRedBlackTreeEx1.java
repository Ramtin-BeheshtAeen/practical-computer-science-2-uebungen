
package de.uni_bremen.pi2;

import static de.uni_bremen.pi2.Node.*; // LEFT, RIGHT
import static de.uni_bremen.pi2.RBNode.Color.*; // RED, BLACK
import static de.uni_bremen.pi2.IsRedBlackTreeEx1.Result.*; // OK ...

/** Klasse zum Überprüfen der Eigenschaften von Rot-Schwarz-Bäumen. */
public class IsRedBlackTreeEx1
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
        // kann somit nicht überprüft werden

        RED_ROOT, //-1,
        RED_RED,  //-2,
        NO_VALID_COLOR,  //-3,
        BLACK_COUNTS, //-4,
    }

    /**
     * Die Methode überprüft die Rot-Schwarz-Eigenschaften.
     * @param tree Der Baum, dessen Eigenschaften geprüft werden.
     * @return Das Ergebnis der Prüfung.
     * @param <E> Der Typ der im Baum gespeicherten Werte.
     */
    public static <E extends Comparable<E>> Result check(final RBTree<E> tree)
    {
        // empty tree? → ___
        if (tree.root == null){
            return OK; // empty tree
        }
        // look at the tree's root: color null? not black? → ___
        if (isRed(tree.root)){
            return RED_ROOT;
        }
        // int result = helper(the root);
        int result = helper(tree.root);
        return switch (result) {
            case -2 -> RED_RED;
            case -3 -> NO_VALID_COLOR;
            case -4 -> BLACK_COUNTS;
            default ->
                // negative? map to Result. otherwise ___
                    OK;
        };
    }

    private static <E> boolean isRed(Node<E> node){
        return node!=null && ((RBNode<E>) node).color == RED;
    }

    private static <E> int helper(final Node<E> node){
        //left = helper(node.children[LEFT]) — if negative, return it.
        //right = helper(node.children[RIGHT]) — if negative, return it.
        //If left != right → return -3.
        //Red-red check → return -2 if violated.
        //Return left (+1 if node is black)

        if(node == null){
            return 0;
        }

        if ( ((RBNode<E>) node).color == null){
            return -3; // No Valid color
        }
        int left = helper(node.children[LEFT]);
        int right = helper(node.children[RIGHT]);

        if (left < 0) { return left; }
        if (right < 0) { return right; }

        if(left != right){
            return -4; //Black_counts
        }

        if(isRed(node) && (isRed(node.children[LEFT]) || isRed(node.children[RIGHT]))){
            return -2; //red-red
        }

        return isRed(node) ? left : left+1;
    }


}

