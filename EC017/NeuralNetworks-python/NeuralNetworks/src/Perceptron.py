'''
Created on 23 de ago de 2019

@author: marcelovca90
'''
import numpy as np
from _data import DataSets
from _math import ActivationFunctions

class Perceptron:

    def __init__(self):
        self.n = 0.1 # learning rate
        self.g = ActivationFunctions.heaviside # activation function

    def train(self, x, d):
        k = len(x)
        w = np.random.rand(len(x[0]))
        epoch = 0
        error = True
        while error and epoch < 10000:
            error = False
            for i in range(0, k):
                v = np.dot(np.transpose(w), x[i])
                y = self.g(v)
                if y != d[i]:
                    w = np.add(w, np.multiply(self.n * (d[i] - y), x[i]))
                    error = True
            epoch = epoch + 1
            print('Epoch: {}\tWeights: {}'.format(epoch, w))
        return w

    def test(self, w, x, d):
        correct = 0
        total = len(x)
        for i in range(0, len(x)):
            v = np.dot(np.transpose(w), x[i])
            y = self.g(v)
            if (y == d[i]):
                correct = correct + 1
        accuracy = 100.0 * float(correct) / float(total)
        return accuracy,correct,total;

if  __name__ == '__main__':

    # load data
    x = DataSets.LOGIC_GATE_AND.input
    d = DataSets.LOGIC_GATE_AND.output

    # create the neural network
    nn = Perceptron()

    # train the neural network
    w = nn.train(x, d)

    # test the neural network
    accuracy,correct,total = nn.test(w, x, d)
    print('Accuracy: {:.2f}% ({}/{})'.format(accuracy, correct, total))
