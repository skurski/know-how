package know.how.codingtasks;

import java.util.Arrays;

/**
 * Print fibonacci series up to N number.
 *
 * Fibonacci series:
 * F0 = 0
 * F1 = 1
 * Fn = Fn-1 + Fn-2
 */
public class Fibonacci {

    /**
     * Get single value for n-element of fibonacci series.
     *
     * @param n index of element
     * @return  value of element
     */
    public static int getValue(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return getValue(n-1) + getValue(n-2);
    }

    /**
     * Get single value for n-element of fibonacci series.
     * Optimize algorithm with memoization.
     *
     * @param n index of element
     * @param cache array that stores already calculated elements
     * @return  int[] with fibonacci numbers
     */
    public static int getValueWithMemoization(int n, int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        cache[n] = getValueWithMemoization(n-1, cache) + getValueWithMemoization(n-2, cache);
        return cache[n];
    }

    /**
     * Store to array fibonacci series up to n-element.
     *
     * @param n index of element
     * @return  array of int with fibonacci series values
     */
    public static int[] getSeriesUpToNumberWithRecursion(int n) {
        int[] fibonacci = new int[n+1];

        for (int i=0; i<=n; i++) {
            fibonacci[i] = getValue(i);
        }

        return fibonacci;
    }

    /**
     * Store to array fibonacci series up to n-element.
     * Optimize with memoization.
     *
     * @param n index of element
     * @return  array of int with fibonacci series values
     */
    public static int[] getSeriesUpToNumberWithMemoization(int n) {
        int[] fibonacci = new int[n+1];

        for (int i=0; i<=n; i++) {
            fibonacci[i] = getValueWithMemoization(i, fibonacci);
        }

        return fibonacci;
    }

    /**
     * Put all fibonacci numbers in array up to N-element.
     * Definitely faster and better solution than recursion.
     *
     * @param n
     * @return
     */
    public static int[] getSeriesUpToNumberWithoutRecursion(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0,1};
        }
        if (n == 2) {
            return new int[]{0,1,1};
        }

        int[] fibonacci = new int[n+1];  // add F0=0
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        int fprev = fibonacci[2];
        int fprevprev = fibonacci[1];
        for (int i=3; i<=n; i++) {
            fibonacci[i] = fprev + fprevprev;
            fprevprev = fprev;
            fprev = fibonacci[i];
        }

        return fibonacci;
    }

    public static void main(String[] args) {
        int n = 25;

        /** Fibonacci with Recursion */
        long start = System.nanoTime();
        int[] fibWithRecursion = Fibonacci.getSeriesUpToNumberWithRecursion(n);
        long time = System.nanoTime() - start;
        System.out.println("Fibonacci with recursion, time: " + time + ", series: " + Arrays.toString(fibWithRecursion));

        /** Fibonacci with Recursion and Memoization */
        start = System.nanoTime();
        int[] fibWithMemoization = Fibonacci.getSeriesUpToNumberWithMemoization(n);
        time = System.nanoTime() - start;
        System.out.println("Fibonacci with recursion and memoization, time: " + time + ", series: " + Arrays.toString(fibWithMemoization));

        /** Fibonacci without Recursion, using loop */
        start = System.nanoTime();
        int[] fib = Fibonacci.getSeriesUpToNumberWithoutRecursion(n);
        time = System.nanoTime() - start;
        System.out.println("Fibonacci without recursion, using loop, time: " + time + ", series: " + Arrays.toString(fib));
    }
}
