package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class DijkstraSPMatrixTest {

    @Test
    public void test() {
        EdgeWeightedDigraphMatrix G = new EdgeWeightedDigraphMatrix(new In());
        int s = 0;
        DijkstraSPMatrix sp = new DijkstraSPMatrix(G, s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%d->%d (%4.2f): ", s, v, sp.distTo(v));
            if (sp.hasPathTo(v)) {
                for (DirectedEdge e : sp.pathTo(v)) {
                    int from = e.from(), to = e.to();
                    double weight = e.weight();
                    StdOut.printf("%d->%d(%4.2f) ", from, to, weight);
                }
            }
            StdOut.println();
        }
    }
}
