package UnionFind;

/**
 * Implements Quick Find Algorithm.
 * The structure is implemented using an integer array id[] of size n where id[n] represents a label that
 * identifies connected nodes. In other words, if id[i] = id[j] means that i and j are connected.
 *
 * <pre>
 |--------------|-------------|
 | Method       |  Complexity |
 |--------------|-------------|
 | initialize   |    O(n)     |
 |--------------|-------------|
 | union        |    O(n)     |
 |--------------|-------------|
 | connected    |    O(1)     |
 |--------------|-------------|
 *</pre>
 */
public class QuickFind implements UF {
    private final int[] id;

    public QuickFind(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if (id[p] == id[q]) {
            return;
        }

        int qValue = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[p] == id[i]) {
                id[i] = id[p];
            }

            if (id[i] == qValue) {
                id[i] = id[p];
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}