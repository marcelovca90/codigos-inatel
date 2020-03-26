package br.inatel.c210.heuristic;

import br.inatel.c210.model.Node;

public abstract class Heuristic
{
    public abstract double compute(Node a, Node b);
}
