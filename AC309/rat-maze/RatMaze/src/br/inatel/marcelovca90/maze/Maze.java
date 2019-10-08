package br.inatel.marcelovca90.maze;

public abstract class Maze
{
    public abstract int[][] getMaze();

    public int getSize()
    {
        int[][] maze = getMaze();
        if (maze.length == maze[0].length)
            return maze.length;
        else
            return Integer.MIN_VALUE;
    };
}
