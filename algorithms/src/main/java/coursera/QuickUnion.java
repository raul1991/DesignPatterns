package coursera;

public class QuickUnion
{
    private int[] components;

    public QuickUnion(int size)
    {
        components = new int[size];
        for (int i = 0; i < size; i++)
        {
            components[i] = i;
        }
    }

    public static void main(String[] args)
    {
        QuickUnion quickUnion = new QuickUnion(10);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, quickUnion.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, quickUnion.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, quickUnion.isConnected(2, 3));
        quickUnion.union(8, 9);
        quickUnion.union(1, 9);
        quickUnion.union(2, 3);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, quickUnion.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, quickUnion.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, quickUnion.isConnected(2, 3));
    }

    // set p's root to q's root
    private void union(int p, int q)
    {
        // save the initial values
        int pid = root(p);
        int qid = root(q);
        components[pid] = qid;
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
        while (p != components[p])
        {
            p = components[p];
        }
        return p;
    }
}
