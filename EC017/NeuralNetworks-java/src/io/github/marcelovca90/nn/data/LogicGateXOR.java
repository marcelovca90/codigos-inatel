package io.github.marcelovca90.nn.data;

public class LogicGateXOR extends DataSet
{
    private static final double[][] _SAMPLES = new double[][] {
            { -1.0, 0.0, 0.0 },
            { -1.0, 0.0, 1.0 },
            { -1.0, 1.0, 0.0 },
            { -1.0, 1.0, 1.0 }
    };

    private static final double[] _LABELS = new double[] {
            0.0,
            1.0,
            1.0,
            0.0
    };

    public LogicGateXOR()
    {
        super(_SAMPLES, _LABELS);
    }
}
