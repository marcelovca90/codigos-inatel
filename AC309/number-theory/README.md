# number-theory
 Java implementation of some Number Theory algorithms.

- Primality Test

| Complexity | Primality test execution time (ns) |
|:----------:|:----------------------------------:|
| O(N)       | 532.971.143                        |
| O(N/2)     | 285.176.495                        |
| O(N/4)     | 130.515.976                        |
| O(sqrt(N)) | 407.564                            |

- Prime Numbers Generation

| Approach                            | Time to generate primes up to 10^6 (ms) |
|:-----------------------------------:|:---------------------------------------:|
| Trivial + O(N) Primality Test       | 106.107                                 |
| Trivial + O(N/2) Primality Test     | 54.053                                  |
| Trivial + O(N/4) Primality Test     | 27.882                                  |
| Trivial + O(sqrt(N)) Primality Test | 187                                     |
| Sieve of Eratosthenes               | 44                                      |

- Greatest Common Divisor (GCD)

| Approach              | Time to calculate GCD(234567800,876543200) (ns) |
|:---------------------:|:-----------------------------------------------:|
| Trivial (iterative)   | 660.103.401                                     |
| Euclides' (recursive) | 5.797                                           |

- Fast Exponentiation

| Approach                   | Time to calculate 2^30 (ns) |
|:--------------------------:|:---------------------------:|
| Trivial (iterative)        | 478.354                     |
| Exponentiation by Squaring | 5.052                       |

Reference(s):
- [Primality Test - Wikipedia](https://en.wikipedia.org/wiki/Primality_test)
- [Sieve of Eratosthenes - Wikipedia](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
- [Euclidean algorithm - Wikipedia](https://en.wikipedia.org/wiki/Euclidean_algorithm)
- [Exponentiation by squaring - Wikipedia](https://en.wikipedia.org/wiki/Exponentiation_by_squaring)
