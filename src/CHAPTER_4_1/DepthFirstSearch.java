package CHAPTER_4_1;

public class DepthFirstSearch {

    private boolean marked[];
    private int count;

    // find vertices connected to a source s
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    // is v connected to s?
    public boolean marked(int v) {
        return marked[v];
    }

    // how many vertices are connected to s?
    public int count() {
        return count;
    }

}
