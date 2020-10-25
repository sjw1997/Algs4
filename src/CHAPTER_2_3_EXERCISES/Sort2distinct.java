package CHAPTER_2_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Sort2distinct {

    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1, i = 1;
        Comparable v = a[0];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp > 0) {
                exch(a, i, gt--);
            } else  if (cmp < 0) {
                exch(a, i++, lt++);
            } else {
                i++;
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 1, 2, 1, 2};
        Sort2distinct.sort(a);
    }
}
