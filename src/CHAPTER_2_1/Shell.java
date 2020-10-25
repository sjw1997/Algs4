package CHAPTER_2_1;

/**
 * Shell Sort, a fast algorithm based on insertion sort.
 * Insertion sort is fast on partially sorted arrays, so our goal is to make the
 * random array to partially sorted array.
 * The idea is to rearrange the array to give it the property that take every hth
 * entry(starting anywhere) yields a sorted subsequence.
 * Such an array is said to be h-sorted.
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;     // 1, 4, 13, 40, 121, ...
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
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
