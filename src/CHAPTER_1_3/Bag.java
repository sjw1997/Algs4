package CHAPTER_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new UnsupportedOperationException("No next one");
            }
            Item res = current.item;
            current = current.next;
            return res;
        }

        public void remove() {}
    }

    public static void main(String[] args) {
        Bag<String> b = new Bag<>();
        while (!StdIn.isEmpty()) {
            b.add(StdIn.readString());
        }
        for (String s : b) {
            StdOut.println(s);
        }
    }
}
