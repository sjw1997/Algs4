package CHAPTER_1_2_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class CircularRotation {

    public static boolean isCircularShift(String v, String w) {
        return v.length() == w.length() && v.concat(v).contains(w);
    }

    public static void main(String[] args) {
        String v = "hello";
        String w = "llohe";
        StdOut.println(isCircularShift(v, w));
    }
}
