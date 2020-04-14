from .problem import Problem

class GeneticUtils:

    @staticmethod
    def find_best_chromossome(population):
        best_chromossome = None

        for chromossome in population:
            score = Problem.g_chromossome(chromossome)

            if best_chromossome is None or score > Problem.g_chromossome(best_chromossome):
                best_chromossome = chromossome

        return best_chromossome

    @staticmethod
    def find_worst_chromossome(population):
        worst_chromossome = None

        for chromossome in population:
            score = Problem.g_chromossome(chromossome)

            if worst_chromossome is None or score < Problem.g_chromossome(worst_chromossome):
                worst_chromossome = chromossome

        return worst_chromossome

    @staticmethod
    def format_chromossome(chromossome):
        return f"{chromossome.to_string()}, Score = {Problem.g_chromossome(chromossome):.3f}"
