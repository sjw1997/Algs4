package CHAPTER_3_4;

import CHAPTER_1_3.Queue;

public class LinearProbingHashST<Key, Value> {

    private static final int INIT_SIZE = 16;

    private Key[] keys;
    private Value[] vals;
    private int size;
    private int M;

    public LinearProbingHashST() {
        this(INIT_SIZE);
    }

    public LinearProbingHashST(int capability) {
        keys = (Key[]) new Object[capability];
        vals = (Value[]) new Object[capability];
        M = capability;
        size = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capability) {
        LinearProbingHashST<Key, Value> st = new LinearProbingHashST<>(capability);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                st.put(keys[i], vals[i]);
            }
        }
        keys = st.keys;
        vals = st.vals;
        size = st.size;
        M = st.M;
    }

    public void put(Key key, Value val) {
        if (key == null || val == null) {
            throw new NullPointerException("calling put() with null");
        }
        if (size > M / 2) {
            resize(2 * M);
        }
        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        size++;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("calling get() with null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("calling delete() with null");
        }
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToReDo = keys[i];
            Value valToReDo = vals[i];
            keys[i] = null;
            vals[i] = null;
            size--;
            put(keyToReDo, valToReDo);
            i = (i + 1) % M;
        }
        size--;
        if (size > 0 && size == M / 8) {
            resize(M / 2);
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }
}
