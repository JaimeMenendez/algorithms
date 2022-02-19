package UnionFind;

/**
 * Implements Weighted Quick Union Algorithm.
 * Improve the Quick Union Find Algorithm with trees almost flat using an array of sizes.
 * This structure use a collection of trees represent by an integer array id[] of size n where id[n]
 * is the parent node of n. If id[n] = n then n is a root node. It save the size of each tree using
 * an array of size n.
 * Using this structure two nodes p and q are connected if root(p) = root(q).
 * <pre>
 |--------------|-------------|
 | Method       |  Complexity |
 |--------------|-------------|
 | initialize   |    O(n)     |
 |--------------|-------------|
 | union        |   O(log n)  |
 |--------------|-------------|
 | connected    |   O(log n)  |
 |--------------|-------------|
 *</pre>
 */
public class WeightedQuickUnion implements UF {
    private final int[] id;
    private final int[] size;

    public WeightedQuickUnion(int n) {
        this.id = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Find the root node of p.
     * @param p Node p
     * @return The root of the node.
     */
    private int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]];   // Keeps the tree almost flat, improving connecting time
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
