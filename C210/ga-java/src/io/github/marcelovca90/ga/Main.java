package io.github.marcelovca90.ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main
{
    public static Problem problem = new Problem();

    public static Random random = new Random(42L);

    public static void main(String[] args)
    {
        List<Chromossome> population = new ArrayList<>();
        population.add(new Chromossome(4, 3));
        population.add(new Chromossome(2, 9));
        population.add(new Chromossome(9, 11));
        population.add(new Chromossome(0, 15));
        population.add(new Chromossome(5, 5));
        population.add(new Chromossome(14, 3));

        int generations = 0;

        do
        {
            // print all scores
            // population.stream().forEach(Main::debugChromossome);
            // System.out.println("Population average score = " + problem.average_f(population));

            // choose parents for crossover
            int parent1Index = -1, parent2Index = -1;
            do
            {
                parent1Index = random.nextInt(population.size());
                parent2Index = random.nextInt(population.size());
            } while (parent1Index == parent2Index);
            Chromossome parent1 = population.get(parent1Index);
            Chromossome parent2 = population.get(parent2Index);

            // calculate population score
            // System.out.println("Crossover between " + parent1Index + " and " + parent2Index);

            // choose point for crossover
            int crossoverPoint = 0;
            do
            {
                crossoverPoint = random.nextInt(8);
            } while (crossoverPoint == 0 || crossoverPoint == 7);
            // System.out.println("Crossover point = " + crossoverPoint);

            Chromossome[] children = Chromossome.fromParents(crossoverPoint, parent1, parent2);
            Chromossome child1 = children[0];
            Chromossome child2 = children[1];
            // debugChromossome(child1);
            // debugChromossome(child2);

            // add children to population
            population.add(child1);
            population.add(child2);

            // choose if there will be a mutation
            double prob = random.nextDouble();
            if (prob < 0.05)
            {
                // choose individual for mutation
                int mutationIndividualIndex = random.nextInt(population.size());
                Chromossome c = population.get(mutationIndividualIndex);
                // choose mutation point
                int mutationPoint = random.nextInt(8);
                System.out.println("Individual " + c + " will mutate at " + mutationPoint);
                debugChromossome(c);
                c = c.flipGeneAt(mutationPoint);
                population.set(mutationIndividualIndex, c);
                debugChromossome(c);
            }

            // remove worst individuals from population
            population.remove(findWorstChromossomeIndex(population));
            population.remove(findWorstChromossomeIndex(population));

            // calculate new population average score
            System.out.println(generations + " population average score = " + problem.average_f(population));

        } while (++generations < 100);

        System.out.println(
            "Best individual: " +
                    Arrays.toString(Chromossome.decode(population.get(findBestChromossomeIndex(population)).getGenes())));
    }

    private static int findBestChromossomeIndex(List<Chromossome> pop)
    {
        double maxScore = Double.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < pop.size(); i++)
        {
            double score = problem.g(pop.get(i));
            if (score > maxScore)
            {
                maxScore = score;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int findWorstChromossomeIndex(List<Chromossome> pop)
    {
        double minScore = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < pop.size(); i++)
        {
            double score = problem.g(pop.get(i));
            if (score < minScore)
            {
                minScore = score;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void debugChromossome(Chromossome c)
    {
        System.out.println(
            String.format(
                "Genotype = %s\tFenotype = %s\tFitness = %s",
                c.toString(), Arrays.toString(Chromossome.decode(c.getGenes())), problem.g(c)));
    }
}
