package de.uni_bremen.pi2;
import static de.uni_bremen.pi2.RBNode.Color.*;

public class Playground {
    public void main(String[] args){
    // Tree B from our design discussion — the black-count violation:
    //       B1(10)
    //      /  \
    //     B2(5)   null
    RBNode<Integer> b2 = new RBNode<>(5, BLACK, null, null);
    RBNode<Integer> b1 = new RBNode<>(10, BLACK, b2, null);
    RBTree<Integer> tree = new RBTree<>(b1);
        //                 10 (B)
        //               /      \
        //          5 (B)    15 (B)
        //        /    \
        //      2 (R)   7 (R)

    RBNode<Integer> n2  = new RBNode<>(2, RED, null, null);
    RBNode<Integer> n7  = new RBNode<>(7, RED, null, null);
    RBNode<Integer> n5  = new RBNode<>(5, BLACK, n2, n7);
    RBNode<Integer> n15 = new RBNode<>(15, BLACK, null, null);
    RBNode<Integer> n10 = new RBNode<>(10, BLACK, n5, n15);
    RBTree<Integer> tree3 = new RBTree<>(n10);

    System.out.println(tree3);                        // the toString draws it!
    System.out.println(IsRedBlackTreeEx1.check(tree3));
    }
}
