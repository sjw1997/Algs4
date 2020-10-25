package CHAPTER_3_1_EXERCISES;

import CHAPTER_1_3.Queue;
import edu.princeton.cs.algs4.StdOut;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value val;
        Node next;
    }

    private Node sentinel;
    private int N = 0;

    public OrderedSequentialSearchST() {
        sentinel = new Node();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException("Both of key and value can not be null");
        }
        Node prev = sentinel, curr = prev.next;
        while (curr != null && curr.key.compareTo(key) < 0) {
            prev = curr;
            curr = prev.next;
        }
        if (curr != null && curr.key.equals(key)) {
            curr.val = value;
        } else {
            Node temp = new Node();
            temp.key = key;
            temp.val = value;
            temp.next = curr;
            prev.next = temp;
            N++;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        Node p = sentinel.next;
        while (p != null) {
            int cmp = p.key.compareTo(key);
            if (cmp == 0) {
                return p.val;
            } else if (cmp > 0) {
                break;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        Node prev = sentinel, curr = prev.next;
        while (curr != null) {
            int cmp = curr.key.compareTo(key);
            if (cmp == 0) {
                prev.next = curr.next;
                N--;
                return;
            } else if (cmp > 0) {
                return;
            } else {
                prev = curr;
                curr = prev.next;
            }
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        Node p = sentinel.next;
        while (p != null) {
            queue.enqueue(p.key);
            p = p.next;
        }
        return queue;
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST<Integer, String> st = new OrderedSequentialSearchST<>();
        st.put(3, "test");
        st.put(1, "is");
        st.put(0, "this");
        st.put(2, "a");
        st.put(0, "change");
        st.delete(2);

        for (Integer key : st.keys()) {
            StdOut.println(key + " " + st.get(key));
        }
    }
}
