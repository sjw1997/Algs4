package CHAPTER_1_5;

public class QuickUnionUF {
    private int[] parent;
    private int count;

    public QuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int parentP = find(p), parentQ = find(q);
        if (parentP == parentQ) {
            return;
        }
        parent[parentP] = parentQ;
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
