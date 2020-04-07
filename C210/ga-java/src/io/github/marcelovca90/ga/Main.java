package io.github.marcelovca90.ga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main
{
    private static final double MUTATION_PROBABILITY = 0.05;

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

        int generation = 0;
        double populationScore = problem.average_f(population);
        PlotUtils.add(generation, populationScore);

        do
        {
            // choose parents for crossover
            Chromossome[] parents = selection(population);

            // perform crossover and add children to population
            crossover(population, parents[0], parents[1]);

            // perform random flip mutation, if lucky
            mutation(population);

            // remove the two worst individuals from the population
            elitism(population);

            // increment generation counter
            generation++;

            // calculate new population average score
            populationScore = problem.average_f(population);

            // record the average score for the current generation
            PlotUtils.add(generation, populationScore);

            // print the average score for the current generation
            System.err.println("#" + generation + " Population average score = " + populationScore);

        } while (generation < 50);

        // find the best individual after running the genetic algorithm
        int bestChromossomeIndex = findBestChromossomeIndex(population);
        Chromossome bestChromossome = population.get(bestChromossomeIndex);
        System.out.println("Best individual: " + formatChromossome(bestChromossome));

        // plot 'generations vs average fitness' chart
        PlotUtils.plot();
    }

    private static Chromossome[] selection(List<Chromossome> population)
    {
        // choose parents for crossover; they must not be the same individual
        int parent1Index = -1, parent2Index = -1;
        do
        {
            parent1Index = random.nextInt(population.size());
            parent2Index = random.nextInt(population.size());
        } while (parent1Index == parent2Index);
        Chromossome parent1 = population.get(parent1Index);
        System.out.println("1st parent chosen for crossover: " + formatChromossome(parent1));
        Chromossome parent2 = population.get(parent2Index);
        System.out.println("2nd parent chosen for crossover: " + formatChromossome(parent2));
        return new Chromossome[] { parent1, parent2 };
    }

    private static void crossover(List<Chromossome> population, Chromossome parent1, Chromossome parent2)
    {
        // choose point for crossover; it must be within genes indices
        int crossoverPoint = 0;
        do
        {
            crossoverPoint = random.nextInt(8);
        } while (crossoverPoint == 0 || crossoverPoint == 7);
        System.out.println("Crossover will happen at point " + crossoverPoint);

        Chromossome[] children = Chromossome.fromParents(crossoverPoint, parent1, parent2);
        Chromossome child1 = children[0];
        System.out.println("1st child generated from crossover: " + formatChromossome(child1));
        Chromossome child2 = children[1];
        System.out.println("2nd child generated from crossover: " + formatChromossome(child2));

        // add children to population
        population.add(child1);
        population.add(child2);
    }

    private static void mutation(List<Chromossome> population)
    {
        // determine if there will be a mutation
        double prob = random.nextDouble();
        if (prob < MUTATION_PROBABILITY)
        {
            // choose individual for mutation
            int mutationIndividualIndex = random.nextInt(population.size());
            Chromossome beforeMutation = population.get(mutationIndividualIndex);

            // choose mutation point
            int mutationPoint = random.nextInt(8);
            System.out.println("Individual " + beforeMutation + " will mutate at point " + mutationPoint);

            // perform flip mutation
            Chromossome afterMutation = beforeMutation.flipGeneAt(mutationPoint);
            population.set(mutationIndividualIndex, afterMutation);
        }
    }

    private static void elitism(List<Chromossome> population)
    {
        // remove the worst two individuals from population
        for (int i = 0; i < 2; i++)
        {
            int worstIndividualIndex = findWorstChromossomeIndex(population);
            Chromossome worstIndividual = population.get(worstIndividualIndex);
            System.out.println("Removing worst individual from population: " + formatChromossome(worstIndividual));
            population.remove(worstIndividualIndex);
        }
    }

    private static int findBestChromossomeIndex(List<Chromossome> population)
    {
        double maxScore = Double.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < population.size(); i++)
        {
            double score = problem.g(population.get(i));
            if (score > maxScore)
            {
                maxScore = score;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int findWorstChromossomeIndex(List<Chromossome> population)
    {
        double minScore = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < population.size(); i++)
        {
            double score = problem.g(population.get(i));
            if (score < minScore)
            {
                minScore = score;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static String formatChromossome(Chromossome c)
    {
        return String.format("%s , Score = %.3f", c, problem.g(c));
    }
}
