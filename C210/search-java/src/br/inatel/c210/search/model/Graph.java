package br.inatel.c210.search.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

    public static List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current)
    {
        List<Node> totalPath = new ArrayList<>();
        totalPath.add(current);

        while (cameFrom.keySet().contains(current))
        {
            current = cameFrom.get(current);
            totalPath.add(current);
        }

        Collections.reverse(totalPath);

        return totalPath;
    }
}
