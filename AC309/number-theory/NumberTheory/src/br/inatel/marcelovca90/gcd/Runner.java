package br.inatel.marcelovca90.gcd;

import static br.inatel.marcelovca90.gcd.GCDUtils.gcd_Euclides;
import static br.inatel.marcelovca90.gcd.GCDUtils.gcd_trivial;

public class Runner
{
    public static void main(String[] args)
    {
        long start, end;
        int a = 234567800, b = 876543200, gcd;

        start = System.nanoTime();
        gcd = gcd_trivial(a, b);
        end = System.nanoTime();
        System.out.println(String.format("Trivial approach took %s ns (GCD = %d)", end - start, gcd));

        start = System.nanoTime();
        gcd = gcd_Euclides(a, b);
        end = System.nanoTime();
        System.out.println(String.format("Euclides approach took %s ns (GCD = %d)", end - start, gcd));
    }
}
