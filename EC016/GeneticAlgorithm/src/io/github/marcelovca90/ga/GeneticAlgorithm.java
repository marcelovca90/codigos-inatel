package io.github.marcelovca90.ga;

import java.security.SecureRandom;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import io.github.marcelovca90.ga.util.RandomString;

public class GeneticAlgorithm
{
    private final String OBJECTIVE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    private final int OBJECTIVE_LENGTH = OBJECTIVE.length();

    private final int POPULATION_SIZE = 10;

    private final double PROB_MUTATION = 0.05;

    private final Random RANDOM = new SecureRandom();

    private final RandomString GENERATOR = new RandomString(OBJECTIVE_LENGTH);

    public List<String> generatePopulation()
    {
        List<String> population = new ArrayList<>(POPULATION_SIZE);
        for (int i = 0; i < POPULATION_SIZE; i++)
            population.add(GENERATOR.nextString());
        return population;
    }

    public String mutate(String individual, int mutationPoint)
    {
        return individual.substring(0, mutationPoint) + GENERATOR.nextChar() + individual.substring(mutationPoint + 1);
    }

    public Entry<String, String> crossover(String father, String mother, int i)
    {
        String child1 = father.substring(0, i) + mother.substring(i);
        String child2 = mother.substring(0, i) + father.substring(i);
        return new SimpleEntry<>(child1, child2);
    }

    public int fitness(String individual)
    {
        int diff = 0;
        for (int i = 0; i < OBJECTIVE_LENGTH; i++)
            if (individual.charAt(i) != OBJECTIVE.charAt(i))
                diff++;
        return diff;
    }

    private void sortByFitness(List<String> population)
    {
        population.sort((String a, String b) -> fitness(a) - fitness(b));
    }

    public void run()
    {
        // generate initial population
        List<String> population = generatePopulation();

        // initialize epoch counter
        int epoch = 0;

        // repeat until solution has been found
        while (fitness(population.get(0)) != 0)
        {
            // mutation
            for (int i = 0; i < POPULATION_SIZE; i++)
            {
                if (RANDOM.nextDouble() < PROB_MUTATION)
                {
                    // random mutation point
                    int mutationPoint = RANDOM.nextInt(OBJECTIVE_LENGTH);

                    // replacing individual in population
                    String mutatedElement = mutate(population.get(i), mutationPoint);
                    population.set(i, mutatedElement);
                }
            }

            // crossover
            // select random father and mother indices
            int fatherIndex, motherIndex;
            do
            {
                fatherIndex = RANDOM.nextInt(POPULATION_SIZE);
                motherIndex = RANDOM.nextInt(POPULATION_SIZE);
            } while (fatherIndex == motherIndex);

            // retrieve father and mother individuals
            String father = population.get(fatherIndex);
            String mother = population.get(motherIndex);

            // random crossover point
            int crossoverPoint = RANDOM.nextInt(OBJECTIVE_LENGTH);
            Entry<String, String> children = crossover(father, mother, crossoverPoint);

            // add children to population
            population.add(children.getKey()); // first child
            population.add(children.getValue()); // second child

            // sort population by fitness
            sortByFitness(population);

            // remove two worst individuals
            population.remove(population.size() - 1);
            population.remove(population.size() - 1);

            // increment epoch counter
            epoch++;

            // print best individual so far (and its fitness)
            System.out.println(epoch + "\t" + population.get(0) + " (" + fitness(population.get(0)) + ")");
        }

        // print solution (and its fitness)
        System.out.println(epoch + "\t" + population.get(0) + " (" + fitness(population.get(0)) + ")");
    }

    public static void main(String[] args) throws InterruptedException
    {
        new GeneticAlgorithm().run();
    }
}
