package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class EdgeWeightedTopologicalTest {

    @Test
    public void test() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        EdgeWeightedTopological tp = new EdgeWeightedTopological(G);
        for (int v : tp.order()) {
            StdOut.print(v + " ");
        }
    }
}
