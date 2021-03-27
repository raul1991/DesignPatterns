package problems.dcp;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Amazon.
 * <p>
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class StaircaseProblem {

    public int solve(int totalSteps) {
        if (totalSteps <= 0) return 0;
        if (totalSteps == 1) return 1;
        return solve(totalSteps - 1) + solve(totalSteps - 2);
    }

    public int solveWithCache(int totalSteps) {
        int[] cache = new int[totalSteps + 1];
        cache[0] = 0;
        cache[1] = 1;
        return solveWithCache(totalSteps, cache);
    }

    private int solveWithCache(int totalSteps, int[] cache) {
        if (totalSteps <= 0) return 0;
        if (cache[totalSteps] != 0) return cache[totalSteps];
        int result = solve(totalSteps);
        cache[totalSteps] = result;
        return result;
    }

    private int solveWithCacheIterative(int totalSteps) {
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i = 0; i < totalSteps; i++) {
            result += first + second;
            first = second;
            second = result;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new StaircaseProblem().solveWithCacheIterative(3));
    }
}
