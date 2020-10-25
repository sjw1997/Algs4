package CHAPTER_1_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

public class ClientOfLinkedList {

    public static void remove(Node root, String key) {
        Node sentinel = new Node<>();
        sentinel.next = root;
        Node prev = sentinel, current = root;
        while (current != null) {
            if (current.item.equals(key)) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    public static int max(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.item, max(root.next));
    }

    public static void main(String[] args) {
        Node<Integer> root = null;
        StdOut.println(max(root));
    }
}
