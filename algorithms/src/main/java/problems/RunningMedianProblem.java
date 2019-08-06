package problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class RunningMedianProblem
{
    private PriorityQueue<Integer> lowers = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));
    private PriorityQueue<Integer>highers = new PriorityQueue<>();
    private double[] medians;

    public RunningMedianProblem(int capacity)
    {
        this.medians = new double[capacity];
    }

    public double[] getMedians(int[] array)
    {
        IntStream.range(0, array.length).forEach(index -> {
            int number = array[index];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[index] = getMedian(lowers, highers);
        });
        return medians;
    }

    private void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
    {
        if (lowers.isEmpty() || number < lowers.peek())
        {
            lowers.add(number);
        }
        else
        {
            highers.add(number);
        }
    }

    private void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
    {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() - smallerHeap.size() >= 2)
        {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
    {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size())
        {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        }
        return biggerHeap.peek();
    }

    public static void main(String[] args)
    {
        final RunningMedianProblem runningMedianProblem = new RunningMedianProblem(5);
        double[] medians = runningMedianProblem.getMedians(new int[] {5, 1, 4, 2, 3});
        Arrays.stream(medians).forEach(System.out::println);
    }
}
