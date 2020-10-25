package CHAPTER_4_3;

/**
 * Minimum spanning tree for a connected edge-weighted graph.
 */
public interface MST {
    Iterable<Edge> edges();
    double weight();
}
