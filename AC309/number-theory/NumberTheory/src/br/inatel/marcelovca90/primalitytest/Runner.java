package br.inatel.marcelovca90.primalitytest;

import static br.inatel.marcelovca90.primalitytest.PrimalityTestUtils.isPrime_O_N;
import static br.inatel.marcelovca90.primalitytest.PrimalityTestUtils.isPrime_O_N_2;
import static br.inatel.marcelovca90.primalitytest.PrimalityTestUtils.isPrime_O_N_4;
import static br.inatel.marcelovca90.primalitytest.PrimalityTestUtils.isPrime_O_SQRT_N;

public class Runner
{
    public static void main(String[] args)
    {
        int bigPrime = 179424691;
        long start, end;
        boolean result;

        // time measurements for isPrime_O_N
        System.out.println("isPrime_O_N");
        start = System.nanoTime();
        result = isPrime_O_N(bigPrime);
        end = System.nanoTime();
        System.out.println(String.format("\tis %d prime ? %s (took %s ns)", bigPrime, result, end - start));

        // time measurements for isPrime_O_N_2
        System.out.println("isPrime_O_N_2");
        start = System.nanoTime();
        result = isPrime_O_N_2(bigPrime);
        end = System.nanoTime();
        System.out.println(String.format("\tis %d prime ? %s (took %s ns)", bigPrime, result, end - start));

        // time measurements for isPrime_O_N_4
        System.out.println("isPrime_O_N_4");
        start = System.nanoTime();
        result = isPrime_O_N_4(bigPrime);
        end = System.nanoTime();
        System.out.println(String.format("\tis %d prime ? %s (took %s ns)", bigPrime, result, end - start));

        // time measurements for isPrime_O_SQRT_N
        System.out.println("isPrime_O_SQRT_N");
        start = System.nanoTime();
        result = isPrime_O_SQRT_N(bigPrime);
        end = System.nanoTime();
        System.out.println(String.format("\tis %d prime ? %s (took %s ns)", bigPrime, result, end - start));
    }
}
