package CHAPTER_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        first = new Node(item, first);
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("No item in stack");
        }
        Item res = first.item;
        first = first.next;
        N--;
        return res;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node p = first;
        public boolean hasNext() {
            return p != null;
        }
        public Item next() {
            if (!hasNext()) {
                throw new UnsupportedOperationException("No next one");
            }
            Item res = p.item;
            p = p.next;
            return res;
        }
        public void remove() {}
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
        StdOut.print("They are: ");
        for (String p : s) {
            StdOut.print(p + " ");
        }
    }

}
