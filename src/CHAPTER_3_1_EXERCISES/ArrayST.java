package CHAPTER_3_1_EXERCISES;

import CHAPTER_1_3.Queue;
import edu.princeton.cs.algs4.StdOut;

public class ArrayST<Key extends Comparable<Key>, Value> {

    private static final int INIT_SIZE = 8;

    private Key[] keys;
    private Value[] values;
    private int N;

    public ArrayST() {
        keys = (Key[]) new Comparable[INIT_SIZE];
        values = (Value[]) new Object[INIT_SIZE];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException("Both key and value can not be null");
        }
        if (N == keys.length) {
            resize(2 * N);
        }
        delete(key);
        keys[N] = key;
        values[N] = value;
        N++;
    }

    private void resize(int maxN) {
        Key[] newKeys = (Key[]) new Comparable[maxN];
        Value[] newValues = (Value[]) new Object[maxN];
        for (int i = 0; i < N; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                keys[i] = keys[N - 1];
                values[i] = values[N - 1];
                keys[N - 1] = null;
                values[N - 1] = null;
                N--;
                if (N > 0 && N == keys.length / 4) {
                    resize(keys.length / 2);
                }
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<>();
        st.put("this", 0);
        st.put("is", 1);
        st.put("a", 2);
        st.put("test", 3);
        st.delete("is");
        st.delete("test");
        for (String key : st.keys()) {
            StdOut.println(key + " " + st.get(key));
        }
    }
}
