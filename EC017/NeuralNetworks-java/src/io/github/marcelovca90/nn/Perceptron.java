package io.github.marcelovca90.nn;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

import org.apache.commons.lang3.tuple.Triple;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.AlgebraUtils;
import io.github.marcelovca90.nn.math.Heaviside;

public class Perceptron implements NeuralNetwork
{
    private double[][] x;
    private double[] d;
    private double n;
    private double[] w;
    private ActivationFunction g;

    @Override
    public double[] train(DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        n = 0.1;
        w = DoubleStream
            .generate(ThreadLocalRandom.current()::nextDouble)
            .limit(dataSet.getNumberOfFeatures())
            .toArray();
        g = new Heaviside();

        int epoch = 0;
        boolean error;

        do
        {
            error = false;
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
            {
                double v = AlgebraUtils.dotProduct(x[i], w);
                double y = g.compute(v);
                if (Double.compare(y, d[i]) != 0)
                {
                    for (int j = 0; j < dataSet.getNumberOfFeatures(); j++)
                    {
                        w[j] += (n * (d[i] - y) * x[i][j]);
                    }
                    error = true;
                }
            }
            epoch++;
            System.out.printf("Epoch: %d\tWeights: %s\n", epoch, Arrays.toString(w));
        } while (error && epoch < 10000);

        return Arrays.copyOf(w, w.length);
    }

    @Override
    public Triple<Double, Long, Long> test(DataSet dataSet, double[] weights)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        long correct = 0;
        long total = dataSet.getNumberOfSamples();
        for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
        {
            double v = AlgebraUtils.dotProduct(x[i], w);
            double y = g.compute(v);
            if (Double.compare(y, d[i]) == 0)
            {
                correct++;
            }
        }
        double accuracy = (double) correct / (double) total;
        System.out.printf("Accuracy: %.2f%% (%d/%d)\n", 100.0 * accuracy, correct, total);
        return Triple.of(accuracy, correct, total);
    }
}
