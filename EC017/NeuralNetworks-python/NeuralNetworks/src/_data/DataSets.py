'''
Created on 23 de ago de 2019

@author: marcelovca90
'''
import numpy as np
import os, sys
from numpy.random import sample
from numpy import genfromtxt

class DataSets:
    
    @staticmethod
    def read(folder, filename, flatten = False):
        filename_abs = os.path.join(os.path.dirname(__file__), folder, filename)
        return genfromtxt(filename_abs, delimiter=',', dtype=float)

# https://en.wikipedia.org/wiki/AND_gate
class LOGIC_GATE_AND:
    input = DataSets.read('logic-gate-and', 'input.txt')
    output = DataSets.read('logic-gate-and', 'output.txt', True)

# https://en.wikipedia.org/wiki/OR_gate
class LOGIC_GATE_OR:
    input = DataSets.read('logic-gate-or', 'input.txt')
    output = DataSets.read('logic-gate-or', 'output.txt', True)

# https://en.wikipedia.org/wiki/XOR_gate
class LOGIC_GATE_XOR:
    input = DataSets.read('logic-gate-xor', 'input.txt')
    output = DataSets.read('logic-gate-xor', 'output.txt', True)
