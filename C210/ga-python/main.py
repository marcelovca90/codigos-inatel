import matplotlib.pyplot as plt

from modules.chromossome import Chromossome
from modules.genetic_operators import GeneticOperators
from modules.genetic_utils import GeneticUtils
from modules.problem import Problem

if __name__ == "__main__":
    population = []
    for _ in range(10):
        population.append(Chromossome())

    generation = 0
    population_score = Problem.f_average(population)

    generation_plot = []
    generation_plot.append(generation)

    population_score_plot = []
    population_score_plot.append(population_score)

    while generation < 100:
        parent1, parent2 = GeneticOperators.selection(population)

        GeneticOperators.crossover(population, parent1, parent2)
        GeneticOperators.mutation(population)
        GeneticOperators.elitism(population)

        generation += 1
        population_score = Problem.f_average(population)

        generation_plot.append(generation)
        population_score_plot.append(population_score)

        print(f"Generation # {generation} -> Average population score = {population_score:.3f}\n")

    best_chromossome = GeneticUtils.find_best_chromossome(population)
    print(f"Best individual: {GeneticUtils.format_chromossome(best_chromossome)}")

    plt.gca().set_xlabel('Generations')
    plt.gca().set_ylabel('Average Fitness')
    plt.gca().set_title('Generations vs Average Fitness')
    plt.plot(generation_plot, population_score_plot)
    plt.show()
