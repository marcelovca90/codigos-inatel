package br.inatel.marcelovca90.exponentiation;

import static br.inatel.marcelovca90.exponentiation.ExponentiationUtils.power_by_squaring;
import static br.inatel.marcelovca90.exponentiation.ExponentiationUtils.power_trivial;

public class Runner
{
    public static void main(String[] args)
    {
        long start, end;
        int b = 2, e = 30, ans;

        start = System.nanoTime();
        ans = power_trivial(b, e);
        end = System.nanoTime();
        System.out.println(String.format("Trivial approach took %s ns (ans = %d)", end - start, ans));

        start = System.nanoTime();
        ans = power_by_squaring(b, e);
        end = System.nanoTime();
        System.out.println(String.format("Power by squaring approach took %s ns (ans = %d)", end - start, ans));
    }
}
