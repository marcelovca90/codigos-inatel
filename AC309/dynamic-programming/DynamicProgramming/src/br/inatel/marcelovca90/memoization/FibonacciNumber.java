package br.inatel.marcelovca90.memoization;

import java.util.Arrays;

public class FibonacciNumber
{
    private static final int MAX = 20;
    private static final int NIL = -1;
    private static final int[] MEMO = new int[MAX];

    public static int fib(int n)
    {
        if (n == 0 || n == 1)
        {
            return n;
        }
        if (MEMO[n] == NIL)
        {
            MEMO[n] = fib(n - 2) + fib(n - 1);
        }
        return MEMO[n];
    }

    public static void main(String[] args)
    {
        // initialize memoization array with NIL
        Arrays.fill(MEMO, NIL);

        // print first MAX Fibonacci Numbers
        System.out.println("First " + MAX + " Fibonacci Numbers:");
        for (int i = 0; i < MAX; i++)
        {
            System.out.println("fib(" + i + ") = " + fib(i));
        }
    }
}
