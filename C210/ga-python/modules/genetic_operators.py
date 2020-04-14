import random

from .bitset import BitSet
from .chromossome import Chromossome
from .genetic_utils import GeneticUtils

class GeneticOperators:

    MUTATION_PROBABILITY = 0.05

    @staticmethod
    def selection(population):
        parent1 = random.choice(population)
        parent2 = random.choice(population)

        while parent1 is parent2:
            parent1 = random.choice(population)
            parent2 = random.choice(population)

        print(f"1st parent chosen for crossover: {GeneticUtils.format_chromossome(parent1)}")
        print(f"2nd parent chosen for crossover: {GeneticUtils.format_chromossome(parent2)}")

        return parent1, parent2

    @staticmethod
    def crossover(population, parent1, parent2):
        crossover_point = random.randint(1, 6)
        print(f"Crossover will happen at point {crossover_point}")

        parent1_genes = parent1.get_genes()
        parent2_genes = parent2.get_genes()

        child1_genes = BitSet(8)
        child2_genes = BitSet(8)

        for i in range(crossover_point):
            child1_genes.set(i, parent1_genes.get(i))
            child2_genes.set(i, parent2_genes.get(i))

        for i in range(crossover_point, 8):
            child1_genes.set(i, parent2_genes.get(i))
            child2_genes.set(i, parent1_genes.get(i))

        child1 = Chromossome()
        child1.set_genes(child1_genes)
        print(f"1st child generated from crossover: {GeneticUtils.format_chromossome(child1)}")

        child2 = Chromossome()
        child2.set_genes(child2_genes)
        print(f"2nd child generated from crossover: {GeneticUtils.format_chromossome(child2)}")

        population.append(child1)
        population.append(child2)

    @staticmethod
    def mutation(population):
        prob = random.uniform(0, 1)

        if prob >= GeneticOperators.MUTATION_PROBABILITY:
            return

        target = random.choice(population)

        mutation_point = random.randint(0, 7)
        print(f"Individual {target.to_string()} will mutate at point {mutation_point}")

        genes = target.get_genes()
        genes.flip(mutation_point)

        print(f"Individual {target.to_string()} mutated at point {mutation_point}")

    @staticmethod
    def elitism(population):
        for _ in range(2):
            worst_individual = GeneticUtils.find_worst_chromossome(population)
            print(f"Removing worst individual from population: {GeneticUtils.format_chromossome(worst_individual)}")
            population.remove(worst_individual)
