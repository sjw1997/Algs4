package CHAPTER_3_2_EXERCISES;

import CHAPTER_1_3.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class NonrecursiveBST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
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

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("calls get() with null");
        }
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.val;
            } else if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null || val == null) {
            throw new NullPointerException("call put() with null");
        }
        if (root == null) {
            root = new Node(key, val,1);
            return;
        }
        Node x = root;
        Stack<Node> stack = new Stack<>();
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.val = val;
                return;
            } else if (cmp < 0) {
                stack.push(x);
                x = x.left;
            } else {
                stack.push(x);
                x = x.right;
            }
        }
        Node parent = stack.peek();
        int cmp = key.compareTo(parent.key);
        if (cmp > 0) {
            parent.right = new Node(key, val, 1);
        } else {
            parent.left = new Node(key, val, 1);
        }
        while (!stack.isEmpty()) {
            Node t = stack.pop();
            t.size = size(t.left) + size(t.right) + 1;
        }
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            x = x.left;
        }
        return parent.key;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            x = x.right;
        }
        return parent.key;
    }

    public Key floor(Key key) {
        if (isEmpty()) {
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node parent = null, x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.key;
            } else if  (cmp < 0) {
                x = x.left;
            } else {
                parent = x;
                x = x.right;
            }
        }
        return parent == null ? null : parent.key;
    }

    public Key ceiling(Key key) {
        if (isEmpty()) {
            throw new NoSuchElementException("calls ceiling() with symbol table");
        }
        Node parent = null, x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.key;
            } else if (cmp < 0) {
                parent = x;
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent == null ? null : parent.key;
    }

    public int rank(Key key) {
        if (key == null) {
            throw new NullPointerException("calls rank() with null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls rank() with empty symbol table");
        }
        Node x = root;
        int rank = 0;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return rank + size(x.left);
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                rank = rank + 1 + size(x.left);
                x = x.right;
            }
        }
        return rank;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("call select() with invalid argument");
        }
        Node x = root;
        while (x != null) {
            int t = size(x.left);
            if (t == k) {
                break;
            } else if (t > k) {
                x = x.left;
            } else {
                x = x.right;
                k = k - t - 1;
            }
        }
        return x.key;
    }

    public static void main(String[] args) {
        NonrecursiveBST<Integer, Integer> bst = new NonrecursiveBST<>();
        bst.put(3, 3);
        bst.put(7, 7);
        bst.put(4, 4);
        bst.put(6, 6);
        StdOut.println(bst.select(3));
    }
}
