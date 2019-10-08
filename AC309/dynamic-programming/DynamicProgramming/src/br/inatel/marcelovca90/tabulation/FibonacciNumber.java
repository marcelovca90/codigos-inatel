package br.inatel.marcelovca90.tabulation;

public class FibonacciNumber
{
    private static final int MAX = 20;
    private static final int[] TABU = new int[MAX];

    public static int fib_slow(int n)
    {
        if (n == 0 || n == 1)
        {
            return n;
        }
        return fib_slow(n - 2) + fib_slow(n - 1);
    }

    public static void initialize()
    {
        for (int i = 0; i < MAX; i++)
        {
            TABU[i] = fib_slow(i);
        }
    }

    public static int fib_fast(int n)
    {
        return TABU[n];
    }

    public static void main(String[] args)
    {
        // initialize tabulation array using slow method
        initialize();

        // print first MAX Fibonacci Numbers using fast method
        System.out.println("First " + MAX + " Fibonacci Numbers:");
        for (int i = 0; i < MAX; i++)
        {
            System.out.println("fib(" + i + ") = " + fib_fast(i));
        }
    }
}
