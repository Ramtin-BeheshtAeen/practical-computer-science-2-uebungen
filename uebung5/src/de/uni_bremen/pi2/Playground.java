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

    System.out.println(tree);                        // the toString draws it!
    System.out.println(IsRedBlackTreeEx1.check(tree));
    }
}
