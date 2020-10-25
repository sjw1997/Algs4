package CHAPTER_2_5;

import CHAPTER_2_3.Quick;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TwoCompoundWords {

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Quick.sort(a);
        Bag<String> res = new Bag<>();
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            while (j >= 0 && !a[i].startsWith(a[j])) {
                j--;
            }
            if (j >= 0) {
                String rest = a[i].substring(a[j].length());
                for (int k = 0; k < a.length; k++) {
                    if (a[k].equals(rest)) {
                        res.add(a[i]);
                        break;
                    }
                }
            }
        }
        for (String s : res) {
            StdOut.println(s);
        }
    }
}
