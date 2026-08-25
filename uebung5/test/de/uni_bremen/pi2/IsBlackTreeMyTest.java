package de.uni_bremen.pi2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static de.uni_bremen.pi2.IsRedBlackTreeEx1.Result.*;
import static de.uni_bremen.pi2.RBNode.Color.*;

/** Test-Klasse für die Klasse {@link IsRedBlackTree}. */

public class IsBlackTreeMyTest {
    @Test
    public void checkReturnsOkForEmptyTree()
    {
        final RBTree<Integer> tree = new RBTree<>();
        assertEquals(OK, IsRedBlackTree.check(tree));
    }

}
