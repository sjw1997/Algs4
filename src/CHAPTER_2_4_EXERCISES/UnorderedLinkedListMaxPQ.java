package CHAPTER_2_4_EXERCISES;


import edu.princeton.cs.algs4.StdOut;

public class UnorderedLinkedListMaxPQ<Key extends Comparable<Key>> {

    private class LinkedList {
        Key val;
        LinkedList next;
        LinkedList pre;

        public LinkedList() {
            val = null;
        }

        public LinkedList(Key k) {
            val = k;
        }
    }

    private LinkedList pq;
    private int N;

    public UnorderedLinkedListMaxPQ() {
        pq = new LinkedList();
        pq.next = pq;
        pq.pre = pq;
        N = 0;
    }

    public void insert(Key k) {
        LinkedList temp = new LinkedList(k);
        temp.next = pq.next;
        pq.next = temp;
        temp.pre = pq;
        temp.next.pre = temp;
        N++;
    }

    public Key delMax() {
        if (N == 0) {
            throw new UnsupportedOperationException("No items");
        }
        LinkedList p = pq.next;
        LinkedList max = pq.next;
        while (p != pq) {
            if (less(max.val, p.val)) {
                max = p;
            }
            p = p.next;
        }
        Key res = max.val;
        max.pre.next = max.next;
        max.next.pre = max.pre;
        N--;
        return res;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        UnorderedLinkedListMaxPQ<String> pq = new UnorderedLinkedListMaxPQ<>();
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}
