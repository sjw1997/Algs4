package CHAPTER_4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class BFSDirectedPathsTest {

    @Test
    public void testDFSDirectedPaths() {
        Digraph G = new Digraph(new In());
        int s = 3;
        BFSDirectedPaths bfs = new BFSDirectedPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d): ", s, v, bfs.disTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(s);
                    } else {
                        StdOut.print("->" + x);
                    }
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d (-): not connected\n", s, v);
            }
        }
    }
}
