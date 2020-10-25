package CHAPTER_4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {

    private String[] keys;
    private ST<String, Integer> index;
    private Digraph G;

    public SymbolDigraph(String fileName, String delimiter) {
        In in = new In(fileName);
        index = new ST<>();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            for (int i = 0; i < a.length; i++) {
                if (!index.contains(a[i])) {
                    index.put(a[i], index.size());
                }
            }
        }
        keys = new String[index.size()];
        for (String key : index.keys()) {
            keys[index.get(key)] = key;
        }
        G = new Digraph(index.size());
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = index.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, index.get(a[i]));
            }
        }
    }

    public Digraph G() {
        return G;
    }

    public int index(String key) {
        return index.get(key);
    }

    public String name(int t) {
        return keys[t];
    }

    public boolean contains(String s) {
        return index.contains(s);
    }
}
