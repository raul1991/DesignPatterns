package problems;

public class StarPrintingProblems
{
    public static void main(String[] args)
    {
        new StarPrintingProblems().begin();
    }

    public void begin()
    {
        printPyramid(5);
        System.out.println("-----------------");
        printDiamond(5);
    }

    /**
     * Pyramid should look like as printed below
     *          *
     *         * *
     *        * * *
     */
    private void printPyramid(int rows)
    {
        int spaces = rows;
        for (int nofRows = 0; nofRows < rows; nofRows++, --spaces)
        {
            printSpaces(spaces);
            printCols(nofRows);
            System.out.println();
        }
    }

    private void printReversePyramid(int rows)
    {
        int spaces = 0;
        for (int nofRows = rows; nofRows > 0; nofRows--, ++spaces)
        {
            printSpaces(spaces);
            printCols(nofRows);
            System.out.println();
        }
    }

    private void printDiamond(int rows)
    {
       printPyramid(rows);
       printReversePyramid(rows);
    }

    /**
     *
     */
    private void printStairs(int rows)
    {

    }

    private void printSpaces(int spaces)
    {
        for (int i = spaces; i > 0; i--)
        {
            System.out.print(" ");
        }
    }

    private void printCols(int i)
    {
        for (int j = i; j > 0; j--)
        {
            System.out.print("* ");
        }
    }
}
