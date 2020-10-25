package CHAPTER_1_3_EXERCISES;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {

    private String[] items;
    private int first;
    private int last;
    private int N;

    public ResizingArrayQueueOfStrings() {
        items = new String[2];
        first = 0;
        last = 0;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(String s) {
        items[last++] = s;
        N++;
        if (last == items.length) {
            last = 0;
        }
        if (N == items.length) {
            resize(2 * items.length);
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        String res = items[first];
        items[first] = null;
        N--;
        first++;
        if (first == items.length) {
            first = 0;
        }
        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
        return res;
    }

    private void resize(int max) {
        String[] newItems = new String[max];
        for (int i = 0; i < N; i++) {
            newItems[i] = items[(first + i) % items.length];
        }
        items = newItems;
        first = 0;
        last = N;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        q.enqueue("to");
        q.enqueue("be");
        StdOut.println(q.dequeue());
        q.enqueue("not");
        StdOut.println(q.dequeue());
    }

}
