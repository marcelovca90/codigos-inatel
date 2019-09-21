package io.github.marcelovca90.nn.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.sample.BloodTransfusion;
import io.github.marcelovca90.nn.data.sample.LogicGateAND;
import io.github.marcelovca90.nn.data.sample.LogicGateOR;
import io.github.marcelovca90.nn.data.sample.LogicGateXOR;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.Heaviside;
import io.github.marcelovca90.nn.math.HeavisideSymmetric;

public class AdalineTest
{
    private static final double LEARNING_RATE = 0.1;
    private static final ActivationFunction ACTIVATION_FUNCTION = new Heaviside();
    private static final double TOLERANCE = 1e-3;
    private static final double DELTA = 1e-9;

    @Test
    public void trainTestEvaluate_withLogicGateAND_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateAND();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluate_withLogicGateOR_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateOR();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluate_withLogicGateXOR_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateXOR();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluate_withBloodTransfusion_shouldConverge()
    {
        // given
        DataSet dataSet = new BloodTransfusion();
        NeuralNetwork network = new Adaline(1e-6, new HeavisideSymmetric(), 1e-12);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }
}
