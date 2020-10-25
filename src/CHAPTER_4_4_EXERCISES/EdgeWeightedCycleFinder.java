package CHAPTER_4_4_EXERCISES;

import CHAPTER_4_4.DirectedEdge;
import CHAPTER_4_4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Stack;

public class EdgeWeightedCycleFinder {

    private boolean[] marked;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;
    private DirectedEdge[] edgeTo;

    public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (hasCycle()) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = e;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                DirectedEdge x = e;
                while (x.from() != w) {
                    cycle.push(x);
                    x = edgeTo[x.from()];
                }
                cycle.push(x);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }
}
