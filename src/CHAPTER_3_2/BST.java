package CHAPTER_3_2;

import CHAPTER_1_3.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int size;          // nodes in subtree rooted here

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls with get() with null");
        }
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        if (key == null || val == null) {
            throw new IllegalArgumentException("calls with put() with null");
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls with max() with empty symbol table");
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    // the largest key in the BST less than or equal to key
    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls with floor(Key key) with null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls with floor(Key key) with empty symbol table");
        }
        return floor(root, key).key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t == null) {
            return x;
        }
        return t;
    }

    // the smallest key in the BST greater than or equal to key
    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls ceiling() with null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls ceiling() with empty symbol table");
        }
        return ceiling(root, key).key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceiling(x.right, key);
        }
        Node t = ceiling(x.left, key);
        return t == null ? x : t;
    }

    // returns the (k+1)st smallest key
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid");
        }
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t == k) {
            return x;
        }
        if (t < k) {
            return select(x.right, k - t - 1);
        }
        return select(x.left, k);
    }

    // returns the number of nodes that are strictly smaller than key
    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls rank() with null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls rank() with empty symbol table");
        }
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return size(x.left);
        }
        if (cmp < 0) {
            return size(x.left) + 1 + rank(x.right, key);
        }
        return rank(x.left, key);
    }

    // removes the smallest key and associated value from the symbol table
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls deleteMin() with empty symbol table");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // delete the largest key and associated value from the symbol table
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls with deleteMax() with empty symbol table");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // removes the specified key and associated value from the symbol table
    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("calls delete() with null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls delete() with empty symbol table");
        }
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    public void print() {
        print(root);
    }

    private void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.left);
        StdOut.println(x.key + " " + x.val);
        print(x.right);
    }

    public Iterable<Key> levelOrder() {
        Queue<Node> queue = new Queue<>();
        Queue<Key> res = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) {
                continue;
            }
            res.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return res;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return 0;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<>();
        int val = 0;
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            st.put(key, val++);
        }
        for (String key : st.levelOrder()) {
            StdOut.println(key + " " + st.get(key));
        }
    }
}
