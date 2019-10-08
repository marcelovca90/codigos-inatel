package br.inatel.marcelovca90.tabulation;

public class BinomialCoefficient
{
    private static final int MAX = 20;
    private static final int[][] TABU = new int[MAX][MAX];

    public static int binom_slow(int n, int k)
    {
        if (k == 0 || k == n)
        {
            return 1;
        }
        return binom_slow(n - 1, k - 1) + binom_slow(n - 1, k);
    }

    public static void initialize()
    {
        for (int n = 0; n <= MAX - 1; n++)
        {
            for (int k = 0; k <= n; k++)
            {
                TABU[n][k] = binom_slow(n, k);
            }
        }
    }

    public static int binom_fast(int n, int k)
    {
        return TABU[n][k];
    }

    public static void main(String[] args)
    {
        // initialize tabulation matrix using slow method
        initialize();

        // print first MAX lines of Pascal's Triangle using fast method
        for (int n = 0; n <= MAX - 1; n++)
        {
            for (int k = 0; k <= n; k++)
            {
                System.out.print(binom_fast(n, k) + " ");
            }
            System.out.println();
        }
    }
}
