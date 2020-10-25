package CHAPTER_4_1_EXERCISES;

import CHAPTER_4_1.Graph;
import edu.princeton.cs.algs4.UF;

public class Search {

    private final int V;
    private final int s;
    private UF uf;

    public Search(Graph G, int s){
        this.s = s;
        this.V = G.V();
        uf = new UF(G.V());
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                uf.union(v, w);
            }
        }
    }

    public boolean marked(int v) {
        return uf.connected(s, v);
    }

    public int count() {
        int count = 0;
        for (int v = 0; v < V; v++) {
            if (v != s && uf.connected(s, v)) {
                count++;
            }
        }
        return count;
    }
}
