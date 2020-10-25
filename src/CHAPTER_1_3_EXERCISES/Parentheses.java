package CHAPTER_1_3_EXERCISES;

import CHAPTER_1_3.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            if ('[' == ch || '(' == ch || '{' == ch) {
                stack.push(ch);
            } else if (']' == ch) {
                if (stack.isEmpty() || '[' != stack.pop()) {
                    return false;
                }
            } else if (')' == ch) {
                if (stack.isEmpty() || '(' != stack.pop()) {
                    return false;
                }
            } else if ('}' == ch) {
                if (stack.isEmpty() || '{' != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            boolean res = isBalanced(s);
            StdOut.println(s + " " + res);
        }
    }
}
