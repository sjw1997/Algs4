package CHAPTER_4_1_EXERCISES;

import CHAPTER_4_1.BreadthFirstPaths;
import CHAPTER_4_1.Graph;

public class GraphProperties {

    private int[] eccentricity;
    private int center;
    private int radius;
    private int diameter;

    public GraphProperties(Graph G) {
        eccentricity = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            BreadthFirstPaths bfs = new BreadthFirstPaths(G, v);
            for (int w = 0; w < G.V(); w++) {
                eccentricity[v] = Math.max(eccentricity[v], bfs.disTo(w));
            }
        }
        diameter = radius = eccentricity[0];
        for (int v = 1; v < G.V(); v++) {
            diameter = Math.max(diameter, eccentricity[v]);
            if (eccentricity[v] < radius) {
                radius = eccentricity[v];
                center = v;
            }
        }
    }

    public int eccentricity(int v) {
        return eccentricity[v];
    }

    public int diameter() {
        return diameter;
    }

    public int radius() {
        return radius;
    }

    public int center() {
        return center;
    }
}
