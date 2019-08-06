package problems;

import java.util.stream.IntStream;

public class Fibonacci
{
    private static int[] cache;
    public static void main(String[] args)
    {
        Fibonacci fib = new Fibonacci();
        final int limit = 10;
        cache = new int[limit];
        long start = System.nanoTime();
        IntStream.range(1, limit).forEach(value -> System.out.print(fib.print(value) + " "));
        long end = System.nanoTime();
        System.out.printf("Time take by 'print' - %d%n", end - start);
        start = System.nanoTime();
        IntStream.range(1, limit).forEach(value -> System.out.print(fib.memoizedPrint(value) + " "));
        end = System.nanoTime();
        System.out.printf("Time take by 'print' - %d%n", end - start);
    }

    private int print(int n)
    {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        return print(n - 1) + print(n - 2);
    }

    private int memoizedPrint(int n)
    {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        if (cache[n] != 0) return cache[n];
        cache[n] = print(n - 1) + print(n - 2);
        return cache[n];
    }
}
