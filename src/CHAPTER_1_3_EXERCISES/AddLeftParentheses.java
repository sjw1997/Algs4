package CHAPTER_1_3_EXERCISES;

import CHAPTER_1_3.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AddLeftParentheses {

    public static String addLeftParentheses(String s) {
        Stack<String> operators = new Stack<>();
        Stack<String> operands = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String t = "";
            while (i < s.length() && s.charAt(i) != ' ') {
                t += s.charAt(i++);
            }

            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                operators.push(t);
            } else if (t.equals(")")) {
                String op2 = operands.pop(), op1 = operands.pop();
                String operator = operators.pop();
                operands.push("( " + op1 + " " + operator + " " + op2 + " )");
            } else {
                operands.push(t);
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            StdOut.println(addLeftParentheses(s));
        }
    }
}
