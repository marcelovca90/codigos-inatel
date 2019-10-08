package br.inatel.marcelovca90.exponentiation;

public class ExponentiationUtils
{
    // calculates b^e using trivial approach
    public static int power_trivial(int b, int e)
    {
        int ans = b;
        for (int i = 1; i < e; i++)
            ans *= b;
        return ans;
    }

    // calculates b^e using fast power by squaring approach
    public static int power_by_squaring(int b, int e)
    {
        if (e < 0)
            return power_by_squaring(1 / b, -e);
        if (e == 0)
            return 1;
        if (e == 1)
            return b;
        if ((e % 2) == 0)
            return power_by_squaring(b * b, e / 2);
        if ((e % 2) != 0)
            return b * power_by_squaring(b * b, (e - 1) / 2);

        // never used
        return Integer.MIN_VALUE;
    }
}
