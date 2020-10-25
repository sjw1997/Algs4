package CHAPTER_4_1_EXERCISES;

import CHAPTER_4_1.BreadthFirstPaths;
import CHAPTER_4_1.Graph;
import CHAPTER_4_1.SymbolGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BaconHistogram {

    public static void main(String[] args) {
        String fileName = args[0], delim = "/";
        SymbolGraph sg = new SymbolGraph(fileName, delim);
        Graph G = sg.G();
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, sg.index("Bacon, Kevin"));
        int[] distance = new int[1000];
        int infinity = 0;
        for (int v = 0; v < G.V(); v++) {
            int dis = bfs.disTo(v);
            if (dis < 1000) {
                distance[dis]++;
            } else {
                infinity++;
            }
        }
        for (int i = 0; i < 10; i++) {
            StdOut.println(i + ": " + distance[i]);
        }
        StdOut.println("Infinity: " + infinity);
    }
}
