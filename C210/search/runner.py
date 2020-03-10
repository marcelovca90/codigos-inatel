from algorithms import greedy_search
from problems import sliding_puzzle
import numpy as np

if __name__ == '__main__':
    
    # Creating a start state for the game
    start = np.matrix([[0, 1],[2, 3]])
    print('Start:\n%s' % start)

    # Creating a target state for the game
    target = np.matrix([[2, 1],[3, 0]])
    print('Target:\n%s' % target)
    
    # Creating an object for the problem
    problem = sliding_puzzle.SlidingPuzzle(2)
    
    # Creating an object for the search algorithm
    gs = greedy_search.GreedySearch(problem)
    
    # Searching for the solution
    solution,visited = gs.search(start,target)
    if solution:
        print('Solution found!')
    else:
        print('Solution not found!')
