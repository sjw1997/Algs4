package CHAPTER_4_2_EXERCISES;

import CHAPTER_4_2.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class DegreesTest {

    @Test
    public void testDegrees() {
        Digraph G = new Digraph(new In());
        Degrees degrees = new Degrees(G);
        StdOut.printf("%s %8s %8s\n", "vertex", "indegree", "outdegree");
        for (int v = 0; v < G.V(); v++){
            StdOut.printf("%2d%5d%5d\n", v, degrees.indegree(v), degrees.outdegree(v));
        }
        StdOut.print("Sources: ");
        for (int w : degrees.sources()) {
            StdOut.print(w + " ");
        }
        StdOut.println();
        StdOut.print("Sinks: ");
        for (int w : degrees.sinks()) {
            StdOut.print(w + " ");
        }
        StdOut.println();
        StdOut.println("isMap: " + degrees.isMap());
    }
}
