from queue import LifoQueue
        
class DepthFirstSearch(object):
    '''
    This class implements the depth-first search algorithm.
    '''

    def __init__(self, problem):
        '''
        Constructor
        Any instance of this class must receive a ``problem`` parameter that is responsible
        for controlling the problem evaluation and the next possible solutions.
        This parameter have two mandatory functions:
            - ExpandSolution(current): a function that returns all possible solutions from a
            given ``current`` state.
            - EqualityTest(current,target): a function that evaluates if a given ``current``
            state corresponds to the ``target`` state, i.e., it compares the states.         
        '''
        self.problem = problem
        
    def __isNotIn(self,current_state,visited_states):
        '''
        This method is responsible for checking if a ``current_state`` was already
        visited during search. If true, it is necessary to compare ``current_state``
        to all states in ``visited_states`` list, one by one. In order to compare, 
        the user must provide the ``EqualityTest`` function inside problem object. 
        '''
        Test = True
        for state in visited_states:
            # if state is already in visited_states, return False
            if self.problem.EqualityTest(state,current_state) == True:
                Test = False
                break
        return Test
    
    def search(self,start,target):
        '''
        This method performs the depth-first search, where the order
        of the visited states is controlled by a stack data structure.
        '''

        # create an empty stack
        frontier = LifoQueue()

        # insert ``start`` state in the stack
        frontier.put(start)
        
        # initialize control variables
        solution = False
        visited = []
        visit_count = 0

        # repeat while there are not visited candidate solutions
        while not frontier.empty():
            # take the first candidate solution
            current = frontier.get()
            visited.append(current)
            
            # evaluate is the current state matches the objective
            if self.problem.EqualityTest(current,target) == True:
                # if true, then the search is over
                solution = True
                break
            else:
                visit_count += 1
                print("Visit # %d" % visit_count)
                # expand new candidate solutions from current
                new_solutions = self.problem.ExpandSolution(current)
                # iterate over all expanded solutions
                for next_item in new_solutions:
                    # check if each expanded solution was already visited
                    if self.__isNotIn(next_item,visited) == True:
                        print("%s" % next_item)
                        # if not, add to the queue for evaluation
                        frontier.put(next_item)

        return solution,visited