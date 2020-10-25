package CHAPTER_5_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Least-significant-digit first (LSD) string sort
 * LSD string sort stably sorts fixed-length strings.
 */
public class LSD {
    // Sort a[] on leading W characters
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            int[] counts = new int[R + 1];
            // Compute frequency counts
            for (int i = 0; i < N; i++) {
                counts[a[i].charAt(d) + 1]++;
            }
            // Transform counts to indices
            for (int r = 0; r < R; r++) {
                counts[r + 1] += counts[r];
            }
            // Distribute
            for (int i = 0; i < N; i++) {
                aux[counts[a[i].charAt(d)]++] = a[i];
            }
            // Copy back
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        if (a.length == 0) {
            return;
        }
        int W = a[0].length();
        sort(a, W);
        for (String s : a) {
            StdOut.println(s);
        }
    }
}
