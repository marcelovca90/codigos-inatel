package io.github.marcelovca90.nn.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.MathUtils;
import io.github.marcelovca90.nn.plot.PlotUtils;

public class MultilayerPerceptron implements NeuralNetwork
{
    private double[][] x;
    private double[] d;
    private double n;
    private int n1 = 3;
    private int n2 = 2;
    private int n3 = 1;
    private double[][] w1;
    private double[][] w2;
    private double[][] w3;
    private ActivationFunction g;
    private double e;
    private List<Double> plotDataX;
    private List<Double> plotDataY;
    private double[] i1, i2, i3;
    private double[] y1, y2, y3;

    public MultilayerPerceptron(double n, ActivationFunction g, double e)
    {
        this.n = n;
        this.g = g;
        this.e = e;
        this.plotDataX = new ArrayList<>();
        this.plotDataY = new ArrayList<>();
    }

    private double[][] generateRandomSynapticWeightsMatrix(int ni, int nj)
    {
        Random random = new Random(42L);
        double[][] w = new double[ni][nj];
        for (int i = 0; i < ni; i++)
            w[i] = random.doubles(nj).toArray();
        return w;
    }

    private void printMatrix(double[][] mat, String label)
    {
        System.out.println(label + " = ");
        for (double[] arr : mat)
            System.out.println("\t" + Arrays.toString(arr));
    }

    @Override
    public double[] train(DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();

        w1 = generateRandomSynapticWeightsMatrix((int) dataSet.getNumberOfFeatures(), n1);
        w2 = generateRandomSynapticWeightsMatrix(n1, n2);
        w3 = generateRandomSynapticWeightsMatrix(n2, n3);

        int epoch = 0;
        double[] yArray = new double[(int) dataSet.getNumberOfSamples()];
        double mseBefore, mseAfter;

        do
        {
            // calculate mse before weights adjustments
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
                yArray[i] = feedForward(dataSet, i)[0];
            mseBefore = MathUtils.meanSquaredError(yArray, d);

            for (int sampleIndex = 0; sampleIndex < dataSet.getNumberOfSamples(); sampleIndex++)
            {
                feedForward(dataSet, sampleIndex);
                backPropagate(dataSet, sampleIndex);
            }

            // calculate mse after weights adjustments
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
                yArray[i] = feedForward(dataSet, i)[0];
            mseAfter = MathUtils.meanSquaredError(yArray, d);

            epoch++;
            System.err.printf("Epoch: %d\tWeights: %s\tError: %s\n", epoch, " ", mseAfter);
            plotDataX.add((double) epoch);
            plotDataY.add(mseAfter);

        } while (Double.compare(Math.abs(mseAfter - mseBefore), e) >= 0);

        return null;

    }

    private double[] feedForward(DataSet dataSet, int k)
    {
        // i1
        i1 = new double[n1];
        // System.out.println("i1 = " + Arrays.toString(i1));
        for (int i = 0; i < dataSet.getNumberOfFeatures(); i++)
            for (int j = 0; j < n1; j++)
                i1[j] += x[k][i] * w1[i][j];
        // System.out.println("i1' = " + Arrays.toString(i1));

        // y1
        y1 = new double[n1];
        // System.out.println("y1 = " + Arrays.toString(y1));
        for (int j = 0; j < n1; j++)
            y1[j] = g.compute(i1[j]);
        // System.out.println("y1' = " + Arrays.toString(y1));

        // i2
        i2 = new double[n2];
        // System.out.println("i2 = " + Arrays.toString(i2));
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                i2[j] += y1[i] * w2[i][j];
        // System.out.println("i2' = " + Arrays.toString(i2));

        // y2
        y2 = new double[n2];
        // System.out.println("y2 = " + Arrays.toString(y2));
        for (int j = 0; j < n2; j++)
            y2[j] = g.compute(i2[j]);
        // System.out.println("y2' = " + Arrays.toString(y2));

        // i3
        i3 = new double[n3];
        // System.out.println("i3 = " + Arrays.toString(i3));
        for (int i = 0; i < n2; i++)
            for (int j = 0; j < n3; j++)
                i3[j] += y2[i] * w3[i][j];
        // System.out.println("i3' = " + Arrays.toString(i3));

        // y3
        y3 = new double[n3];
        // System.out.println("y3 = " + Arrays.toString(y3));
        for (int j = 0; j < n3; j++)
            y3[j] = g.compute(i3[j]);
        // System.out.println("y3' = " + Arrays.toString(y3));

        return Arrays.copyOf(y3, y3.length);
    }

    private void backPropagate(DataSet dataSet, int sampleIndex)
    {
        // delta3
        double[] delta3 = new double[n3];
        // System.out.println("delta3 = " + Arrays.toString(delta3));
        for (int j = 0; j < n3; j++)
            delta3[j] = (d[j] - y3[j]) * g.computeFirstDerivative(i3[j]);
        // System.out.println("delta3' = " + Arrays.toString(delta3));

        // w3
        // printMatrix(w3, "w3");
        for (int i = 0; i < n2; i++)
            for (int j = 0; j < n3; j++)
                w3[i][j] += n * delta3[j] * y2[i];
        // printMatrix(w3, "w3'");

        // delta2
        double[] delta2 = new double[n2];
        // System.out.println("delta2 = " + Arrays.toString(delta2));
        for (int j = 0; j < n2; j++)
        {
            delta2[j] = 0.0;
            for (int k = 0; k < n3; k++)
                delta2[j] += delta3[k] * w3[j][k];
            delta2[j] *= g.computeFirstDerivative(i2[j]);
        }
        // System.out.println("delta2' = " + Arrays.toString(delta2));

        // w2
        // printMatrix(w2, "w2");
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                w2[i][j] += n * delta2[j] * y1[i];
        // printMatrix(w2, "w2'");

        // delta1
        double[] delta1 = new double[n1];
        // System.out.println("delta1 = " + Arrays.toString(delta1));
        for (int j = 0; j < n1; j++)
        {
            delta1[j] = 0.0;
            for (int k = 0; k < n2; k++)
                delta1[j] += delta2[k] * w2[j][k];
            delta1[j] *= g.computeFirstDerivative(i1[j]);
        }
        // System.out.println("delta1' = " + Arrays.toString(delta1));

        // w1
        // printMatrix(w1, "w1");
        for (int i = 0; i < dataSet.getNumberOfFeatures(); i++)
            for (int j = 0; j < n1; j++)
                w1[i][j] += n * delta1[j] * x[sampleIndex][i];
        // printMatrix(w1, "w1'");
    }

    @Override
    public double test(double[] weights, double[] sample)
    {
        return Double.NaN;
    }

    @Override
    public double evaluate(double[] weights, DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        long correct = 0;
        long total = dataSet.getNumberOfSamples();
        for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
        {
            double y = Math.signum(feedForward(dataSet, i)[0]);
            if (Double.compare(y, d[i]) == 0)
            {
                correct++;
            }
        }
        double accuracy = (double) correct / (double) total;
        System.out.printf("Accuracy: %.2f%% (%d/%d)\n", 100.0 * accuracy, correct, total);
        return accuracy;
    }

    public void plotErrorPerEpoch()
    {
        PlotUtils.plot(
            plotDataX.stream().mapToDouble(Double::doubleValue).toArray(),
            "epoch",
            plotDataY.stream().mapToDouble(Double::doubleValue).toArray(),
            "error");
    }
}
