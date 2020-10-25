package CHAPTER_2_4;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;               // heap-ordered complete binary tree
    private int N = 0;              // in pq[1..N] with pq[0] unused.

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    public MaxPQ(Key[] keys) {
        int n = keys.length;
        pq = (Key[]) new Comparable[N + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k > 0; k--) {
            sink(k);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key k) {
        pq[++N] = k;
        swim(N);
    }

    public Key delMax() {
        Key res = pq[1];
        exch(1, N);
        pq[N--] = null;
        sink(1);
        return res;
    }

    private boolean less(int v, int w) {
        return pq[v].compareTo(pq[w]) < 0;
    }

    private void exch(int v, int w) {
        Key t = pq[v];
        pq[v] = pq[w];
        pq[w] = t;
    }

    private void swim(int k) {
        while (k / 2 > 0 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

}
