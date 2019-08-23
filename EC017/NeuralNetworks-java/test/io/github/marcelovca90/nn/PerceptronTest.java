package io.github.marcelovca90.nn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.example.LogicGateAND;
import io.github.marcelovca90.nn.data.example.LogicGateOR;
import io.github.marcelovca90.nn.data.example.LogicGateXOR;

public class PerceptronTest
{
    private static final double PRECISION = 1e-9;

    @Test
    public void trainAndTest_withLogicGateAND_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateAND();
        NeuralNetwork network = new Perceptron();

        // when
        double[] weights = network.train(dataSet);
        Triple<Double, Long, Long> result = network.test(dataSet, weights);
        double accuracy = result.getLeft();
        long correct = result.getMiddle();
        long total = result.getRight();

        // then
        assertNotNull(weights);
        assertEquals(1.0, accuracy, PRECISION);
        assertEquals(4, correct);
        assertEquals(4, total);
    }

    @Test
    public void trainAndTest_withLogicGateOR_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateOR();
        NeuralNetwork network = new Perceptron();

        // when
        double[] weights = network.train(dataSet);
        Triple<Double, Long, Long> result = network.test(dataSet, weights);
        double accuracy = result.getLeft();
        long correct = result.getMiddle();
        long total = result.getRight();

        // then
        assertNotNull(weights);
        assertEquals(1.0, accuracy, PRECISION);
        assertEquals(4, correct);
        assertEquals(4, total);
    }

    @Test
    public void trainAndTest_withLogicGateXOR_shouldNotConverge()
    {
        // given
        DataSet dataSet = new LogicGateXOR();
        NeuralNetwork network = new Perceptron();

        // when
        double[] weights = network.train(dataSet);
        Triple<Double, Long, Long> result = network.test(dataSet, weights);
        double accuracy = result.getLeft();
        long correct = result.getMiddle();
        long total = result.getRight();

        // then
        assertNotNull(weights);
        assertNotEquals(1.0, accuracy, PRECISION);
        assertNotEquals(4, correct);
        assertEquals(4, total);
    }
}
