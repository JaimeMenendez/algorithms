package UnionFind;


/**
 * Defines an interface for union–find data structure to solve dynamic connectivity problem
 *
 */
public interface UF {

    /**
     * Connect the element p and q.
     * @param p Node p
     * @param q Node q
     */
    void union(int p, int q);


    /**
     * Return a boolean indicating if p and q are connected.
     * @param p Node p
     * @param q Node q
     * @return A boolean if Node p and Node q are connected.
     */
    boolean isConnected(int p, int q);
}
