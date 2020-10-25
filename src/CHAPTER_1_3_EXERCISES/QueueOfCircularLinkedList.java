package CHAPTER_1_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class QueueOfCircularLinkedList<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node last;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item x) {
        Node oldLast = last;
        last = new Node();
        last.item = x;
        if (isEmpty()) {
            last.next = last;
        } else {
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("No item in queue");
        }
        Node first = last.next;
        Item res = first.item;
        N--;
        if (isEmpty()) {
            last = null;
        } else {
            last.next = first.next;
            first.next = null;
        }
        return res;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("No item in queue");
        }
        return last.next.item;
    }

    public static void main(String[] args) {
        QueueOfCircularLinkedList<String> q = new QueueOfCircularLinkedList();
        q.enqueue("this");
        q.enqueue("is");
        q.enqueue("a");
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        q.enqueue("test");
        StdOut.println(q.dequeue());
    }
}
