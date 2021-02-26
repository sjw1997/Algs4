package CHAPTER_1_5;

public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int parentP = find(p), parentQ = find(q);
        if (parentP == parentQ) {
            return;
        }
        if (size[parentP] < size[parentQ]) {
            parent[parentP] = parentQ;
            size[parentQ] += size[parentP];
        } else {
            parent[parentQ] = parentP;
            size[parentP] += size[parentQ];
        }
        count--;
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
