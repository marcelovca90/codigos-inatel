package br.inatel.marcelovca90.backtracking;

public class BacktrackingUtils
{
    /*
     * A utility function to check if i,j is valid index for N*N maze
     */
    static boolean isSafe(int maze[][], int n, int x, int y)
    {
        // if (i,j outside maze) return false
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
    }

    /*
     * A recursive utility function to solve Maze problem
     */
    static boolean solveMazeUtil(int maze[][], int n, int x, int y, int sol[][])
    {
        // if (i,j is goal) return true
        if (x == n - 1 && y == n - 1)
        {
            sol[x][y] = 1;
            return true;
        }

        // Check if BASE_MAZE[i][j] is valid
        if (isSafe(maze, n, x, y) == true)
        {
            // mark i,j as part of solution path
            sol[x][y] = 1;

            /* Move forward in i direction */
            if (solveMazeUtil(maze, n, x + 1, y, sol))
                return true;

            /*
             * If moving in i direction doesn't give solution then Move down in j direction
             */
            if (solveMazeUtil(maze, n, x, y + 1, sol))
                return true;

            /*
             * If none of the above movements work then BACKTRACK: unmark i,j as part of solution path
             */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }
}
