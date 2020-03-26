package br.inatel.c210.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import br.inatel.c210.model.Graph;
import br.inatel.c210.model.Node;

public class Dijkstra
{
    public static List<Node> run(Graph g, Node start, Node goal)
    {
        Map<Node, Double> dist = new HashMap<>();
        Map<Node, Node> cameFrom = new HashMap<>();

        dist.put(start, 0.0);

        PriorityQueue<Node> Q = new PriorityQueue<>(new Comparator<Node>()
        {
            @Override
            public int compare(Node a, Node b)
            {
                Double d1 = dist.getOrDefault(a, Double.POSITIVE_INFINITY);
                Double d2 = dist.getOrDefault(b, Double.POSITIVE_INFINITY);
                return Double.compare(d1, d2);
            }
        });

        for (Node v : g.getNodes())
        {
            if (!v.equals(start))
            {
                dist.put(v, Double.POSITIVE_INFINITY);
                cameFrom.put(v, null);
            }
            Q.add(v);
        }

        while (!Q.isEmpty())
        {
            Node u = Q.element();
            Q.remove();
            for (Entry<Node, Double> v_entry : g.getNeighbors(u))
            {
                Node v = v_entry.getKey();
                Double length = v_entry.getValue();
                Double alt = dist.get(u) + length;
                if (alt < dist.get(v))
                {
                    dist.put(v, alt);
                    cameFrom.put(v, u);
                }
            }
        }

        return reconstructPath(cameFrom, goal);
    }

    private static List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current)
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
