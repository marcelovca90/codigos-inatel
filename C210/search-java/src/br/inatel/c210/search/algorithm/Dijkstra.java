package br.inatel.c210.search.algorithm;

import static java.lang.Double.POSITIVE_INFINITY;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.inatel.c210.search.model.Graph;
import br.inatel.c210.search.model.Node;

import java.util.PriorityQueue;

public class Dijkstra
{
    public static List<Node> run(Graph g, Node start, Node goal)
    {
        // keeps the distance from start to a given node
        Map<Node, Double> distanceFromStart = new HashMap<>();

        // keeps the information about which node lead to another node
        Map<Node, Node> cameFrom = new HashMap<>();

        // the distance from start to start is... zero! :-)
        distanceFromStart.put(start, 0.0);

        // creates a priority queue based on distance from start, i.e., the
        // node with the smaller distance from start has the highest priority
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>()
        {
            @Override
            public int compare(Node a, Node b)
            {
                Double d1 = distanceFromStart.getOrDefault(a, POSITIVE_INFINITY);
                Double d2 = distanceFromStart.getOrDefault(b, POSITIVE_INFINITY);
                return Double.compare(d1, d2);
            }
        });

        // initialize maps with vertices in the graph
        for (Node vertex : g.getNodes())
        {
            if (!vertex.equals(start))
            {
                distanceFromStart.put(vertex, POSITIVE_INFINITY);
                cameFrom.put(vertex, null);
            }
            queue.add(vertex);
        }

        // iterate through all nodes
        while (!queue.isEmpty())
        {
            // retrieves the node with minimal distance from start
            Node current = queue.element();
            queue.remove();
            for (Entry<Node, Double> neighbor_entry : g.getNeighbors(current))
            {
                // retrieves the current neighbor and computes the new distance
                Node neighbor = neighbor_entry.getKey();
                Double edgeLength = neighbor_entry.getValue();
                Double candidateDistance = distanceFromStart.get(current) + edgeLength;
                // if this new distance is smaller, then change the current path
                if (candidateDistance < distanceFromStart.get(neighbor))
                {
                    distanceFromStart.put(neighbor, candidateDistance);
                    cameFrom.put(neighbor, current);
                }
            }
        }

        return Graph.reconstructPath(cameFrom, goal);
    }
}
