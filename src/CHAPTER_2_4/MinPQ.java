package CHAPTER_2_4;

public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    public void insert(Key k) {
        pq[++N] = k;
        swim(N);
    }

    public Key delMin() {
        Key res = pq[1];
        exch(1, N);
        pq[N--] = null;
        sink(1);
        return res;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isMinHeap() {
        int k = 1;
        while (k <= N / 2) {
            int j = 2 * k;
            if (j < N && greater(j, k) && greater(j + 1, k)) {
                k++;
            } else if (greater(j, k)) {
                k++;
            } else {
                return false;
            }
        }
        return true;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }
}
