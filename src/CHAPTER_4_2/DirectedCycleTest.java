package CHAPTER_4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class DirectedCycleTest {

    @Test
    public void testCycle() {
        Digraph G = new Digraph(new In());
        DirectedCycle dc = new DirectedCycle(G);
        StdOut.println(dc.hasCycle());
        StdOut.println(dc.cycle());
    }
}
