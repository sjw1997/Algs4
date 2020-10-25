package CHAPTER_1_3;

public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public  FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String s) {
        a[N++] = s;
    }

    public String pop() {
        return a[--N];
    }
}
