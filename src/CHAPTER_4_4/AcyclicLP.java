package CHAPTER_4_4;

import CHAPTER_4_2.Topological;
import edu.princeton.cs.algs4.Stack;

/**
 * Single-source longest paths in edge-weighted DAGs(Directed Acyclic Graph).
 * Support queries of the form: Is there a directed path from s to a given vertex?
 * If so, find a longest such path(one whose total weight is maximal).
 */
public class AcyclicLP implements SP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicLP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            // The difference between AcyclicLP and AcyclicSP.
            distTo[v] = Double.NEGATIVE_INFINITY;
        }
        distTo[s] = 0.0;
        Topological tp = new Topological(G);
        if (!tp.isDAG()) {
            throw new IllegalArgumentException("G is not DAG!");
        }
        for (int v : tp.order()) {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            // The difference between AcyclicLP and AcyclicSP.
            if (distTo[w] < distTo[v] + e.weight()) {
                edgeTo[w] = e;
                distTo[w] = distTo[v] + e.weight();
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] > Double.NEGATIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
