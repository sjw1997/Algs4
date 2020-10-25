package CHAPTER_4_2;

/**
 * Given a digraph, support queries of the form: Is there a directed path from
 * a given vertex v to another vertex w?
 * This solution is ideal for small or dense digraphs, but it is not a solution
 * for the large digraphs we might encounter in practice because the constructor
 * uses space proportional to V^2 and time proportional to V(V+E).
 */
public class TransitiveClosure {

    private DirectedDFS[] all;

    public TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    // is w reachable from v?
    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
