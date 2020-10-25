package CHAPTER_3_1;

import CHAPTER_1_3.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("Key can not be null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException("Both of key and value can not be null");
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }
        for (int j = N - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
            vals[j + 1] = vals[j];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("Key can not be null");
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            N--;
            keys[N] = null;
            vals[N] = null;
        }
    }

    // Returns the number of keys strictly smaller than a  given key.
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp < 0) {
                lo = mid + 1;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        int i = rank(lo), j = rank(hi);
        if (j < i) {
            throw new UnsupportedOperationException("hi can not be less than lo");
        }
        Queue<Key> queue = new Queue<>();
        while (i < j) {
            queue.enqueue(keys[i++]);
        }
        if (contains(hi)) {
            queue.enqueue(hi);
        }
        return queue;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new NullPointerException("Key can not be null");
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return true;
        }
        return false;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        if (isEmpty()) {
            throw new UnsupportedOperationException("ST is null");
        }
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        int i = rank(key);
        return i == N ? null : keys[i];
    }

    public Key floor(Key key) {
        if (isEmpty()) {
            throw new UnsupportedOperationException("ST is null");
        }
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        int i = rank(key);
        if (i < N && keys[i].equals(key)) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        int i = 0;
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            st.put(key, i++);
        }
        st.delete("Z");
        for (String key : st.keys()) {
            StdOut.println(key + ": " + st.get(key));
        }
    }
}
