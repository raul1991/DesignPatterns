package coursera;

public class QuickFind
{
    private int[] components;

    public QuickFind(int size)
    {
        components = new int[size];
        for (int i = 0; i < size; i++)
        {
            components[i] = i;
        }
    }

    public static void main(String[] args)
    {
        QuickFind quickFind = new QuickFind(10);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, quickFind.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, quickFind.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, quickFind.isConnected(2, 3));
        quickFind.union(8, 9);
        quickFind.union(1, 9);
        quickFind.union(2, 3);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, quickFind.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, quickFind.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, quickFind.isConnected(2, 3));
    }

    // set the value of pth index with qth index
    private void union(int p, int q)
    {
        // save the initial values
        int pid = components[p];
        int qid = components[q];
        // change value at pid to qid iff they are already not equal
        for (int i = 0; i < components.length; i++)
        {
            if (components[i] == pid) components[i] = qid;
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
        return components[p] == components[q];
    }
}
