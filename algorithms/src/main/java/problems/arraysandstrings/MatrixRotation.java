package problems.arraysandstrings;

/**
 * Problem name: Matrix Rotation
 * <p>
 * Statement: Given a 2D matrix, rotate it clockwise 90 degrees (in place)
 * <p>
 * Source: Arrays and Strings, Cracking the coding interview
 * <p>
 * Solution: We do this rotation layer wise, starting with the outer layer.
 *
 * For each layer do the following
 *
 * 1. Decrement the last element in each row (Left Bottom Right Top)
 * 2. Traverse each of the above sides and do the following
 *  2.1 Save the top element (so we can do it in the last otherwise we'll be stuck.
 *  2.2 Move the left side's element into the top side
 *  2.3 Move bottom to the right side
 *  2.4 Move the right to the bottom
 *  2,5 Move the top to the right side
 *
 *  Note: The role of the "last" is to accommodate the changes at each layer as at each layer the last element is
 *  at a different position and one less than the total length of that row.
 *  Also, the offset variable has been used to traverse all the items in a row.
 *
 *  The expression "last - offset" is to deal with the changing layer as last element at each layer is away by offset.
 *
 *    0_1_2
 * 0| 1 2 3
 * 1| 4 5 6
 * 2| 7 8 9
 *    0 1 2
 *
 *    0_1_2
 * 0| 7 4 1
 * 1| 8 5 2
 * 2| 9 6 3
 *    0 1 2
 */
public class MatrixRotation {

    public int[][] rotate(int[][] matrix, int m , int n)
    {
        if (matrix == null) throw new IllegalArgumentException("Input matrix can't be null");
        // check if this is a square matrix
        if (m != n) throw new IllegalArgumentException("Only square matrix can be rotated");
        for(int layer = 0; layer < n/2; layer++)
        {
            // the last element changes per layer
           int last = n - layer - 1; // 2
           for (int i = layer; i < last; i++)
           {
               int offset = i - layer; // 1
               // save the top element
               int top = matrix[layer][i]; // matrix[0][1] = 2
               // top <- left
               matrix[layer][i] = matrix[last - offset][layer]; // matrix[1,0]
               // left <- bottom
               matrix[last - offset][layer] = matrix[last][last - offset]; // matrix[2,1]
               // bottom <- right
               matrix[last][last - offset] = matrix[i][last]; // matrix[1,2]
               // right <- top
               matrix[i][last] = top; // matrix[0,1]
           }
        }
        return matrix;
    }

}
