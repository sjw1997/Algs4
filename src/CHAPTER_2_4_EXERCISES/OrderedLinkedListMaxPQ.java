package CHAPTER_2_4_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class OrderedLinkedListMaxPQ<Key extends Comparable<Key>> {

    private class LinkedList {
        Key val;
        LinkedList pre;
        LinkedList next;

        public LinkedList() {
            pre = this;
            next = this;
        }
        public LinkedList(Key key) {
            val = key;
        }
    }

    private LinkedList pq;
    private int N;

    public OrderedLinkedListMaxPQ() {
        pq = new LinkedList();
        N = 0;
    }

    public void insert(Key k) {
        LinkedList p = new LinkedList(k);
        LinkedList last = pq.pre;
        last.next = p;
        p.pre = last;
        p.next = pq;
        pq.pre = p;
        N++;

        Key v = p.val;
        p = p.pre;
        while (p != pq && less(v, p.val)) {
            p.next.val = p.val;
            p = p.pre;
        }
        p.next.val = v;
    }

    public Key delMax() {
        if (N == 0) {
            throw new UnsupportedOperationException("No items");
        }
        LinkedList last = pq.pre;
        last.pre.next = pq;
        pq.pre = last.pre;
        last.pre = null;
        last.next = null;
        N--;
        return last.val;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        OrderedLinkedListMaxPQ<String> pq = new OrderedLinkedListMaxPQ<>();
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}
