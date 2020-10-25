package CHAPTER_3_1_EXERCISES;

import CHAPTER_1_3.Queue;
import CHAPTER_2_2.Merge;

public class BinarySearchSTByItem<Key extends Comparable<Key>, Value> {

    private class Item implements Comparable<Item> {
        Key key;
        Value value;
        @Override
        public int compareTo(Item o) {
            return key.compareTo(o.key);
        }
    }

    private Item[] items;
    private int N;

    public BinarySearchSTByItem(Item[] p) {
        items = (Item[]) new Comparable[p.length];
        N = p.length;
        for (int i = 0; i < N; i++) {
            items[i] = p[i];
        }
        Merge.sort(items);
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = items[mid].key.compareTo(key);
            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private void resize(int capability) {
        Item[] itemsV = (Item[]) new Comparable[capability];
        for (int i = 0; i < N; i++) {
            itemsV[i] = items[i];
        }
        items = itemsV;
    }

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new NullPointerException("Both of key and value can not be null");
        }
        if (N == items.length) {
            resize(2 * N);
        }
        Item item = new Item();
        item.key = key;
        item.value = value;

        int i = rank(key);
        if (i < N && items[i].key.equals(key)) {
            items[i] = item;
            return;
        }
        for (int j = N - 1; j >= i; j--) {
            items[j + 1] = items[j];
        }
        items[i] = item;
        N++;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && items[i].key.equals(key)) {
            return items[i].value;
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("key can not be null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i < N && items[i].key.equals(key)) {
            for (int j = i; i < N - 1; j++) {
                items[j] = items[j + 1];
            }
            items[N - 1] = null;
            N--;
            if (N > 0 && N == items.length / 4) {
                resize(items.length / 2);
            }
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(items[i].key);
        }
        return queue;
    }
}
