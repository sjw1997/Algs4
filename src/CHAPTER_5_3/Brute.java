package CHAPTER_5_3;

import edu.princeton.cs.algs4.StdOut;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

public class Brute {
    private String pat;

    public Brute(String pattern) {
        pat = pattern;
    }

    public int search(String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {       // found (hit end of pattern)
            return i - M;
        } else {            // found (hit end of txt)
            return N;
        }
    }

    public int count(String txt) {
        return searchAll(txt).size();
    }

    public List<Integer> searchAll(String txt) {
        List<Integer> lst = new LinkedList<>();
        int offset = search(txt, 0);
        int N = txt.length();
        while (offset != N) {
            lst.add(offset);
            offset = search(txt, offset + 1);
        }
        return lst;
    }

    private int search(String txt, int lo) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = lo, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }

    public static void main(String[] args) {
        String pat = args[0], txt = args[1];
        Brute brute = new Brute(pat);
        StdOut.println("txt:     " + txt);
        for (int offset : brute.searchAll(txt)) {
            StdOut.print("pattern: ");
            for (int i = 0; i < offset; i++) {
                StdOut.print(" ");
            }
            StdOut.println(pat);
        }
    }
}
