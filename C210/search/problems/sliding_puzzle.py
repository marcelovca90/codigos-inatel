import numpy as np

class SlidingPuzzle(object): 
    '''
    This class implements an sliding puzzle problem of arbitrary size.
    '''

    def __init__(self,num_blocks):
        '''
        Constructor
        Any instance of this class must receive a ``num_blocks`` parameter that
        represents the dimensions (i.e. the sides' length) of the puzzle grid.
        '''
        self.num_blocks = num_blocks
                
    def __findZeroPosition(self,state):
        '''
        This method returns the row and column of the ``zero`` (0) element.
        '''
        for i in range(self.num_blocks):
            for j in range(self.num_blocks):
                if state[i,j] == 0:
                    row_index,col_index = i,j
        return row_index,col_index
    
    def EqualityTest(self,current,target): 
        '''
        This method compares and returns True if a given ``current``
        state matches a given ``target`` state, or False otherwise.
        '''
        solution = True 
        for i in range(self.num_blocks):
            if solution == False:
                break
            for j in range(self.num_blocks):
                if current[i,j] != target[i,j]:
                    solution = False
                    break
        return solution
 
    def ExpandSolution(self,current):
        '''
        This method Returns all possible states from a given ``current`` state.
        '''
        
        # Initialize a list that will contain all the expanded states
        newSolutions = [] 
        
        # Find the position (i.e. row and column) of the zero cell, which
        # will be called zero-row and zero-col from now on, respectively
        row,column = self.__findZeroPosition(current)

        # Attempt to move the zero-cell UPWARDS:
        # If the zero-row is greater than zero, the zero-cell can be moved upwards
        # This new state is created and inserted in the future states list
        if row > 0: 
            new_row = row-1
            newSolution = np.copy(current)
            targetBlock = newSolution[new_row,column]
            newSolution[new_row,column] = 0
            newSolution[row,column] = targetBlock
            newSolutions.append(newSolution)

        # Attempt to move the zero-cell DOWNWARDS:
        # If the zero-row is smaller than num_blocks, the zero-cell can be moved downwards
        # This new state is created and inserted in the future states list
        if row < self.num_blocks-1: 
            new_row = row+1
            newSolution = np.copy(current)
            targetBlock = newSolution[new_row,column]
            newSolution[new_row,column] = 0
            newSolution[row,column] = targetBlock
            newSolutions.append(newSolution)

        # Attempt to move the zero-cell to the LEFT:
        # If the zero-col is greater than zero, the zero-cell can be moved left
        # This new state is created and inserted in the future states list
        if column > 0: 
            new_col = column-1
            newSolution = np.copy(current)
            targetBlock = newSolution[row,new_col]
            newSolution[row,new_col] = 0
            newSolution[row,column] = targetBlock
            newSolutions.append(newSolution)         

        # Attempt to move the zero-cell to the RIGHT:
        # If the zero-col is smaller than num_blocks, the zero-cell can be moved right
        # This new state is created and inserted in the future states list
        if column < self.num_blocks-1:
            new_col = column+1
            newSolution = np.copy(current)
            targetBlock = newSolution[row,new_col]
            newSolution[row,new_col] = 0
            newSolution[row,column] = targetBlock
            newSolutions.append(newSolution)
       
        return newSolutions
