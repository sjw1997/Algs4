package CHAPTER_2_4_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public UnorderedArrayMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
        N = 0;
    }

    public void insert(Key k) {
        pq[N++] = k;
    }

    public Key delMax() {
        if (N == 0) {
            throw new UnsupportedOperationException("No items!");
        }
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(pq[max], pq[i])) {
                max = i;
            }
        }
        exch(max, N - 1);
        N--;
        return pq[N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}
