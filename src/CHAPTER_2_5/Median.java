package CHAPTER_2_5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class Median {

    public static <Key extends Comparable<Key>> Key select(Key[] a, int k) {
        shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j == k) {
                break;
            } else if (j > k) {
                hi = j - 1;
            } else {
                lo = j + 1;
            }
        }
        return a[k];
    }

    public static <Key extends Comparable<Key>> Key selectRecursive(Key[] a, int k) {
        shuffle(a);
        return select(a, 0, a.length - 1, k);
    }

    public static <Key extends Comparable<Key>> Key select(Key[] a, int lo, int hi, int k) {
        int j = partition(a, lo, hi);
        if (j == k) {
            return a[k];
        } else if (j > k) {
            return select(a, lo, j - 1, k);
        } else {
            return select(a, j + 1, hi, k);
        }
    }

    private static void shuffle(Comparable[] a) {
        int lo = 0, hi = a.length - 1, N = a.length;
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            int j = lo + r.nextInt(hi - lo);
            exch(a, i, j);
        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
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
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] a2 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        StdOut.println(select(a, a.length / 2));
        StdOut.println(selectRecursive(a, a.length / 2));
    }
}
