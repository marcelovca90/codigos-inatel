package br.inatel.c210.search.heuristic.impl;

import static java.lang.Math.abs;

import br.inatel.c210.search.heuristic.Heuristic;
import br.inatel.c210.search.model.Node;

public class Manhattan extends Heuristic
{
    @Override
    public double compute(Node a, Node b)
    {
        return abs(a.getX() - b.getX()) + abs(a.getY() - b.getY());
    }
}
