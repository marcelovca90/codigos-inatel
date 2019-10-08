package br.inatel.marcelovca90;

public class BIT
{
    static int n;
    static int[] BITree;

    static void constructBITree(int arr[])
    {
        // Count length and allocate memory
        n = arr.length;
        BITree = new int[n + 1];

        // Initialize BITree[] as 0
        for (int i = 1; i <= n; i++)
            BITree[i] = 0;

        // Store the actual values in BITree[] using update()
        for (int i = 0; i < n; i++)
            updateBIT(i, arr[i]);
    }

    static void updateBIT(int index, int val)
    {
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n)
        {
            // Add 'val' to current node of BIT Tree
            BITree[index] += val;

            // Update index to that of parent in update
            index += index & (-index);
        }
    }

    static int getSum(int index)
    {
        int sum = 0; // Iniialize result

        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while (index > 0)
        {
            // Add current element of BITree to sum
            sum += BITree[index];

            // Move index to parent node in getSum
            index -= index & (-index);
        }
        return sum;
    }
}
