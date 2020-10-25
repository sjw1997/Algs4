package CHAPTER_4_4;

public class DirectedEdge {

    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        from = v;
        to = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", from, to, weight);
    }

}
