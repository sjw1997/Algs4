package CHAPTER_3_1_EXERCISES;

import CHAPTER_3_1.SequentialSearchST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class STClient {
    public static void main(String[] args) {
        SequentialSearchST<Double, String> st = new SequentialSearchST<>();
        In in = new In("E:\\learning\\graduate\\Algs4\\Data\\GPA.txt");
        while (!in.isEmpty()) {
            String value = in.readString();
            double key = in.readDouble();
            st.put(key, value);
        }
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            StdOut.println(st.get(value));
        }

    }
}
