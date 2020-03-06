'''
Created on Jun 15, 2016

@author: Edielson
'''
import queue
        
class BreadthFirstSearch(object):
    '''
    This class implements the breadth-first search algorithm
    '''

    def __init__(self, problem):
        '''
        Constructor
        Any object instance must receive an ``problem`` parameter that is responsible
        for controlling the problem evaluation and next possible solutions. This parameter
        have two required functions:
            
            ExpandSolution(current): function that returns all possible solutions from 
            ``current`` state
            TestObjective(current,target): function that evaluates if ``current`` state
            corresponds to the ``target`` state 
         
        '''
        self.problem = problem
        
    def __isNotIn(self,current_state,visited_states):
        '''
        This method is responsible for checking if a ``current_state`` was already
        visited during search. In this case is necessary to compare ``current_state``
        with all states in ``visited_states`` list, one by one. In order to perform 
        comparison, user must provide the ``EqualityTest`` function inside problem 
        object. 
         
        '''
        Test=True
        for each_state in visited_states:
            # if state is already in visited_states, return False
            if self.problem.EqualityTest(each_state,current_state) == True:
                Test=False
                break
        return Test    
    
    def search(self,start,target):

        # create an empty queue
        frontier = queue.Queue()

        # insert ``start`` state in the queue
        frontier.put(start)
        
        # initialize control variables
        solution = False
        visited = []
        visiting_count=0
        
        # repeat while there are not visited candidate solutions
        while not frontier.empty():
            # take the first candidate solution
            current = frontier.get()
            visited.append(current)
                        
            # evaluate is this is the objective
            if self.problem.ObjectiveTest(current,target) == True:
                # if true, finish search
                solution = True
                break
            else:
                visiting_count+=1
                print("Visiting %d" % visiting_count)
                # expand new candidate solutions from current 
                new_solutions = self.problem.ExpandSolution(current)
                # run over all expanded solutions 
                for next_item in new_solutions:
                    # check if each expanded solution was already visited
                    if  self.__isNotIn(next_item, visited) == True:
                        # if not, add to the queue for evaluation
                        frontier.put(next_item)
                    
        return solution,visited