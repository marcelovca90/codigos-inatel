package br.inatel.c210.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph
{
    private Map<Node, Set<Entry<Node, Double>>> adjacencyList;

    public Graph()
    {
        this.adjacencyList = new HashMap<>();
    }

    public void connect(Node source, Node destination, Double distance)
    {
        this.adjacencyList.putIfAbsent(source, new HashSet<Entry<Node, Double>>());
        this.adjacencyList.get(source).add(new SimpleEntry<>(destination, distance));
    }

    public Set<Node> getNodes()
    {
        return this.adjacencyList.keySet();
    }

    public Set<Entry<Node, Double>> getNeighbors(Node node)
    {
        return this.adjacencyList.get(node);
    }
}
