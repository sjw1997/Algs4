package CHAPTER_4_4_EXERCISES;

import edu.princeton.cs.algs4.In;

public class EdgeWeightedDigraphMatrix {

    private final int V;
    private double[][] adj;
    private int E;

    public EdgeWeightedDigraphMatrix(int V) {
        this.V = V;
        E = 0;
        adj = new double[V][V];
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < V; w++) {
                if (v != w) {
                    adj[v][w] = Double.POSITIVE_INFINITY;
                } else {
                    adj[v][w] = 0.0;
                }
            }
        }
    }

    public EdgeWeightedDigraphMatrix(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt(), w = in.readInt();
            double weight = in.readDouble();
            addEdge(v, w, weight);
        }
    }

    public void addEdge(int v, int w, double weight) {
        adj[v][w] = weight;
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public double[] adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w = 0; w < V; w++) {
                if (v != w && adj[v][w] != Double.POSITIVE_INFINITY) {
                    s.append(String.format("%d->%d %.2f ", v, w, adj[v][w]));
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
