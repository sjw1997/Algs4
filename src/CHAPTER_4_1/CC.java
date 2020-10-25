package CHAPTER_4_1;

/**
 * Connected component for a undirected graph.
 * 连通分量
 * Support queries of the form: Are two given vertices connected? and How many
 * connected components does the graph have?
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        id[s] = count;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                marked[w] = true;
                id[w] = count;
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }
}
