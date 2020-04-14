import numpy

class BitSet:
    
    def __init__(self, size):
        self.bits = numpy.full((1, size), False)

    def get(self, index):
        return self.bits[0,index]

    def set(self, index, value):
        self.bits[0,index] = value

    def flip(self, index):
        self.bits[0,index] = not self.bits[0,index]
    
    def debug(self):
        print(self.bits)
