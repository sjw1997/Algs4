package CHAPTER_3_5_EXERCISES;

import CHAPTER_1_3.Queue;

public class HashSTint<Value> {

    private static final int INIT_SIZE = 100;
    private static final int NULL = Integer.MAX_VALUE;

    private int[] keys;
    private Value[] vals;
    private int size;
    private int M;

    public HashSTint() {
        this(INIT_SIZE);
    }

    public HashSTint(int cap) {
        keys = new int[cap];
        vals = (Value[]) new Object[cap];
        size = 0;
        M = cap;
        for (int i = 0; i < cap; i++) {
            keys[i] = NULL;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(int key) {
        return (key & 0x7fffffff) % keys.length;
    }

    private void resize(int cap) {
        HashSTint<Value> st = new HashSTint<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != NULL) {
                st.put(keys[i], vals[i]);
            }
        }
        keys = st.keys;
        vals = st.vals;
        size = st.size;
        M = st.M;
    }

    public void put(int key, Value val) {
        if (key == NULL || val == null) {
            throw new NullPointerException("calling put() with null");
        }
        if (size > M / 2) {
            resize(M * 2);
        }
        int i = hash(key);
        for (; keys[i] != NULL; i = (i + 1) % M) {
            if (keys[i] == key) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        size++;
    }

    public Value get(int key) {
        if (key == NULL) {
            throw new IllegalArgumentException("calling get() with illegal argument");
        }
        int i = hash(key);
        for (; keys[i] != NULL; i = (i + 1) % M) {
            if (keys[i] == key) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(int key) {
        return get(key) != null;
    }

    public void delete(int key) {
        if (key == NULL) {
            throw new IllegalArgumentException("calling delete() with illegal argument");
        }
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (keys[i] != key) {
            i = (i + 1) % M;
        }
        keys[i] = NULL;
        vals[i] = null;
        size--;
        i = (i + 1) % M;
        while (keys[i] != NULL) {
            int keyToDo = keys[i];
            Value valToDo = vals[i];
            keys[i] = NULL;
            vals[i] = null;
            size--;
            put(keyToDo, valToDo);
            i = (i + 1) % M;
        }
        if (size > 0 && size == M / 8) {
            resize(M / 2);
        }
    }

    public Iterable<Integer> keys() {
        Queue<Integer> queue = new Queue<>();
        for (int key : keys) {
            if (key != NULL) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
}
