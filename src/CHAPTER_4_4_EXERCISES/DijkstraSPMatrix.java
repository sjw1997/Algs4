package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_4.DirectedEdge;
import CHAPTER_4_4.SP;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;


public class DijkstraSPMatrix implements SP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    private int s;

    public DijkstraSPMatrix(EdgeWeightedDigraphMatrix G, int s) {
        this.s = s;
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraphMatrix G, int v) {
        double[] adj = G.adj(v);
        for (int w = 0; w < G.V(); w++) {
            if (distTo[w] > distTo[v] + adj[w]) {
                distTo[w] = distTo[v] + adj[w];
                edgeTo[w] = new DirectedEdge(v, w, adj[w]);
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    @Override
    public double distTo(int v) {
        if (!hasPathTo(v)) {
            throw new UnsupportedOperationException(v + " is not reachable!");
        }
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            throw new UnsupportedOperationException(v + " is not reachable!");
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge x = edgeTo[v]; x != null; x = edgeTo[x.from()]) {
            path.push(x);
        }
        return path;
    }
}
