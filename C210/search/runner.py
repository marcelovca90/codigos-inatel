from algorithms import breadth_first_search
from problems import sliding_puzzle
import numpy as np

if __name__ == '__main__':
    
    # Creating a start state for the game
    start = np.matrix([[0, 1],[2, 3]])
    print('Start:\n%s' % start)

    # Creating a target state for the game
    target = np.matrix([[1, 0],[2, 3]])    
    print('Target:\n%s' % target)
    
    #C reating an problem object based on FindPath class
    problem = sliding_puzzle.SlidingPuzzle(2)
    
    # Creating an object for breadth first search algorithm for ``FindPath`` problem
    bfs = breadth_first_search.BreadthFirstSearch(problem)    
    
    # Finding solution
    solution,visited = bfs.search(start,target)
    if solution:
        print('Solution found!')
        print('Visited states:\n')
        for state in visited:
            print('%s\n' % state)
        print('Number of visited states: %s\n' % len(visited))
    else:
        print('Solution not found!')        
