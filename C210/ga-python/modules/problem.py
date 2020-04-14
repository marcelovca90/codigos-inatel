import math

from .chromossome import Chromossome

class Problem:

    @staticmethod
    def f(x, y):
        return abs(x * y * math.sin(math.pi * y / 4.0))

    @staticmethod
    def f_chromossome(chromossome):
        x, y = Chromossome.get_fenotype(chromossome.get_genes())
        return Problem.f(x, y)

    @staticmethod
    def g(x, y):
        return Problem.f(x, y) + 1

    @staticmethod
    def g_chromossome(chromossome):
        x, y = Chromossome.get_fenotype(chromossome.get_genes())
        return Problem.g(x, y)

    @staticmethod
    def f_average(population):
        avg = 0
        for chromossome in population:
            avg += Problem.f_chromossome(chromossome)
        avg /= len(population)
        return avg

    @staticmethod
    def g_average(population):
        avg = 0
        for chromossome in population:
            avg += g_chromossome(chromossome)
        avg /= len(population)
        return avg
