package CHAPTER_5_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.List;

public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pattern) {
        pat = pattern;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int j = 0, X = 0; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        // Simulation operation of DFA on txt
        int j, M = pat.length();
        int i, N = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {   // found (hit end of pattern)
            return i - M;
        } else {        // not found (hit end of txt)
            return N;
        }
    }

    public List<Integer> searchAll(String txt) {
        List<Integer> lst = new LinkedList<>();
        int offset = search(txt, 0);
        int n = txt.length();
        while (offset != n) {
            lst.add(offset);
            offset = search(txt, offset + 1);
        }
        return lst;
    }

    public int count(String txt) {
        return searchAll(txt).size();
    }

    private int search(String txt, int lo) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = lo, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }

    public static void main(String[] args) {
        String pat = args[0], txt = args[1];
        KMP kmp = new KMP(pat);
        StdOut.println("txt:     " + txt);
        for (int offset : kmp.searchAll(txt)) {
            StdOut.print("pattern: ");
            for (int i = 0; i < offset; i++) {
                StdOut.print(" ");
            }
            StdOut.println(pat);
        }
    }
}
