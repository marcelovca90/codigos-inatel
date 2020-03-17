import numpy as np
from sklearn.metrics import pairwise_distances

class SlidingPuzzle(object): 
    '''
    This class implements an sliding puzzle problem of arbitrary size.
    '''

    def __init__(self, num_blocks):
        '''
        Constructor
        Any instance of this class must receive a ``num_blocks`` parameter that
        represents the dimensions (i.e. the sides' length) of the puzzle grid.
        '''
        self.num_blocks = num_blocks
                
    def __findPosition(self, state, element):
        '''
        This method returns the row and column of the given ``element``.
        '''
        for i in range(self.num_blocks):
            for j in range(self.num_blocks):
                if state[i,j] == element:
                    row_index,col_index = i,j
                    break
        return row_index,col_index

    def __heurNumElemWrongPosition(self, current, target):
        '''
        This method returns the number of elements in the wrong position.
        '''
        wrong = 0
        for i in range(self.num_blocks):
            for j in range(self.num_blocks):
                if current[i,j] != target[i,j]:
                    wrong += 1
        return wrong

    def __heurTotalManhattanDistance(self, current, target):
        '''
        This method returns the sum of all Manhattan distances.
        '''
        totalDist = 0
        for i in range(self.num_blocks):
            for j in range(self.num_blocks):
                element = current[i,j]
                row,col = self.__findPosition(target, element)
                dist = abs(row - i) + abs(col - j)
                totalDist += dist
        return totalDist

    def __heurTotalCustomDistance(self, current, target, metric_name):
        '''
        This method returns the sum of all custom distances, such as those mentioned in:
        https://scikit-learn.org/stable/modules/generated/sklearn.metrics.pairwise_distances.html
        '''
        totalDist = 0
        for i in range(self.num_blocks):
            for j in range(self.num_blocks):
                element = current[i,j]
                row,col = self.__findPosition(target, element)
                dist = pairwise_distances([[i,j]], [[row,col]], metric=metric_name)
                totalDist += dist
        return totalDist
    
    def EqualityTest(self, current, target): 
        '''
        This method compares and returns True if a given ``current``
        state matches a given ``target`` state, or False otherwise.
        '''
        match = True 
        for i in range(self.num_blocks):
            if match == False:
                break
            for j in range(self.num_blocks):
                if current[i,j] != target[i,j]:
                    match = False
                    break
        return match
 
    def ExpandState(self, current):
        '''
        This method returns all possible states from a given ``current`` state.
        '''
        
        # Initialize a list that will contain all the expanded states
        new_states = []
        
        # Find the position (i.e. row and column) of the zero cell, which
        # will be called zero-row and zero-col from now on, respectively
        row,column = self.__findPosition(current, 0)

        # Attempt to move the zero-cell UPWARDS:
        # If the zero-row is greater than zero, the zero-cell can be moved upwards
        # This new state is created and inserted in the future states list
        if row > 0: 
            new_row = row-1
            new_state = np.copy(current)
            target_block = new_state[new_row,column]
            new_state[new_row,column] = 0
            new_state[row,column] = target_block
            new_states.append(new_state)

        # Attempt to move the zero-cell DOWNWARDS:
        # If the zero-row is smaller than num_blocks, the zero-cell can be moved downwards
        # This new state is created and inserted in the future states list
        if row < self.num_blocks-1: 
            new_row = row+1
            new_state = np.copy(current)
            target_block = new_state[new_row,column]
            new_state[new_row,column] = 0
            new_state[row,column] = target_block
            new_states.append(new_state)

        # Attempt to move the zero-cell to the LEFT:
        # If the zero-col is greater than zero, the zero-cell can be moved left
        # This new state is created and inserted in the future states list
        if column > 0: 
            new_col = column-1
            new_state = np.copy(current)
            target_block = new_state[row,new_col]
            new_state[row,new_col] = 0
            new_state[row,column] = target_block
            new_states.append(new_state)         

        # Attempt to move the zero-cell to the RIGHT:
        # If the zero-col is smaller than num_blocks, the zero-cell can be moved right
        # This new state is created and inserted in the future states list
        if column < self.num_blocks-1:
            new_col = column+1
            new_state = np.copy(current)
            target_block = new_state[row,new_col]
            new_state[row,new_col] = 0
            new_state[row,column] = target_block
            new_states.append(new_state)
       
        return new_states

    def HeuristicCost(self, current, target):
        '''
        This method returns the heuristic cost for the ``current`` state.
        '''
        return self.__heurTotalManhattanDistance(current,target)
