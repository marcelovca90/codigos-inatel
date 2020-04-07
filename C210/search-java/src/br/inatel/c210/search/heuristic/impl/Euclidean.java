package br.inatel.c210.search.heuristic.impl;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import br.inatel.c210.search.heuristic.Heuristic;
import br.inatel.c210.search.model.Node;

public class Euclidean extends Heuristic
{
    @Override
    public double compute(Node a, Node b)
    {
        return sqrt(pow(a.getX() - b.getX(), 2.0) + pow(a.getY() - b.getY(), 2.0));
    }
}
