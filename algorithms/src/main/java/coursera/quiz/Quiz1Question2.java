package coursera.quiz;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Link to the quiz :
 * https://www.coursera.org/learn/algorithms-part1/quiz/SCxqJ/interview-questions-union-find-ungraded
 */
public class Quiz1Question2
{
    private int[][] id;
    private int[] sz; // to keep the size of the trees

    public Quiz1Question2(int size)
    {
        id = new int[size][2];
        sz = new int[size];
        for (int i = 0; i < size; i++)
        {
            id[i][0] = i;
            id[i][1] = i;
        }
    }

    public static void main(String[] args)
    {
        Quiz1Question2 weightedUnion = new Quiz1Question2(10);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, weightedUnion.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, weightedUnion.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, weightedUnion.isConnected(2, 3));
        weightedUnion.union(8, 7);
        weightedUnion.union(1, 7);
        weightedUnion.union(2, 3);
        System.out.printf("%d connected to %d ? %s%n", 8, 9, weightedUnion.isConnected(8, 9));
        System.out.printf("%d connected to %d ? %s%n", 1, 9, weightedUnion.isConnected(1, 9));
        System.out.printf("%d connected to %d ? %s%n", 2, 3, weightedUnion.isConnected(2, 3));
        weightedUnion.union(8, 3);
        System.out.printf("Max element : %d%n", weightedUnion.find(1));
        System.out.printf("Max element : %d%n", weightedUnion.find(0));
        weightedUnion.printArray();
    }

    // set p's root to q's root iff size of p is larger than q else do the opp.
    private void union(int p, int q)
    {
        if (p >= id.length || q >= id.length)
        {
            throw new IllegalArgumentException(
                    String.format("Numbers %d, %d are out of range (0 - %d)", p, q, id.length - 1));
        }
        // save the initial roots
        int i = root(p);
        int j = root(q);
        if (i == j) return; // no need , already connected
        if (sz[i] < sz[j]) // check the size of the roots
        {
            // change the roots of the smaller tree
            id[i][0] = j;
            // store the curr max at the root
            id[j][1] = Math.max(id[j][1], Math.max(p, q));
            // increase the size of the bigger tree
            sz[j] += sz[i];
        }
        else
        {
            // change the roots of the smaller tree
            id[j][0] = i;
            // store the curr max at the root
            id[i][1] = Math.max(id[i][1], Math.max(p, q));
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

    /**
     * Returns the largest element in the connected component containing i.
     * @param i - the element to find
     * @return the largest element in the component containing i
     */
    private int find(int i)
    {
        return id[root(i)][1];

    }

    private int root(int p)
    {
        // root is where index and value is the same.
        while (p != id[p][0])
        {
            id[p] = id[id[p][0]]; // point a node to its root's root (grandfather)- path compression
            p = id[p][0];
        }
        return p;
    }

    /**
     * Prints the array with it's indexes on the top and values inside a rectangular box.
     *   0 1 2 3 4 5 6 7 8 9 10
     *  |1|1|1|1|1|1|1|1|1|1|1|
     */
    private void printArray()
    {
        IntStream.range(0, id.length).forEach(idx -> System.out.printf(" %d ", idx));
        System.out.print("\n|");
        Arrays.stream(id).forEach(value -> System.out.printf("%s ", value[0]+"|"));
        System.out.println();
        System.out.print("|");
        Arrays.stream(id).forEach(value -> System.out.printf("%s ", value[1]+"|"));
    }
}
