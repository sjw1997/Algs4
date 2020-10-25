package CHAPTER_4_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DegreeOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty()) {
            String des = StdIn.readLine();
            if (sg.contains(des)) {
                int t = sg.index(des);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        StdOut.println("  " + sg.name(v));
                    }
                    StdOut.println("  " + des);
                } else {
                    StdOut.println("Not connected.");
                }
            } else {
                StdOut.println(des + " not in database.");
            }
        }

    }
}
