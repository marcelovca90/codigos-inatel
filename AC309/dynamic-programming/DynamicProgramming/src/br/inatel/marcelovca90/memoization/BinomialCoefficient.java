package br.inatel.marcelovca90.memoization;

import java.util.Arrays;

public class BinomialCoefficient
{
    private static final int MAX = 20;
    private static final int NIL = -1;
    private static final int[][] MEMO = new int[MAX][MAX];

    public static int binom(int n, int k)
    {
        if (k == 0 || k == n)
        {
            return 1;
        }
        if (MEMO[n][k] == NIL)
        {
            MEMO[n][k] = binom(n - 1, k - 1) + binom(n - 1, k);
        }
        return MEMO[n][k];
    }

    public static void main(String[] args)
    {
        // initialize memoization matrix with NIL
        for (int i = 0; i < MAX; i++)
        {
            Arrays.fill(MEMO[i], NIL);
        }

        // print first MAX lines of Pascal's Triangle
        for (int n = 0; n <= MAX - 1; n++)
        {
            for (int k = 0; k <= n; k++)
            {
                System.out.print(binom(n, k) + " ");
            }
            System.out.println();
        }
    }
}
