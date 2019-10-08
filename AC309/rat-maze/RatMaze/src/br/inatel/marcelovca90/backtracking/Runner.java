package br.inatel.marcelovca90.backtracking;

import br.inatel.marcelovca90.maze.Maze;
import br.inatel.marcelovca90.maze.Maze4x4;

public class Runner
{
    static final Maze BASE_MAZE = new Maze4x4();
    static final int[][] MAZE = BASE_MAZE.getMaze();
    static final int N = BASE_MAZE.getSize();

    public static void main(String[] args)
    {
        int[][] solution = new int[N][];
        for (int i = 0; i < N; i++)
            solution[i] = new int[N];

        boolean hasSolution = BacktrackingUtils.solveMazeUtil(MAZE, N, 0, 0, solution);

        System.out.println("Solution using Backtracking");
        if (hasSolution)
            printMatrix(solution);
        else
            System.out.print("Solution doesn't exist");
    }

    static void printMatrix(int[][] maze)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(maze[i][j] == 1 ? "." : "#");
            System.out.println();
        }
    }
}
