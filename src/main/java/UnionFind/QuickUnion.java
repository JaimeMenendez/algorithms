package UnionFind;

/**
 * Implements Quick Union Algorithm.
 * The structure use a collection of trees represent by an integer array id[] of size n where id[n]
 * is the parent node of n. If id[n] = n then n is a root node.
 * Using this structure two nodes p and q are connected if root(p) = root(q).
 * <pre>
 |--------------|-------------|
 | Method       |  Complexity |
 |--------------|-------------|
 | initialize   |    O(n)     |
 |--------------|-------------|
 | union        |    O(n)     |
 |--------------|-------------|
 | connected    |    O(n)     |
 |--------------|-------------|
 *</pre>
 */
public class QuickUnion implements UF{
    private final int[] id;

    public QuickUnion(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Find the root node of p.
     * @param p Node p
     * @return The root of the node.
     */
    private int root(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
