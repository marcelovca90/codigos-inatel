from queue import Queue
        
class BreadthFirstSearch(object):
    '''
    This class implements the breadth-first search algorithm.
    '''

    def __init__(self, problem):
        '''
        Constructor
        Any instance of this class must receive a ``problem`` parameter that is responsible
        for controlling the problem evaluation and the next possible states.
        This parameter have two mandatory functions:
            - ExpandState(current): a function that returns all possible states from a given
            ``current`` state.
            - EqualityTest(current,target): a function that evaluates if a given ``current``
            state corresponds to the ``target`` state, i.e., it compares the states.
        '''
        self.problem = problem
        
    def __isNotIn(self, current_state, visited_states):
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
    
    def search(self, start, target):
        '''
        This method performs the breadth-first search, where the order
        of the visited states is controlled by a queue data structure.
        '''

        # create an empty queue
        frontier = Queue()

        # insert ``start`` state in the queue
        frontier.put(start)
        
        # initialize control variables
        solution_found = False
        visited_states = []
        visit_count = 0

        # repeat while there are states eligible to be visited
        while not frontier.empty():
            # take the first candidate state
            current = frontier.get()
            visited_states.append(current)
            
            # evaluate is the current state matches the objective
            if self.problem.EqualityTest(current,target) == True:
                # if true, then the search is over
                solution_found = True
                break
            else:
                visit_count += 1
                print("Visit # %d" % visit_count)
                # compute the new possible states given the current state
                new_states = self.problem.ExpandState(current)
                # iterate over the new states
                for state in new_states:
                    # check if each new state was already visited
                    if self.__isNotIn(state,visited_states) == True:
                        print("%s" % state)
                        # if not, add to the queue for evaluation
                        frontier.put(state)

        return solution_found,visited_states