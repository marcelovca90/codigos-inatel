from algorithms import greedy_search
from problems import sliding_puzzle
import numpy as np

if __name__ == '__main__':
    
    # Creating a start state for the game
    start = np.matrix([[2, 8, 3],[1, 6, 4],[7, 0, 5]])
    print('Start:\n%s' % start)

    # Creating a target state for the game
    target = np.matrix([[1, 2, 3],[8, 0, 4],[7, 6, 5]])
    print('Target:\n%s' % target)
    
    # Creating an object for the problem
    problem = sliding_puzzle.SlidingPuzzle(3)
    
    # Creating an object for the search algorithm
    gs = greedy_search.GreedySearch(problem)

    # Searching for the solution
    solution,visited,steps = gs.search(start,target)
    if solution:
        print('Solution found in %d steps!' % steps)
    else:
        print('Solution not found!')
