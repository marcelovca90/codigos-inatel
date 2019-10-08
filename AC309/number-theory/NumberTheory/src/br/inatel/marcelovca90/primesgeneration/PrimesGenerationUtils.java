package br.inatel.marcelovca90.primesgeneration;

import java.util.ArrayList;
import java.util.List;

import br.inatel.marcelovca90.primalitytest.PrimalityTestUtils;

public class PrimesGenerationUtils
{
    // Trivial generation using O(N) primality test
    public static List<Integer> generatePrimesUpToN_trivial_O_N(int n)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (PrimalityTestUtils.isPrime_O_N(i))
                primes.add(i);
        return primes;
    }

    // Trivial generation using O(N/2) primality test
    public static List<Integer> generatePrimesUpToN_trivial_O_N_2(int n)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (PrimalityTestUtils.isPrime_O_N_2(i))
                primes.add(i);
        return primes;
    }

    // Trivial generation using O(N/4) primality test
    public static List<Integer> generatePrimesUpToN_trivial_O_N_4(int n)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (PrimalityTestUtils.isPrime_O_N_4(i))
                primes.add(i);
        return primes;
    }

    // Trivial generation using O(sqrt(N)) primality test
    public static List<Integer> generatePrimesUpToN_trivial_O_SQRT_N(int n)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (PrimalityTestUtils.isPrime_O_SQRT_N(i))
                primes.add(i);
        return primes;
    }

    // Generation using Sieve of Eratosthenes
    public static List<Integer> generatePrimesUpToN_SieveOfEratosthenes(int n)
    {
        List<Integer> primes = new ArrayList<>();

        int[] numbers = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            numbers[i] = i;

        boolean[] crossed = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++)
            crossed[i] = false;

        // base cases
        crossed[0] = true;
        crossed[1] = true;

        // sieve
        for (int i = 2; i <= n; i++)
        {
            if (!crossed[i])
                primes.add(numbers[i]);

            for (int j = numbers[i]; j <= n; j += numbers[i])
                crossed[j] = true;
        }
        return primes;
    }
}
