package coursera;

public class WeightedUnionWithPathCompression
{
    private int[] id;
    private int[] sz; // to keep the size of the trees

    public WeightedUnionWithPathCompression(int size)
    {
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++)
        {
            id[i] = i;
        }
    }

    public static void main(String[] args)
    {
        WeightedUnionWithPathCompression weightedUnion = new WeightedUnionWithPathCompression(10);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, weightedUnion.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, weightedUnion.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, weightedUnion.isConnected(2, 3));
        weightedUnion.union(8, 9);
        weightedUnion.union(1, 9);
        weightedUnion.union(2, 3);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, weightedUnion.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, weightedUnion.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, weightedUnion.isConnected(2, 3));
    }

    // set p's root to q's root iff size of p is larger than q else do the opp.
    private void union(int p, int q)
    {
        // save the initial roots
        int i = root(p);
        int j = root(q);
        if (i == j) return; // no need , already connected
        if (sz[i] < sz[j]) // check the size of the roots
        {
            // change the roots of the smaller tree
            id[i] = j;
            // increase the size of the bigger tree
            sz[j] += sz[i];
        }
        else
        {
            // change the roots of the smaller tree
            id[j] = i;
            // increase the size of the bigger tree
            sz[i] += sz[j];
        }
    }

    /**
     * This method should treat the connection as an equivalence relation.
     * That is if P is connected to q and q is further connected to r then
     * P is also connected to r.
     *
     * @param p
     * @param q
     * @return
     */
    private boolean isConnected(int p, int q)
    {
        return root(p) == root(q);
    }

    private int root(int p)
    {
        // root is where index and value is the same.
        while (p != id[p])
        {
            id[p] = id[id[p]]; // point a node to its root's root (grandfather)- path compression
            p = id[p];
        }
        return p;
    }

}