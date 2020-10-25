package CHAPTER_1_2;

import edu.princeton.cs.algs4.StdOut;

public class Vector {

    private final double[] corrds;

    public Vector(double[] a) {
        corrds = a;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (double a : corrds) {
            res.append(a + " ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        double[] a = { 3.0, 4.0 };
        Vector vector = new Vector(a);
        a[0] = 0.2;
        StdOut.println(vector);
    }
}
