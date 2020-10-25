package CHAPTER_1_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {

    private class DoubleNode {
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }

    private DoubleNode sentinel;
    private int N;

    public DoublyLinkedList() {
        sentinel = new DoubleNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insertBegining(Item x) {
        DoubleNode temp = new DoubleNode();
        temp.item = x;
        temp.prev = sentinel;
        temp.next = sentinel.next;
        sentinel.next.prev = temp;
        sentinel.next = temp;
        N++;
    }

    public void insertEnd(Item x) {
        DoubleNode temp = new DoubleNode();
        temp.item = x;
        temp.next = sentinel;
        temp.prev = sentinel.prev;
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        N++;
    }

    public Item removeBegining() {
        if (isEmpty()) {
            throw new NoSuchElementException("No element in list");
        }
        DoubleNode first = sentinel.next;
        DoubleNode second = first.next;
        sentinel.next = first.next;
        second.prev = sentinel;
        return first.item;
    }

    public Item removeEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("No element in list");
        }
        DoubleNode firstLast = sentinel.prev;
        DoubleNode secondLast = firstLast.prev;
        sentinel.prev = secondLast;
        secondLast.next = sentinel;
        return firstLast.item;
    }

    public void insertAfterGivenNode(Item x, DoubleNode given) {
        DoubleNode afterGiven = given.next;
        DoubleNode temp = new DoubleNode();
        temp.item = x;
        temp.next = afterGiven;
        temp.prev = given;
        given.next = temp;
        afterGiven.prev = temp;
    }

    public void insertBeforeGivenNode(Item x, DoubleNode given) {
        DoubleNode beforeGiven = given.prev;
        DoubleNode temp = new DoubleNode();
        temp.item = x;
        temp.next = given;
        temp.prev = beforeGiven;
        given.prev = temp;
        beforeGiven.next = temp;
    }

    public void removeGivenNode(DoubleNode given) {
        DoubleNode beforeGiven = given.prev;
        DoubleNode afterGiven = given.next;
        beforeGiven.next = afterGiven;
        afterGiven.prev = beforeGiven;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Item> {
        private DoubleNode p = sentinel.next;

        public boolean hasNext() {
            return p != sentinel;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No element");
            }
            Item res = p.item;
            p = p.next;
            return res;
        }

        public void remove() {}
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertEnd("is");
        list.insertBegining("this");
        list.insertEnd("a");
        list.insertBegining("a");
        list.removeEnd();
        list.removeBegining();
        list.insertEnd("test");

        for (String s : list) {
            StdOut.print(s + " ");
        }
    }
}
