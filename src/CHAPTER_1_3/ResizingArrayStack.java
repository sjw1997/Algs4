package CHAPTER_1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];  // stack items
    private int N = 0;                          // number of items

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item x) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = x;
    }

    public Item pop() {
        Item res = a[--N];
        a[N] = null;
        if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
        return res;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator<Item> implements Iterator<Item> {
        private int i = N;

        public Item next() {
            if (!hasNext()) {
                throw new UnsupportedOperationException("No next one");
            }
            return (Item) a[--i];
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove(){}
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        stack.push("be");
        for (String s : stack) {
            StdOut.println(s);
        }
        while (!stack.isEmpty()) {
            StdOut.println(stack.pop());
        }
    }
}
