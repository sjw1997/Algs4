package CHAPTER_4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST implements MST {

    private boolean[] marked;           // MST vertices
    private Queue<Edge> mst;            // MST edges
    private MinPQ<Edge> pq;             // crossing (and ineligible) edges
    private double weight;              // MST weight

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();
        visit(G, 0);                  // assume G is connected
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();       // Get the lowest-weight edge from pq
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) {       // skip if ineligible
                continue;
            }
            mst.enqueue(e);             // Add edge to tree
            weight += e.weight();
            if (!marked[v]) {           // Add vertex to tree (either v or w)
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    // Mark v and add to pq all edges from v to unmarked vertices.
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return weight;
    }
}
