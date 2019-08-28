package io.github.marcelovca90.nn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.example.LogicGateAND;
import io.github.marcelovca90.nn.data.example.LogicGateOR;
import io.github.marcelovca90.nn.data.example.LogicGateXOR;

public class PerceptronTest
{
    private static final double PRECISION = 1e-9;

    @Test
    public void trainTestEvaluate_withLogicGateAND_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateAND();
        NeuralNetwork network = new Perceptron();

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertEquals(1.0, accuracy, PRECISION);
    }

    @Test
    public void trainTestEvaluate_withLogicGateOR_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateOR();
        NeuralNetwork network = new Perceptron();

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertEquals(1.0, accuracy, PRECISION);
    }

    @Test
    public void trainTestEvaluate_withLogicGateXOR_shouldNotConverge()
    {
        // given
        DataSet dataSet = new LogicGateXOR();
        NeuralNetwork network = new Perceptron();

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(1.0, accuracy, PRECISION);
    }
}
