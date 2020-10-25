package CHAPTER_1_2_EXERCISES;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Interval1DClient {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Interval1D[] intervals = new Interval1D[N];
        int i = 0;
        while (!StdIn.isEmpty()) {
            double lo = StdIn.readDouble();
            double hi = StdIn.readDouble();
            intervals[i++] = new Interval1D(lo, hi);
        }
        for (int j = 0; j < N; j++) {
            for (int k = j + 1; k < N; k++) {
                if (intervals[j].intersects(intervals[k])) {
                    StdOut.println(intervals[j] + " " + intervals[k]);
                }
            }
        }
    }
}
