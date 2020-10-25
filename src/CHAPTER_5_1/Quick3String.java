package CHAPTER_5_1;

public class Quick3String {

    private static int charAt(String a, int d) {
        if (d < a.length()) {
            return a.charAt(d);
        }
        return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        int lt = lo, gt = hi, i = lo + 1;
        int v = charAt(a[lo], d);
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) {
                exch(a, i++, lt++);
            } else if (t > v) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, lt + 1, gt, d);
    }

    private static void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
