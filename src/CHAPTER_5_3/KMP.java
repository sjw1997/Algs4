package CHAPTER_5_3;

import edu.princeton.cs.algs4.StdOut;

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
        for (i = 0, j = 0; i < N; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {   // found (hit end of pattern)
            return i - M;
        } else {        // not found (hit end of txt)
            return N;
        }
    }

    public static void main(String[] args) {
        String pat = args[0], txt = args[1];
        KMP kmp = new KMP(pat);
        StdOut.println("txt:     " + txt);
        StdOut.print("pattern: ");
        int offset = kmp.search(txt);
        for (int i = 0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.print(pat);
    }
}
