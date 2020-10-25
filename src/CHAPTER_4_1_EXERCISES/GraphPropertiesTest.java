package CHAPTER_4_1_EXERCISES;

import CHAPTER_4_1.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class GraphPropertiesTest {

    @Test
    public void testGraphProperties() {
        Graph G = new Graph(new In());
        GraphProperties gp = new GraphProperties(G);
        for (int v = 0; v < G.V(); v++) {
            StdOut.println(v + "'s eccentricity is " + gp.eccentricity(v));
        }
        StdOut.println("diameter: " + gp.diameter());
        StdOut.println("radius: " + gp.radius());
        StdOut.println("center: " + gp.center());
    }
}
