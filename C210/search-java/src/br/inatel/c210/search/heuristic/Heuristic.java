package br.inatel.c210.search.heuristic;

import br.inatel.c210.search.model.Node;

public abstract class Heuristic
{
    public abstract double compute(Node a, Node b);
}
