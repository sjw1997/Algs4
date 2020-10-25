package CHAPTER_4_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class EdgeWeightedGraphTest {

    @Test
    public void testToString() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
        StdOut.println(G);
    }
}
