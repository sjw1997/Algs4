package CHAPTER_4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class EdgeWeightedDigraphTest {

    @Test
    public void testToString() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        StdOut.println(G);
    }
}
