package CHAPTER_2_5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 2, 5, 57 ,1};
        for (int i : a) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        Arrays.sort(a);
        for (int i : a) {
            StdOut.print(i + " ");
        }
        StdOut.println();

        IntegerComparator q = new IntegerComparator();
        Arrays.sort(a, q);
        for (int i : a) {
            StdOut.print(i + " ");
        }
    }
}
