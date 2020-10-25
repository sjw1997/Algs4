package CHAPTER_1_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class ReverseLinkedList {

    public static Node reverseRecursive(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node second = root.next;
        Node rest = reverseRecursive(root.next);
        root.next = null;
        second.next = root;
        return rest;
    }

    public static Node reverse(Node root) {
        Node first = root, reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("this");
        root.next = new Node<>("is");
        root.next.next = new Node("a");
        root.next.next.next = new Node("test");

        root = reverseRecursive(root);
        Node p = root;
        while (p != null) {
            StdOut.print(p.item + " ");
            p = p.next;
        }
        StdOut.println();

        p = reverse(root);
        while (p != null) {
            StdOut.print(p.item + " ");
            p = p.next;
        }
    }
}
