package CHAPTER_2_5;

import CHAPTER_2_3.Quick;
import edu.princeton.cs.algs4.StdOut;

public class Frequency {

    private static class CountString implements Comparable<CountString> {
        String text;
        int times;

        public CountString(String s) {
            text = s;
            times = 1;
        }

        public int compareTo(CountString that) {
            return that.times - this.times;
        }

        public String toString() {
            return String.format("%-5s%4d", text, times);
        }
    }

    public static void countFrequency(String[] a) {
        int N = a.length;
        Quick.sort(a);
        CountString[] t = new CountString[N];
        int k = 0;
        t[k] = new CountString(a[k]);
        for (int i = 1; i < N; i++) {
            if (a[i].equals(a[i - 1])) {
                t[k].times++;
            } else {
                t[++k] = new CountString(a[i]);
            }
        }
        CountString[] res = new CountString[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = t[i];
        }
        Quick.sort(res);
        for (CountString p : res) {
            StdOut.println(p);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"this", "a", "a", "test", "test", "this", "java"};
        countFrequency(a);
    }
}
