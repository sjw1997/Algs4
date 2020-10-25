package CHAPTER_5_1;

import CHAPTER_2_1.Insertion;

/**
 * Most significant digit sort, where strings are not necessarily
 * all the same length.
 */
public class MSD {

    private static int R = 256;             // radix
    private static final int M = 15;        // cutoff for small subarrays
    private static String[] aux;            // auxiliary array for distribution

    private static int charAt(String a, int d) {
        if (d < a.length()) {
            return a.charAt(d);
        }
        return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int[] counts = new int[R + 2];
        // Compute frequency counts
        for (int i = lo; i <= hi; i++) {
            counts[charAt(a[i], d) + 2]++;
        }
        // Transform counts to indices
        for (int r = 0; r < R + 1; r++) {
            counts[r + 1] += counts[r];
        }
        // Distribution
        for (int i = lo; i <= hi; i++) {
            aux[counts[charAt(a[i], d) + 1]++] = a[i];
        }
        // Copy back
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i];
        }
        // Recursively sort for each character value
        for (int r = 0; r < R; r++) {
            sort(a, lo + counts[r], lo + counts[r + 1] - 1, d + 1);
        }
    }
}
