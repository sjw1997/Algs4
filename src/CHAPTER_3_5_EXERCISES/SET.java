package CHAPTER_3_5_EXERCISES;

import edu.princeton.cs.algs4.ST;

public class SET<Key extends Comparable<Key>> {

    private ST<Key, Character> set;

    public SET() {
        set = new ST<>();
    }

    public boolean contains(Key key) {
        return set.contains(key);
    }

    public void put(Key key) {
        set.put(key, 'e');
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }
}
