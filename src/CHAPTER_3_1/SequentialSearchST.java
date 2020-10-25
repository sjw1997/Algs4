package CHAPTER_3_1;

import CHAPTER_1_3.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N;

    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key k, Value v, Node n) {
            key = k;
            val = v;
            next = n;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;       // search hit
            }
        }
        return null;                // search miss
    }

    public void put(Key key, Value val) {
        if (key == null || val == null) {
            throw new NullPointerException("calling put() with null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;        // search hit: update val
                return;
            }
        }
        first = new Node(key, val, first);  // search miss: add new node
        N++;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Bag<Key> b = new Bag<>();
        for (Node x = first; x != null; x = x.next) {
            b.add(x.key);
        }
        return b;
    }

    public void delete(Key key) {
        Node sentinel = new Node(null, null, first);
        Node prev = sentinel, current = sentinel.next;
        while (current != null) {
            if (key.equals(current.key)) {
                prev.next = current.next;
                N--;
                break;
            }
            prev = current;
            current = current.next;
        }
        first = sentinel.next;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("A", 0);
        st.delete("B");
        StdOut.println(st.isEmpty());
    }
}
