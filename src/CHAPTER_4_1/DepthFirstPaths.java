package CHAPTER_4_1;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {

    private boolean[] marked;   //Has dfs() been called for this vertex
    private int[] edgeTo;   // last vertex on known path to this vertex
    private final int s;    // source

    // find path in G from s
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    // is there a path from s to v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // path from s to v: null if no such path exists
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
