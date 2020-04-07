package br.inatel.c210.ga.algorithm;

import java.util.List;
import java.util.Random;

import br.inatel.c210.ga.entity.Chromossome;
import br.inatel.c210.ga.entity.Problem;

public class GeneticUtils
{
    public static final Random RANDOM = new Random(42L);

    public static Chromossome findBestChromossome(List<Chromossome> population)
    {
        return population.get(findBestChromossomeIndex(population));
    }

    public static int findBestChromossomeIndex(List<Chromossome> population)
    {
        double maxScore = Double.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < population.size(); i++)
        {
            double score = Problem.g(population.get(i));
            if (score > maxScore)
            {
                maxScore = score;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static Chromossome findWorstChromossome(List<Chromossome> population)
    {
        return population.get(findWorstChromossomeIndex(population));
    }

    public static int findWorstChromossomeIndex(List<Chromossome> population)
    {
        double minScore = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < population.size(); i++)
        {
            double score = Problem.g(population.get(i));
            if (score < minScore)
            {
                minScore = score;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static String formatChromossome(Chromossome c)
    {
        return String.format("%s, Score = %.3f", c, Problem.g(c));
    }
}
