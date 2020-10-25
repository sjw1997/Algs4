package CHAPTER_3_5_EXERCISES;

import CHAPTER_3_4.LinearProbingHashST;

public class HashSET<Key> {

    private LinearProbingHashST<Key, Character> set;

    public HashSET() {
        set = new LinearProbingHashST<>();
    }

    public boolean contains(Key key) {
        return set.contains(key);
    }

    public void put(Key key) {
        if (!set.contains(key)) {
            set.put(key, 'e');
        }
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int size() {
        return set.size();
    }
}
