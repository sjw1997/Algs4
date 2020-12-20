package CHAPTER_5_4;

import CHAPTER_1_3.Bag;
import CHAPTER_1_3.Stack;
import CHAPTER_4_2.Digraph;
import CHAPTER_4_2.DirectedDFS;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class NFA {

    private char[] re;
    private int M;
    private Digraph G;

    public NFA(String regexp) {
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);
        Stack<Integer> ops = new Stack<>();
        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }
            if (i < M - 1 && re[i + 1] == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == ')' || re[i] == '*') {
                G.addEdge(i, i + 1);
            }
        }
    }

    public boolean recognizes(String text) {
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                pc.add(v);
            }
        }
        for (int i = 0; i < text.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == text.charAt(i) || re[v] == '.') {
                        match.add(v + 1);
                    }
                }
            }
            pc = new Bag<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
        }
        for (int v : pc) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String regexp = "(" + args[0] + ")";
        String regexp = args[0];
        NFA nfa = new NFA(regexp);
        while (StdIn.hasNextLine()) {
            String txt = StdIn.readLine();
            if (nfa.recognizes(txt)) {
                StdOut.println(txt);
            }
        }
    }
}
