package CHAPTER_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

public class Huffman {
    private static int R = 256;
    private static class Node implements Comparable<Node> {
        private int freq;
        private char ch;
        private final Node left, right;

        public Node(int freq, char ch, Node left, Node right) {
            this.freq = freq;
            this.ch = ch;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    public static void compress() {
        // Read input
        String s  = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        // Tabulate frequency counts.
        int[] freq = new int[R];
        for (char value : input) {
            freq[value]++;
        }

        // Build Huffman code trie
        Node root = buildTrie(freq);

        // Build code table
        String[] st = buildCode(root);

        // Print trie for decode
        writeTrie(root);

        // Print numbers of chars.
        BinaryStdOut.write(input.length);

        // Use Huffman code to encode input.
        for (char c : input) {
            String code = st[c];
            for (int j = 0; j < code.length(); j++) {
                BinaryStdOut.write(code.charAt(j) == '1');
            }
        }
        BinaryStdOut.close();
    }

    public static void expand() {
        Node root = readTrie();
        int N = BinaryStdIn.readInt();
        for (int i = 0; i < N; i++) {
            // Expand ith codeword
            Node x = root;
            while (!x.isLeaf()) {
                if (BinaryStdIn.readBoolean()) {
                    x = x.right;
                } else {
                    x = x.left;
                }
            }
            BinaryStdOut.write(x.ch);
        }
        BinaryStdOut.close();
    }

    // Make a lookup table from trie
    private static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    // Make a lookup table from trie (recursive).
    private static void buildCode(String[] st, Node root, String s) {
        if (root.isLeaf()) {
            st[root.ch] = s;
            return;
        }
        buildCode(st, root.left, s + "0");
        buildCode(st, root.right, s + "1");
    }

    private static Node buildTrie(int[] freq) {
        // Initialize priority queue with singleton trees.
        MinPQ<Node> pq = new MinPQ<>();
        for (char c = 0; c < R; c++) {
            pq.insert(new Node(freq[c], c, null, null));
        }
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node(left.freq + right.freq, '\0', left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    // Write bitstring-encodeed trie.
    private static void writeTrie(Node root) {
        if (root.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(root.ch);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(root.left);
        writeTrie(root.right);
    }

    private static Node readTrie() {
        if (BinaryStdIn.readBoolean()) {
            return new Node(0, BinaryStdIn.readChar(), null, null);
        }
        return new Node(0, '\0', readTrie(), readTrie());
    }
}
