package br.inatel.marcelovca90.graph;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;

import br.inatel.marcelovca90.maze.Maze;
import br.inatel.marcelovca90.maze.Maze4x4;

public class Runner
{
    static final Maze BASE_MAZE = new Maze4x4();
    static final int[][] MAZE = BASE_MAZE.getMaze();
    static final int N = BASE_MAZE.getSize();

    public static void main(String[] args)
    {
        Graph<Point, DefaultEdge> graph = GraphUtils.buildGraphFromMaze(MAZE, N);

        System.out.println("Solution using Breadth-first Search");
        printMatrix(GraphUtils.solveUsingBFS(graph, N));

        System.out.println();

        System.out.println("Solution using Depth-first Search");
        printMatrix(GraphUtils.solveUsingDFS(graph, N));
    }

    static void printMatrix(int[][] maze)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(maze[i][j] + "\t");
            System.out.println();
        }
    }
}
