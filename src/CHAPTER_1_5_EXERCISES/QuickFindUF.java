package CHAPTER_1_5_EXERCISES;

public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pRoot) {
                id[i] = qRoot;
            }
        }
        count--;
    }
}
