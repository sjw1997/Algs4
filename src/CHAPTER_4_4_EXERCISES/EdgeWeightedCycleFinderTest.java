package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_4.DirectedEdge;
import CHAPTER_4_4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class EdgeWeightedCycleFinderTest {

    @Test
    public void testCycle() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        EdgeWeightedCycleFinder cy = new EdgeWeightedCycleFinder(G);
        if (cy.hasCycle()) {
            for (DirectedEdge e : cy.cycle()) {
                StdOut.println(e);
            }
        }
    }
}
