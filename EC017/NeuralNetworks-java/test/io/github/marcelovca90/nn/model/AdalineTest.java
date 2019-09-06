package io.github.marcelovca90.nn.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.LogicGateAND;
import io.github.marcelovca90.nn.data.LogicGateOR;
import io.github.marcelovca90.nn.data.LogicGateXOR;

public class AdalineTest
{
    private static final double PRECISION = 1e-9;

    @Test
    public void trainTestEvaluate_withLogicGateAND_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateAND();
        NeuralNetwork network = new Adaline();

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, PRECISION);
    }

    @Test
    public void trainTestEvaluate_withLogicGateOR_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateOR();
        NeuralNetwork network = new Adaline();

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, PRECISION);
    }

    @Test
    public void trainTestEvaluate_withLogicGateXOR_shouldNotConverge()
    {
        // given
        DataSet dataSet = new LogicGateXOR();
        NeuralNetwork network = new Adaline();

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, PRECISION);
    }
}
