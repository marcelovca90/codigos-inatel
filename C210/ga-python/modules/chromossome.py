import random

from .bitset import BitSet

class Chromossome:
    def __init__(self, x = None, y = None):
        if x == None:
            x = random.randint(-10, 10)

        if y == None:
            y = random.randint(-10, 10)

        self.__genes = Chromossome.get_genotype(x, y)

    def get_genes(self):
        return self.__genes

    def set_genes(self, genes):
        self.__genes = genes

    def to_string(self):
        chr_str = "G = ["

        for i in range(8):
            chr_str += (i == 4 and " " or "") + (self.__genes.get(i) and "1" or "0")

        x, y = Chromossome.get_fenotype(self.__genes)

        chr_str += "], F = [" + str(x) + ", " + str(y) + "]"

        return chr_str

    @staticmethod
    def get_genotype(x, y):
        bits = BitSet(8)

        xy_binary = "{:04b}".format(x) + "{:04b}".format(y)

        for i in range(8):
            bits.set(i, xy_binary[i] == '1')

        return bits

    @staticmethod
    def get_fenotype(genes):
        x = (8 * genes.get(0) +
            4 * genes.get(1) +
            2 * genes.get(2) +
            1 * genes.get(3))

        y = (8 * genes.get(4) +
            4 * genes.get(5) +
            2 * genes.get(6) +
            1 * genes.get(7))

        return x, y
