package io.github.marcelovca90.nn.math;

public class AlgebraUtils
{
    public static double dotProduct(double[] d1, double[] d2)
    {
        double ans = 0.0;
        for (int i = 0; i < d1.length; i++)
            ans += (d1[i] * d2[i]);
        return ans;
    }
}
