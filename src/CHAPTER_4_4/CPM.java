package CHAPTER_4_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Critical path method for parallel precedence-constrained job scheduling.
 * THETA(N)
 */
public class CPM {
    public static void main(String[] args) {
        int N = StdIn.readInt();  StdIn.readLine();     // read "\n"
        int s = 2 * N, t = 2 * N + 1;
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * N + 2);

        for (int i = 0; i < N; i++) {
            String[] a = StdIn.readLine().split(" ");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i, i + N, duration));
            G.addEdge(new DirectedEdge(i + N, t, 0.0));
            for (int j = 1; j < a.length; j++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i + N, successor, 0.0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);
        StdOut.println("Start times:");
        for (int i = 0; i < N; i++) {
            StdOut.printf("%4d: %5.1f\n", i, lp.distTo(i));
        }
        StdOut.printf("Finish time: %5.1f\n", lp.distTo(t));
        for (DirectedEdge e : lp.pathTo(t)) {
            if (e.from() < N) {
                StdOut.print(e.from() + " ");
            }
        }
    }
}
