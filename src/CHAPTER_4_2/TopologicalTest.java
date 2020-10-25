package CHAPTER_4_2;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class TopologicalTest {

    @Test
    public void testTopological() {
        String fileName = "E:\\learning\\graduate\\Algs4\\Data\\jobs.txt";
        String delimiter = "/";
        SymbolDigraph symbolDigraph = new SymbolDigraph(fileName, delimiter);
        Digraph G = symbolDigraph.G();
        Topological topological = new Topological(G);
        for (int v : topological.order()) {
            StdOut.println(symbolDigraph.name(v));
        }
    }
}
