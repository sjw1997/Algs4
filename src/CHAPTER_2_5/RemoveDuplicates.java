package CHAPTER_2_5;

import CHAPTER_2_1.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class RemoveDuplicates {

    // Returns the objects in a[] in sorted order, with duplicates removed
    public static String[] dedup(String[] a) {
        int N = a.length;
        String[] t = new String[N];
        int k = 0;
        t[k] = a[k++];
        for (int i = 1; i < N; i++) {
            if (!a[i].equals(a[i - 1])) {
                t[k++] = a[i];
            }
        }

        String[] res = new String[k];
        for (int i = 0; i < k; i++) {
            res[i] = t[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"test", "test", "a", "test"};
        Insertion.sort(a);
        String[] t = dedup(a);
        for (String s : t) {
            StdOut.println(s);
        }
    }
}
