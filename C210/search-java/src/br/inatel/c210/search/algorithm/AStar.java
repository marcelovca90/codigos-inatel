package br.inatel.c210.search.algorithm;

import static java.lang.Double.POSITIVE_INFINITY;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

import br.inatel.c210.search.heuristic.Heuristic;
import br.inatel.c210.search.model.Graph;
import br.inatel.c210.search.model.Node;

public class AStar
{
    // A* finds a path from start to goal.
    // h is the heuristic function. h(n) estimates the cost to reach goal from node n.
    public static List<Node> run(Graph g, Node start, Node goal, Heuristic h)
    {
        // The set of discovered nodes that may need to be (re-)expanded.
        // Initially, only the start node is known.
        // This is usually implemented as a min-heap or priority queue rather than a hash-set.
        Queue<Node> openSet = new PriorityQueue<>(new Comparator<Node>()
        {
            @Override
            public int compare(Node a, Node b)
            {
                Double h1 = h.compute(a, goal);
                Double h2 = h.compute(b, goal);
                return Double.compare(h1, h2);
            }
        });
        openSet.add(start);

        // For node n, cameFrom[n] is the node immediately preceding it on the cheapest path from start
        // to n currently known.
        Map<Node, Node> cameFrom = new HashMap<>();

        // For node n, gScore[n] is the cost of the cheapest path from start to n currently known.
        Map<Node, Double> gScore = new HashMap<>();
        gScore.put(start, 0.0);

        // For node n, fScore[n] := gScore[n] + h(n). fScore[n] represents our current best guess as to
        // how short a path from start to finish can be if it goes through n.
        Map<Node, Double> fScore = new HashMap<>();
        fScore.put(start, h.compute(start, goal));

        while (!openSet.isEmpty())
        {
            // This operation can occur in O(1) time if openSet is a min-heap or a priority queue
            Node current = openSet.element();
            if (current.equals(goal))
            {
                return Graph.reconstructPath(cameFrom, current);
            }
            openSet.remove();

            for (Entry<Node, Double> pair : g.getNeighbors(current))
            {
                // d(current,neighbor) is the weight of the edge from current to neighbor
                // tentative_gScore is the distance from start to the neighbor through current'
                Node neighbor = pair.getKey();
                Double distance = pair.getValue();
                Double tentative_gScore = gScore.getOrDefault(current, POSITIVE_INFINITY) + distance;
                if (tentative_gScore < gScore.getOrDefault(neighbor, POSITIVE_INFINITY))
                {
                    // This path to neighbor is better than any previous one. Record it!
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentative_gScore);
                    fScore.put(neighbor, gScore.getOrDefault(neighbor, POSITIVE_INFINITY) + h.compute(neighbor, goal));

                    if (!openSet.contains(neighbor))
                    {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        // Open set is empty but goal was never reached
        return Collections.emptyList();
    }
}
