package CHAPTER_3_4;

import CHAPTER_1_3.Queue;
import CHAPTER_3_1.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {

    private int M;
    private int size;
    private Node[] st;

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        size = 0;
        st = new Node[M];
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

    public void put(Key key, Value val) {
        if (key == null || val == null) {
            throw new NullPointerException("calling put() with null");
        }
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
        size++;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("calling get() with null");
        }
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return (Value) x.val;
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
        int i = hash(key);
        Node sentinel = new Node(null, null, st[i]);
        Node pred = sentinel, curr = sentinel.next;
        while (curr != null) {
            if (curr.key.equals(key)) {
                pred.next = curr.next;
                size--;
                break;
            }
            pred = curr;
            curr = curr.next;
        }
        st[i] = sentinel.next;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.enqueue((Key)x.key);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST();
        st.put("this", st.size());
        st.put("is", st.size());
        st.put("a", st.size());
        st.put("test", st.size());
        for (String key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
    }
}
