package io.github.marcelovca90.nn.data;

public class LogicGateAND extends DataSet
{
    private static final double[][] _SAMPLES = new double[][] {
            { -1.0, 0.0, 0.0 },
            { -1.0, 0.0, 1.0 },
            { -1.0, 1.0, 0.0 },
            { -1.0, 1.0, 1.0 }
    };

    private static final double[] _LABELS = new double[] {
            0.0,
            0.0,
            1.0,
            1.0
    };

    public LogicGateAND()
    {
        super(_SAMPLES, _LABELS);
    }
}
