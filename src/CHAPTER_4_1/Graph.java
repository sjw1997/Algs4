package CHAPTER_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Graph {

    protected int V;
    protected int E;
    protected Bag<Integer>[] adj;
    private boolean allowParallelSelfLoop = true;

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int e = 0; e < E; e++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
        //Exercise
//        while (in.hasNextLine()) {
//            int v = in.readInt();
//            String[] a = in.readLine().split(" ");
//            for (int i = 1; i < a.length; i++) {
//                addEdge(v, Integer.parseInt(a[i]));
//            }
//        }
    }

    public Graph(Graph other) {
        this(other.V());
        E = other.E();
        for (int v = 0; v < V; v++) {
            Stack<Integer> reverse = new Stack<>();
            for (int w : other.adj(v)) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    public boolean hasEdge(int v, int w) {
        for (int x : adj(v)) {
            if (x == w) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(int v, int w) {
        // if don't allow parallel edge and self-loops
        if (!allowParallelSelfLoop) {
            if (hasEdge(v, w) || v == w) {
                throw new IllegalArgumentException("Disallow parallel edge and" +
                        "self-loops.");
            }
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public static int degree(Graph G, int v) {
        int count = 0;
        for (int i: G.adj(v)) {
            count++;
        }
        return count;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        int V = G.V();
        for (int v = 0; v < V; v++) {
            max = Math.max(max, degree(G, v));
        }
        return max;
    }

    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numOfSelfLoop(Graph G) {
        int count = 0;
        int V = G.V();
        for (int v = 0; v < V; v++) {
            for (int w: G.adj(v)) {
                count = v == w ? count + 1 : count;
            }
        }
        return count / 2;       // each edge counted twice
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        String fileName = args[0];
        In in = new In(fileName);
        Graph G1 = new Graph(in);
        Graph G2 = new Graph(G1);
        StdOut.println("G1:\n" + G1);
        StdOut.println("G2\n" + G2);
    }
}
