package br.inatel.c210.heuristic;

import br.inatel.c210.model.Node;

public abstract class Heuristic
{
    public abstract double compute(Node a, Node b);

    public int compare(Node a, Node b, Node goal)
    {
        double h1 = this.compute(a, goal);
        double h2 = this.compute(b, goal);
        return (h1 <= h2) ? -1 : +1;
    }
}
