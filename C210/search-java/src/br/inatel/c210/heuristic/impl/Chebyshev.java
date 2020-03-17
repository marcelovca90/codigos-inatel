package br.inatel.c210.heuristic.impl;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import br.inatel.c210.heuristic.Heuristic;
import br.inatel.c210.model.Node;

public class Chebyshev extends Heuristic
{
    @Override
    public double compute(Node a, Node b)
    {
        return max(abs(a.getX() - b.getX()), abs(a.getY() - b.getY()));
    }
}
