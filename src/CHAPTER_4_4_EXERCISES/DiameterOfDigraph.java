package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_4.DijkstraSP;
import CHAPTER_4_4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DiameterOfDigraph {
    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In());
        double max = 0;
        int from = 0, to = 0;
        for (int v = 0; v < G.V(); v++) {
            DijkstraSP sp = new DijkstraSP(G, v);
            for (int w = 0; w < G.V(); w++) {
                if (!sp.hasPathTo(w)) {
                    StdOut.println("diameter: infinity");
                    return;
                }
                if (sp.distTo(w) > max) {
                    max = sp.distTo(w);
                    from = v;
                    to = w;
                }
            }
        }
        StdOut.printf("Diameter: %d->%d (%4.2f)", from, to, max);
    }
}
