package io.github.marcelovca90.ga.algorithm;

import java.util.List;
import java.util.Random;

import io.github.marcelovca90.ga.entity.Chromossome;

public class GeneticOperators
{
    private static final double MUTATION_PROBABILITY = 0.05;
    private static final Random RANDOM = new Random(42L);

    public static Chromossome[] selection(List<Chromossome> population)
    {
        // choose parents for crossover; they must not be the same individual
        int parent1Index = -1, parent2Index = -1;
        do
        {
            parent1Index = RANDOM.nextInt(population.size());
            parent2Index = RANDOM.nextInt(population.size());
        } while (parent1Index == parent2Index);
        Chromossome parent1 = population.get(parent1Index);
        System.out.println("1st parent chosen for crossover: " + GeneticUtils.formatChromossome(parent1));
        Chromossome parent2 = population.get(parent2Index);
        System.out.println("2nd parent chosen for crossover: " + GeneticUtils.formatChromossome(parent2));
        return new Chromossome[] { parent1, parent2 };
    }

    public static void crossover(List<Chromossome> population, Chromossome parent1, Chromossome parent2)
    {
        // choose point for crossover; it must be within genes indices
        int crossoverPoint = 0;
        do
        {
            crossoverPoint = RANDOM.nextInt(8);
        } while (crossoverPoint == 0 || crossoverPoint == 7);
        System.out.println("Crossover will happen at point " + crossoverPoint);

        Chromossome[] children = Chromossome.fromParents(crossoverPoint, parent1, parent2);
        Chromossome child1 = children[0];
        System.out.println("1st child generated from crossover: " + GeneticUtils.formatChromossome(child1));
        Chromossome child2 = children[1];
        System.out.println("2nd child generated from crossover: " + GeneticUtils.formatChromossome(child2));

        // add children to population
        population.add(child1);
        population.add(child2);
    }

    public static void mutation(List<Chromossome> population)
    {
        // determine if there will be a mutation
        double prob = RANDOM.nextDouble();
        if (prob < MUTATION_PROBABILITY)
        {
            // choose individual for mutation
            int mutationIndividualIndex = RANDOM.nextInt(population.size());
            Chromossome beforeMutation = population.get(mutationIndividualIndex);

            // choose mutation point
            int mutationPoint = RANDOM.nextInt(8);
            System.out.println("Individual " + beforeMutation + " will mutate at point " + mutationPoint);

            // perform flip mutation
            Chromossome afterMutation = beforeMutation.flipGeneAt(mutationPoint);
            population.set(mutationIndividualIndex, afterMutation);
        }
    }

    public static void elitism(List<Chromossome> population)
    {
        // remove the worst two individuals from population
        for (int i = 0; i < 2; i++)
        {
            int worstIndividualIndex = GeneticUtils.findWorstChromossomeIndex(population);
            Chromossome worstIndividual = population.get(worstIndividualIndex);
            System.out.println("Removing worst individual from population: " + GeneticUtils.formatChromossome(worstIndividual));
            population.remove(worstIndividualIndex);
        }
    }
}
