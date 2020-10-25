package CHAPTER_4_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BellmanFordSP implements SP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private Queue<Integer> queue;
    private boolean[] onQ;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        queue = new Queue<>();
        onQ = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                edgeTo[w] = e;
                distTo[w] = distTo[v] + e.weight();
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0) {
                findNegateCycle();
                if (hasNegativeCycle()) {
                    return;
                }
            }
        }
    }

    private void findNegateCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (DirectedEdge e : edgeTo) {
            if (e != null) {
                G.addEdge(e);
            }
        }
        EdgeWeightedDirectedCycle c = new EdgeWeightedDirectedCycle(G);
        cycle = c.cycle();
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    @Override
    public double distTo(int v) {
        if (hasNegativeCycle()) {
            throw new UnsupportedOperationException("Negative cycle exists.");
        }
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (hasNegativeCycle()) {
            throw new UnsupportedOperationException("Negative cycle exists");
        }
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge x = edgeTo[v]; x != null; x = edgeTo[x.from()]) {
            path.push(x);
        }
        return path;
    }
}
