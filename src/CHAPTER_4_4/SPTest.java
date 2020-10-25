package CHAPTER_4_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class SPTest {

    @Test
    public void testDijkstraSP() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        int source = 1;
        SP sp = new DijkstraSP(G, source);
        test(sp, source, G.V());
    }

    @Test
    public void testAcyclicSP() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        int source = 5;
        SP sp = new AcyclicSP(G, source);
        test(sp, source, G.V());
    }

    @Test
    public void testAcyclicLP() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        int source = 5;
        SP sp = new AcyclicLP(G, source);
        test(sp, source, G.V());
    }

    @Test
    public void testBellmanFordSP() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        int source = 0;
        SP sp = new BellmanFordSP(G, source);
        test(sp, source, G.V());
    }

    public void test(SP sp, int s, int V) {
        for (int t = 0; t < V; t++) {
            StdOut.printf("%d to %d (%.2f): ", s, t, sp.distTo(t));
            if (sp.hasPathTo(t)) {
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + " ");
                }
            }
            StdOut.println();
        }
    }

}
