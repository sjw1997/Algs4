package CHAPTER_2_5;

import CHAPTER_2_1.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Version implements Comparable<Version> {

    private final String versionNum;

    public Version(String s) {
        versionNum = s;
    }

    @Override
    public int compareTo(Version that) {
        String[] version1 = this.versionNum.split("\\.");
        String[] version2 = that.versionNum.split("\\.");
        int N = version1.length;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(version1[i]);
            int q = Integer.parseInt(version2[i]);
            if (p != q) {
                return p - q;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return versionNum;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Version[] v = new Version[a.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = new Version(a[i]);
        }
        Insertion.sort(v);
        for (Version q : v) {
            StdOut.println(q);
        }
    }
}
