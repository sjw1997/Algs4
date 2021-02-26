package CHAPTER_1_5;

public class QuickUnionPathCompressionUF {
    public int[] parent;
    public int count;

    public QuickUnionPathCompressionUF(int n) {
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
        count--;
    }

    public int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (root != p) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
