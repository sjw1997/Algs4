package CHAPTER_3_5;

import CHAPTER_1_3.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupIndex {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String sp = args[1];

        ST<String, Queue<String>> st = new ST<>();
        ST<String, Queue<String>> ts = new ST<>();

        while (!in.isEmpty()) {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            for (int i = 1; i < a.length; i++) {
                String val = a[i];
                if (!st.contains(key)) {
                    st.put(key, new Queue<>());
                }
                if (!ts.contains(val)) {
                    ts.put(val, new Queue<>());
                }
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            if (st.contains(query)) {
                for (String s : st.get(query)) {
                    StdOut.println(" " + s);
                }
            } else if (ts.contains(query)) {
                for (String s : ts.get(query)) {
                    StdOut.println(" " + s);
                }
            } else {
                StdOut.println("No such query");
            }
        }
    }
}
