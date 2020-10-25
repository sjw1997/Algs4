package CHAPTER_2_1;

/**
 * Selection Sort
 * 1. Find the smallest item and exchange it with the first item.
 * 2. Find the next smallest item and exchange it with the second item.
 * 3. Continue this way until the array is sorted.
 */
public class Selection {

    // Sort a[] into increasing order.
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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
}
