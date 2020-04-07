package br.inatel.c210.ga.runnable;

import java.util.ArrayList;
import java.util.List;

import br.inatel.c210.ga.algorithm.GeneticOperators;
import br.inatel.c210.ga.algorithm.GeneticUtils;
import br.inatel.c210.ga.entity.Chromossome;
import br.inatel.c210.ga.entity.Problem;
import br.inatel.c210.ga.plot.PlotUtils;

public class Runner
{
    public static void main(String[] args)
    {
        // create population
        List<Chromossome> population = new ArrayList<>();
        population.add(new Chromossome(4, 3));
        population.add(new Chromossome(2, 9));
        population.add(new Chromossome(9, 11));
        population.add(new Chromossome(0, 15));
        population.add(new Chromossome(5, 5));
        population.add(new Chromossome(14, 3));

        // initialize control and auxiliary variables
        int generation = 0;
        double populationScore = Problem.f_average(population);
        System.err.println(String.format("Generation # %d -> Average population score = %.3f", generation, populationScore));
        PlotUtils.add(generation, populationScore);

        // genetic algorithm main loop
        do
        {
            // choose parents for crossover
            Chromossome[] parents = GeneticOperators.selection(population);

            // perform crossover and add children to population
            GeneticOperators.crossover(population, parents[0], parents[1]);

            // perform random flip mutation, if lucky
            GeneticOperators.mutation(population);

            // remove the two worst individuals from the population
            GeneticOperators.elitism(population);

            // increment generation counter
            generation++;

            // calculate new population average score
            populationScore = Problem.f_average(population);

            // record the average score for the current generation
            PlotUtils.add(generation, populationScore);

            // print the average score for the current generation
            System.err.println(String.format("Generation # %d -> Average population score = %.3f", generation, populationScore));

        } while (generation < 50);

        // find the best individual after running the genetic algorithm
        Chromossome bestChromossome = GeneticUtils.findBestChromossome(population);
        System.out.println("Best individual: " + GeneticUtils.formatChromossome(bestChromossome));

        // plot 'generations vs average fitness' chart
        PlotUtils.plot();
    }
}
