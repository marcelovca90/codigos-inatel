package io.github.marcelovca90.nn;

import org.apache.commons.lang3.tuple.Triple;

import io.github.marcelovca90.nn.data.DataSet;

public interface NeuralNetwork
{
    public double[] train(DataSet dataSet);

    public Triple<Double, Long, Long> test(DataSet dataSet, double[] weights);
}
