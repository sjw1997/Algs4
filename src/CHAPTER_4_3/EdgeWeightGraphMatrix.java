package CHAPTER_4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class EdgeWeightGraphMatrix {

    private final int V;
    private int E;
    private double[][] adj;

    public EdgeWeightGraphMatrix(int V) {
        this.V = V;
        E = 0;
        adj = new double[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    adj[i][j] = 0.0;
                } else {
                    adj[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    public EdgeWeightGraphMatrix(In in) {
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
        adj[w][v] = weight;
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Edge> adj(int v) {
        Bag<Edge> res = new Bag<>();
        for (int i = 0; i < V; v++) {
            if (i != v && adj[v][i] != Double.POSITIVE_INFINITY) {
                res.add(new Edge(v, i, adj[v][i]));
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges.\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int i = 0; i < V; i++) {
                if (i != v && adj[v][i] != Double.POSITIVE_INFINITY) {
                    s += i + " ";
                }
            }
            s += "\n";
        }
        return s;
    }
}
