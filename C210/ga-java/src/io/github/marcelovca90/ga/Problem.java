package io.github.marcelovca90.ga;

import java.util.List;

public class Problem
{
    public double f(Chromossome c)
    {
        Integer[] data = Chromossome.decode(c.getGenes());
        return f(data[0], data[1]);
    }

    public double g(Chromossome c)
    {
        Integer[] data = Chromossome.decode(c.getGenes());
        return g(data[0], data[1]);
    }

    public double average_f(List<Chromossome> pop)
    {
        double ans = 0.0;
        for (Chromossome c : pop)
            ans += g(c);
        return ans / pop.size();
    }

    private double f(int x, int y)
    {
        return Math.abs(x * y * Math.sin(Math.PI * y / 4.0));
    }

    private double g(int x, int y)
    {
        return f(x, y) + 1;
    }
}
