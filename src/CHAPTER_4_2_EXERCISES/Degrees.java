package CHAPTER_4_2_EXERCISES;

import CHAPTER_4_2.Digraph;
import edu.princeton.cs.algs4.Bag;

public class Degrees {

    private int[] indegree;
    private int[] outdegree;
    private Bag<Integer> sinks;
    private Bag<Integer> sources;
    private boolean isMap;

    public Degrees(Digraph G) {
        indegree = new int[G.V()];
        outdegree = new int[G.V()];
        sinks = new Bag<>();
        sources = new Bag<>();
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                outdegree[v]++;
                indegree[w]++;
            }
        }
        isMap = true;
        for (int v = 0; v < G.V(); v++) {
            if (indegree[v] == 0) {
                sources.add(v);
            }
            if (outdegree[v] != 1) {
                isMap = false;
                if (outdegree[v] == 0) {
                    sinks.add(v);
                }
            }
        }
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int outdegree(int v) {
        return outdegree[v];
    }

    public Iterable<Integer> sources() {
        return sources;
    }

    public Iterable<Integer> sinks() {
        return sinks;
    }

    public boolean isMap() {
        return isMap;
    }
}
