package CHAPTER_2_4_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public OrderedArrayMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
        N = 0;
    }

    public void insert(Key k) {
        pq[N++] = k;
        int j = N - 1;
        for (; j > 0 && less(k, pq[j - 1]); j--) {
            pq[j] = pq[j - 1];
        }
        pq[j] = k;
    }

    public Key delMax() {
        return pq[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ<>(10);
        pq.insert("this");
        pq.insert("hello");
        pq.insert("world");
        pq.insert("bye");
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}
