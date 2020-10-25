package CHAPTER_2_4;

import edu.princeton.cs.algs4.StdOut;

public class IndexMinPQ<Key extends Comparable<Key>> {

    private int n;              // number of elements on PQ
    private int[] pq;           // binary heap using 1-based indexing
    private int[] qp;           // inverse: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;         // items with priorities

    public IndexMinPQ(int maxN) {
        n = 0;
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        keys = (Key[]) new Comparable[maxN + 1];
        for (int i = 1; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int k, Key val) {
        n++;
        pq[n] = k;
        qp[k] = n;
        keys[k] = val;
        swim(n);
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int delMin() {
        int min = pq[1];
        exch(1, n--);
        qp[min] = -1;
        keys[min] = null;
        sink(1);
        return min;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void changeKey(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, n--);
        keys[k] = null;
        qp[k] = -1;
        swim(index);
        sink(index);
    }

    public int size() {
        return n;
    }

    public int minIndex() {
        return pq[1];
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    public static void main(String[] args) {
        String[] strings = new String[]{"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
        IndexMinPQ<String> pq = new IndexMinPQ(strings.length);

        int i;
        for(i = 0; i < strings.length; ++i) {
            pq.insert(i, strings[i]);
        }

        while(!pq.isEmpty()) {
            i = pq.delMin();
            StdOut.println(i + " " + strings[i]);
        }

        StdOut.println();

        for(i = 0; i < strings.length; ++i) {
            pq.insert(i, strings[i]);
        }

        while (!pq.isEmpty()) {
            StdOut.println(strings[pq.delMin()]);
        }

    }
}
