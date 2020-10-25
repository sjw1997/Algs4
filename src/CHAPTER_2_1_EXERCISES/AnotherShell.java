package CHAPTER_2_1_EXERCISES;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class AnotherShell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int[] hs = new int[N / 3 + 1];
        int len = 0;
        for (int t = 1; t < N / 3; t = 3 * t + 1) {
            hs[len++] = t;
        }

        int[] countCompare = new int[len];
        for (int k = 0; k < len; k++) {
            int h = hs[k];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h], countCompare, k); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }

        int sumCompare = 0;
        for (int count : countCompare) {
            sumCompare += count;
        }

        StdOut.println(N + "items, " + "compare " + sumCompare + " times");
        for (int i = 0; i < len; i++) {
            StdOut.printf("%d-sort, compare %d times\n", hs[i], countCompare[i]);
        }

    }

    private static boolean less(Comparable v, Comparable w, int[] count, int k) {
        count[k]++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (Comparable c : a) {
            StdOut.print(c + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Double[] a;
        int N = 100;
        for (int i = 0; i < 5; i++, N *= 10) {
            a = new Double[N];
            for (int j = 0; j < a.length; j++) {
                a[j] = StdRandom.uniform();
            }
            AnotherShell.sort(a);
        }
    }

}
