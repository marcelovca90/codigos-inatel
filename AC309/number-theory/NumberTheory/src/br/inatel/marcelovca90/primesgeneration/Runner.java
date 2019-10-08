package br.inatel.marcelovca90.primesgeneration;

import static br.inatel.marcelovca90.primesgeneration.PrimesGenerationUtils.generatePrimesUpToN_SieveOfEratosthenes;
import static br.inatel.marcelovca90.primesgeneration.PrimesGenerationUtils.generatePrimesUpToN_trivial_O_N;
import static br.inatel.marcelovca90.primesgeneration.PrimesGenerationUtils.generatePrimesUpToN_trivial_O_N_2;
import static br.inatel.marcelovca90.primesgeneration.PrimesGenerationUtils.generatePrimesUpToN_trivial_O_N_4;
import static br.inatel.marcelovca90.primesgeneration.PrimesGenerationUtils.generatePrimesUpToN_trivial_O_SQRT_N;

import java.util.List;

public class Runner
{
    public static void main(String[] args)
    {
        long start, end;
        int max = 1000000;
        List<Integer> primes;

        // time measurements for trivial primes generation using O(N) primality test
        start = System.currentTimeMillis();
        primes = generatePrimesUpToN_trivial_O_N(max);
        end = System.currentTimeMillis();
        System.out.println(String.format("Primes generation using trivial approach and O(N) primality test took %s ms (%s numbers generated)", end - start, primes.size()));

        // time measurements for trivial primes generation using O(N/2) primality test
        start = System.currentTimeMillis();
        primes = generatePrimesUpToN_trivial_O_N_2(max);
        end = System.currentTimeMillis();
        System.out.println(String.format("Primes generation using trivial approach and O(N/2) primality test took %s ms (%s numbers generated)", end - start, primes.size()));

        // time measurements for trivial primes generation using O(N/4) primality test
        start = System.currentTimeMillis();
        primes = generatePrimesUpToN_trivial_O_N_4(max);
        end = System.currentTimeMillis();
        System.out.println(String.format("Primes generation using trivial approach and O(N/4) primality test took %s ms (%s numbers generated)", end - start, primes.size()));

        // time measurements for trivial primes generation using O(sqrt(N)) primality test
        start = System.currentTimeMillis();
        primes = generatePrimesUpToN_trivial_O_SQRT_N(max);
        end = System.currentTimeMillis();
        System.out.println(String.format("Primes generation using trivial approach and O(sqrt(N)) primality test took %s ms (%s numbers generated)", end - start, primes.size()));

        // time measurements for primes generation using Sieve of Eratosthenes
        start = System.currentTimeMillis();
        primes = generatePrimesUpToN_SieveOfEratosthenes(max);
        end = System.currentTimeMillis();
        System.out.println(String.format("Primes generation using Sieve of Eratosthenes took %s ms (%s numbers generated)", end - start, primes.size()));
    }
}
