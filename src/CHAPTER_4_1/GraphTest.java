package CHAPTER_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.introcs.StdIn;
import org.junit.Test;

public class GraphTest {

    @Test
    public void testInputStream() {
        Graph G = new Graph(new In());
        StdOut.println(G);
    }
}
