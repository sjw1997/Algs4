package CHAPTER_4_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class MSTTest {

    @Test
    public void testPrimMST() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
        MST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }

    @Test
    public void testKruskalMST() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In());
        MST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }

}
