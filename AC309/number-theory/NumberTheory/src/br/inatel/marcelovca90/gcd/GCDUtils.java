package br.inatel.marcelovca90.gcd;

public class GCDUtils
{
    // greatest common divisor using trivial iterative approach
    public static int gcd_trivial(int a, int b)
    {
        int min = Math.min(a, b);
        int gcd = 0;
        for (int i = 1; i <= min; i++)
            if (((a % i) == 0) && ((b % i) == 0))
                gcd = i;
        return gcd;
    }

    // greatest common divisor using Euclides recursive approach
    public static int gcd_Euclides(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd_Euclides(b, a % b);
    }
}
