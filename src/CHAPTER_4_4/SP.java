package CHAPTER_4_4;

/**
 * Shortest-paths from a source to other nodes which are in a edge-weighted digraph.
 */
public interface SP {
    double distTo(int v);
    boolean hasPathTo(int v);
    Iterable<DirectedEdge> pathTo(int v);
}
