package br.inatel.c210.search.model;

public class Node
{
    private String label;
    private double x;
    private double y;

    public String getLabel()
    {
        return label;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Node other = (Node) obj;
        if (label == null)
        {
            if (other.label != null) return false;
        }
        else if (!label.equals(other.label)) return false;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Node [label=" + label + ", x=" + x + ", y=" + y + "]";
    }

    public Node(String label, double x, double y)
    {
        super();
        this.label = label;
        this.x = x;
        this.y = y;
    }
}
