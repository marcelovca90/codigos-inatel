package br.inatel.marcelovca90.graph;

import java.util.Iterator;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;

public class GraphUtils
{
    public static Graph<Point, DefaultEdge> buildGraphFromMaze(int[][] maze, int n)
    {
        Graph<Point, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                Point start = new Point(i, j);
                graph.addVertex(start);

                if (maze[i][j] == 1)
                {
                    Point end;

                    // forward
                    if (j + 1 < n && maze[i][j + 1] == 1)
                    {
                        end = new Point(i, j + 1);
                        graph.addVertex(end);
                        graph.addEdge(start, end);
                    }

                    // down
                    if (i + 1 < n && maze[i + 1][j] == 1)
                    {
                        end = new Point(i + 1, j);
                        graph.addVertex(end);
                        graph.addEdge(start, end);
                    }
                }
            }
        }

        return graph;
    }

    public static int[][] solveUsingBFS(Graph<Point, DefaultEdge> graph, int n)
    {
        // initialize solution matrix
        int stepCount = 0;
        int[][] solution = createSolutionMatrix(n);

        // run breadth-first search
        for (Iterator<Point> i = new BreadthFirstIterator<>(graph); i.hasNext();)
        {
            Point current = i.next();
            solution[current.i][current.j] = ++stepCount;
        }

        return solution;
    }

    public static int[][] solveUsingDFS(Graph<Point, DefaultEdge> graph, int n)
    {
        // initialize solution matrix
        int stepCount = 0;
        int[][] solution = createSolutionMatrix(n);

        // run depth-first search
        for (Iterator<Point> i = new DepthFirstIterator<>(graph); i.hasNext();)
        {
            Point current = i.next();
            solution[current.i][current.j] = ++stepCount;
        }

        return solution;
    }

    private static int[][] createSolutionMatrix(int n)
    {
        int[][] solution = new int[n][];
        for (int i = 0; i < n; i++)
            solution[i] = new int[n];
        return solution;
    }
}
