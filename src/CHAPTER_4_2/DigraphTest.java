package CHAPTER_4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class DigraphTest {

    @Test
    public void testDigraph() {
        Digraph G = new Digraph(new In());
        StdOut.println(G);
    }
}
