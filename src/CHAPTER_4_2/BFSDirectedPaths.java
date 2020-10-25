package CHAPTER_4_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import javax.swing.text.SimpleAttributeSet;
import java.util.zip.InflaterInputStream;

public class BFSDirectedPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private final int s;
    private final static int INFINITY = Integer.MAX_VALUE;

    public BFSDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = INFINITY;
        }
        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int disTo(int v) {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
