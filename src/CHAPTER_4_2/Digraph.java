package CHAPTER_4_2;

import CHAPTER_4_1.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Digraph extends Graph {

    private int[] inDegree;

    public Digraph(int V) {
        super(V);
        inDegree = new int[V];
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();       // read E
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Digraph(Digraph other) {
        this(other.V());
        for (int v = 0; v < other.V(); v++) {
            Stack<Integer> reverse = new Stack<>();
            for (int w : other.adj(v)) {
                reverse.push(w);
            }
            for (int w : reverse) {
                addEdge(v, w);
            }
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
        inDegree[w]++;
    }

    public int inDegree(int v) {
        return inDegree[v];
    }

    public int outDegree(int v) {
        return adj[v].size();
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public boolean hasEdge(int v, int w) {
        for (int x : adj(v)) {
            if (x == w) {
                return true;
            }
        }
        return false;
    }
}
