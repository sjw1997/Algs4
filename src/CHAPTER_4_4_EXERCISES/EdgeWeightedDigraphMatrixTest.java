package CHAPTER_4_4_EXERCISES;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class EdgeWeightedDigraphMatrixTest {

    @Test
    public void testToString() {
        EdgeWeightedDigraphMatrix G = new EdgeWeightedDigraphMatrix(new In());
        StdOut.println(G);
    }
}
