package br.inatel.marcelovca90;

import java.util.Arrays;
import java.util.Random;

public class Main
{
    static int regularSum(int arr[], int index)
    {
        int ans = 0;
        for (int i = 0; i <= index; i++)
            ans += arr[i];
        return ans;
    }

    public static void main(String[] args)
    {
        for (int amount = 10; amount <= 1E9; amount *= 10)
        {
            int sqrt = (int) Math.sqrt(amount), min = -sqrt, max = +sqrt;
            int[] values = new Random(0).ints(amount, min, max).toArray();
            System.out.println(String.format("Array size: %,d elements", amount));
            System.out.println(String.format("First 10 elements: %s", Arrays.toString(Arrays.copyOfRange(values, 0, 9))));

            long startFOR, endFOR, startBIT, endBIT;

            startFOR = System.nanoTime();
            int sumUsingFOR = regularSum(values, values.length - 1);
            endFOR = System.nanoTime();
            System.out.println(String.format("Sum using FOR (%s) took %s ns", sumUsingFOR, (endFOR - startFOR)));

            BIT.constructBITree(values);
            startBIT = System.nanoTime();
            int sumUsingBIT = BIT.getSum(values.length - 1);
            endBIT = System.nanoTime();
            System.out.println(String.format("Sum using BIT (%s) took %s ns", sumUsingBIT, (endBIT - startBIT)));

            double ratio = ((double) (endFOR - startFOR) / (double) (endBIT - startBIT));
            System.out.println(String.format("BIT was %.2f times %s than FOR\n", ratio, (endBIT - startBIT) < (endFOR - startFOR) ? "faster" : "slower"));
        }
    }
}
