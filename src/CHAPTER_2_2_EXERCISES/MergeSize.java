package CHAPTER_2_2_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class MergeSize {

    private static void merge(int lo, int mid, int hi) {
        StdOut.print(hi - lo + 1 + " ");
    }

    private static void topDownBottom(int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        topDownBottom(lo, mid);
        topDownBottom(mid + 1, hi);
        merge(lo, mid, hi);
    }

    private static void topDownBottom(Comparable[] a) {
        topDownBottom(0, a.length - 1);
    }

    private static void bottomUp(Comparable[] a) {
        int N = a.length;
        for (int len = 1; len < N; len = len + len) {
            for (int lo = 0; lo < N - len; lo += len + len) {
                merge(lo, lo + len - 1, Math.min(lo + len + len - 1 , N - 1));
            }
        }
    }

    public static void main(String[] args) {
        int N = 39;
        Double[] a = new Double[N];
        StdOut.println("top-down merge size: ");
        MergeSize.topDownBottom(a);
        StdOut.println();
        StdOut.println("down-top merge size: ");
        MergeSize.bottomUp(a);
        StdOut.println();
    }
}
