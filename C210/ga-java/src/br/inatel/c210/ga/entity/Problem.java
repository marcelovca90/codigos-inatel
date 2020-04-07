package br.inatel.c210.ga.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Problem
{
    public static double f(int x, int y)
    {
        return Math.abs(x * y * Math.sin(Math.PI * y / 4.0));
    }

    public static double f(Chromossome c)
    {
        Integer[] data = Chromossome.getFenotype(c.getGenes());
        return f(data[0], data[1]);
    }

    public static double g(int x, int y)
    {
        return f(x, y) + 1;
    }

    public static double g(Chromossome c)
    {
        Integer[] data = Chromossome.getFenotype(c.getGenes());
        return g(data[0], data[1]);
    }

    public static double f_average(List<Chromossome> pop)
    {
        return pop.stream().collect(Collectors.averagingDouble(c -> f(c)));
    }

    public static double g_average(List<Chromossome> pop)
    {
        return pop.stream().collect(Collectors.averagingDouble(c -> g(c)));
    }
}
