package br.inatel.marcelovca90;

import java.util.Arrays;
import java.util.Random;

public class Runner
{
    private static final Random RNG = new Random(0);

    private static int max;

    public static void main(String[] args)
    {
        int[] numbers;
        long start, end;

        for (max = 10; max <= 1E8; max *= 10)
        {
            System.out.println(max + " numbers");

            numbers = generateRandomNumbers();

            start = System.currentTimeMillis();
            countingSort(numbers.clone());
            end = System.currentTimeMillis();
            System.out.println("Counting Sort took " + (end - start) + "ms");

            start = System.currentTimeMillis();
            Arrays.sort(numbers.clone());
            end = System.currentTimeMillis();
            System.out.println("Arrays.sort took " + (end - start) + "ms\n");
        }
    }

    private static int[] generateRandomNumbers()
    {
        int[] arr = new int[max];
        for (int i = 0; i < max; i++)
            arr[i] = RNG.nextInt(max);
        return arr;
    }

    private static int[] countingSort(int[] arr)
    {
        // array to store indices
        int[] index = new int[max];

        // count each element
        for (int i = 0; i < max; i++)
            index[arr[i]]++;

        // cumulative sum
        for (int i = 1; i < max; i++)
            index[i] += index[i - 1];

        // place the numbers and decrement positions
        int[] places = new int[max];
        for (int i = 0; i < max; i++)
        {
            places[index[arr[i]] - 1] = arr[i];
            index[arr[i]]--;
        }

        return places;
    }
}
