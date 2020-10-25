package CHAPTER_1_3_EXERCISES;

import CHAPTER_1_3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class CopyStack {

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> res = new Stack<>();
        String[] a = new String[stack.size()];
        int i = 0;
        for (String s : stack) {
            a[i++] = s;
        }
        for (int j = i - 1; j >= 0; j--) {
            res.push(a[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack<String> a = new Stack<>();
        a.push("to");
        a.push("be");
        a.push("or");
        a.push("not");
        a.push("to");
        a.push("be");
        Stack<String> b = copy(a);
        for (String s : a) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        for (String s : b) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
