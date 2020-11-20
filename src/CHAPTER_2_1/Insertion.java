package CHAPTER_2_1;

/**
 * Insertion Sort
 * Insert each into its proper place among those already sorted.
 * Insert a[i] among a[i-1], a[i-2], a[i-3]......
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j , j - 1);
            }
        }
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int j = i, key = a[j];
            while (j > 0 && key > a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
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
        int[] a = {10, 9, 8, 7, 4, 12, 4};
        sort(a);
        for (int num : a) {
            System.out.println(num);
        }
    }

}
