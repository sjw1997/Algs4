package CHAPTER_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;   // or N == 0
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("No item in queue");
        }
        Item res = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return res;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
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
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + " left on queue)");
        StdOut.print("They are: ");
        for (String s : q) {
            StdOut.print(s + " ");
        }
    }
}
