package CHAPTER_4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST implements MST {

    private Edge[] edgeTo;              // shortest edge from tree vertex
    private boolean[] marked;           // disTo[w] = edgeTo[w].weight()
    private double[] distTo;            // true if v on tree
    private IndexMinPQ<Double> pq;      // eligible crossing edges

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;
        pq.insert(0, 0.0);          // Initialize pq with 0, weight 0.
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());        // Add closest vertex to tree
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {               // v-w is ineligible
                continue;
            }
            if (e.weight() < distTo[w]) {  // Edge e is new best connection from tree
                edgeTo[w] = e;             // to w.
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        Bag<Edge> res = new Bag<>();
        for (Edge e : edgeTo) {
            res.add(e);
        }
        return res;
    }

    @Override
    public double weight() {
        return 0;
    }
}
