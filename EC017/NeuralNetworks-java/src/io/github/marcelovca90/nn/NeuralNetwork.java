package io.github.marcelovca90.nn;

import io.github.marcelovca90.nn.data.DataSet;

public interface NeuralNetwork
{
    public double[] train(DataSet dataSet);

    public double test(DataSet dataSet, double[] weights);
}
