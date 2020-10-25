package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_2.DepthFirstOrder;
import CHAPTER_4_4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Stack;

import java.util.Queue;

public class EdgeWeightedTopological {

    private Iterable<Integer> order;

    public EdgeWeightedTopological(EdgeWeightedDigraph G) {
        EdgeWeightedCycleFinder cy = new EdgeWeightedCycleFinder(G);
        if (!cy.hasCycle()) {
            DepthFirstOrder dp = new DepthFirstOrder(G);
            order = dp.reversePost();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }
}
