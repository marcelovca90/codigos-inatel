package br.inatel.marcelovca90.primalitytest;

public class PrimalityTestUtils
{
    // O(N)
    public static boolean isPrime_O_N(int n)
    {
        if (n == 2)
            return true;
        for (int i = 2; i < n; i++)
            if ((n % i) == 0)
                return false;
        return true;
    }

    // O(N/2)
    public static boolean isPrime_O_N_2(int n)
    {
        if (n == 2)
            return true;
        if ((n % 2) == 0)
            return false;
        for (int i = 3; i < n; i += 2)
            if ((n % i) == 0)
                return false;
        return true;
    }

    // O(N/4)
    public static boolean isPrime_O_N_4(int n)
    {
        if (n == 2)
            return true;
        if ((n % 2) == 0)
            return false;
        for (int i = 3; i < n / 2; i += 2)
            if ((n % i) == 0)
                return false;
        return true;
    }

    // O(sqrt(N))
    public static boolean isPrime_O_SQRT_N(int n)
    {
        if (n == 2)
            return true;
        if ((n % 2) == 0)
            return false;
        double upper_bound = Math.sqrt(n);
        for (int i = 3; i <= upper_bound; i += 2)
            if ((n % i) == 0)
                return false;
        return true;
    }
}
