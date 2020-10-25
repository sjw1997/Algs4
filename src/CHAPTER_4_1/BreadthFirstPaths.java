package CHAPTER_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] disTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        disTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    disTo[w] = disTo[v] + 1;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = edgeTo[v]; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public int disTo(int v) {
        if (!hasPathTo(v)) {
            return Integer.MAX_VALUE;
        }
        return disTo[v];
    }

    public static void main(String[] args) {
        String fileName = args[0];
        In in = new In(fileName);
        Graph G = new Graph(in);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
        for (int v = 0; v < G.V(); v++) {
            StdOut.println(v + ": " + bfs.disTo(v));
        }
    }
}
