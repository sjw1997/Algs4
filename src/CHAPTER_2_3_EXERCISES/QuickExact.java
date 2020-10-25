package CHAPTER_2_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickExact {

    public static int countCmp;
    public static int countExch;

    public static void sort(Comparable[] a) {
        countCmp = 0;
        countExch = 0;
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // select a random key, and exchange it with a[lo]
        int random = lo + StdRandom.uniform(hi - lo);
        exch(a, lo, random);

        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // scan left, scan right, check for complete, and exchange
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        countCmp++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        countExch++;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Double[] a;
        for (int N  = 100; N <= 10000; N *= 10) {
            a = new Double[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            sort(a);
            StdOut.printf("%d items, comparision time: %d, ", N, countCmp);
            StdOut.printf("exchange times: %d, total: %d\n", countExch, countCmp + countExch);
            StdOut.println("approximation: " + N * 2 * Math.log(N));
        }
    }
}
