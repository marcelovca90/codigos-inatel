package br.inatel.c210.ga.algorithm;

import static br.inatel.c210.ga.algorithm.GeneticUtils.RANDOM;

import java.util.BitSet;
import java.util.List;

import br.inatel.c210.ga.entity.Chromossome;

public class GeneticOperators
{
    private static final double MUTATION_PROBABILITY = 0.05;

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

        // initialize genes to perform the crossover
        BitSet child1genes = new BitSet(8);
        BitSet child2genes = new BitSet(8);

        // copy genes before the crossover point
        for (int i = 0; i < crossoverPoint; i++)
        {
            child1genes.set(i, parent1.getGenes().get(i));
            child2genes.set(i, parent2.getGenes().get(i));
        }

        // copy genes from the crossover point on
        for (int i = crossoverPoint; i < 8; i++)
        {
            child1genes.set(i, parent2.getGenes().get(i));
            child2genes.set(i, parent1.getGenes().get(i));
        }

        // instantiate the first child
        Integer[] child1_xy = Chromossome.getFenotype(child1genes);
        Chromossome child1 = new Chromossome(child1_xy[0], child1_xy[1]);
        System.out.println("1st child generated from crossover: " + GeneticUtils.formatChromossome(child1));

        // instantiate the second child
        Integer[] child2_xy = Chromossome.getFenotype(child2genes);
        Chromossome child2 = new Chromossome(child2_xy[0], child2_xy[1]);
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
            Chromossome target = population.get(mutationIndividualIndex);

            // choose mutation point
            int mutationPoint = RANDOM.nextInt(8);
            System.out.println("Individual " + target + " will mutate at point " + mutationPoint);

            // perform flip mutation
            BitSet genes = target.getGenes();
            genes.flip(mutationPoint);
            target.setGenes(genes);
            System.out.println("Individual " + target + " mutated at point " + mutationPoint);

            // update the population with the mutated individual
            population.set(mutationIndividualIndex, target);
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
