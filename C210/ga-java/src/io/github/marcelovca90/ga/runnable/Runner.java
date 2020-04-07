package io.github.marcelovca90.ga.runnable;

import java.util.ArrayList;
import java.util.List;

import io.github.marcelovca90.ga.algorithm.GeneticOperators;
import io.github.marcelovca90.ga.algorithm.GeneticUtils;
import io.github.marcelovca90.ga.entity.Chromossome;
import io.github.marcelovca90.ga.entity.Problem;
import io.github.marcelovca90.ga.plot.PlotUtils;

public class Runner
{
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
        double populationScore = Problem.f_average(population);
        PlotUtils.add(generation, populationScore);

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
            System.err.println("#" + generation + " Population average score = " + populationScore);

        } while (generation < 50);

        // find the best individual after running the genetic algorithm
        Chromossome bestChromossome = GeneticUtils.findBestChromossome(population);
        System.out.println("Best individual: " + GeneticUtils.formatChromossome(bestChromossome));

        // plot 'generations vs average fitness' chart
        PlotUtils.plot();
    }
}
