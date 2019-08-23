package io.github.marcelovca90.nn.data;

import java.util.stream.DoubleStream;

public class DataSet
{
    private double[][] samples;

    private double[] labels;

    public DataSet(double[][] samples, double[] labels)
    {
        this.samples = samples;
        this.labels = labels;
    }

    public double[][] getSamples()
    {
        return samples;
    }

    public double[] getLabels()
    {
        return labels;
    }

    public long getNumberOfClasses()
    {
        return DoubleStream.of(getLabels()).distinct().count();
    }

    public long getNumberOfFeatures()
    {
        return getSamples()[0].length;
    }

    public long getNumberOfSamples()
    {
        return getSamples().length;
    }
}
