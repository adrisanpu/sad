from const import *
from action import *
import threading
import time

class array_to_sort:

    def __init__(self, array, obs):
        self.elements = array
        self.length = len(array)
        self.observer = obs

    # Selection sort algorithm
    def selection_sort(self):
        for i in range(self.length-1):
            # Find the minimum element in remaining 
            # unsorted array
            min_idx = i
            for j in range(i+1, self.length):
                self.notify(action(SELECTED, i, j, None))#notify amb quin estas comparant
                time.sleep(SLEEP_TIME)
                if self.elements[min_idx] > self.elements[j]:
                    min_idx = j
                    self.notify(action(FOUND_LOWER, j, None, None))#notify amb quin estas comparant
                    time.sleep(SLEEP_TIME)
                    #notify compared
            # Swap the found minimum element with 
            # the first element        
            self.elements[i], self.elements[min_idx] = self.elements[min_idx], self.elements[i]
            self.notify(action(MODIFIED, i, min_idx, self.elements)) #notify modified
            time.sleep(SLEEP_TIME)
            self.notify(action(COMPARED, i, None, None))
            time.sleep(SLEEP_TIME)
        self.notify(action(DONE, None, None, None))#notify done
        pass


    # Bubble sort algorithm
    def bubble_sort(self):
        n = len(self.elements)
        # Traverse through all arrayay elements
        for i in range(n-1):
            # range(n) also work but outer loop will repeat one time more than needed.
            if(i != n-1):
                # Last i elements are already in place
                for j in range(0, n-i-1):
                    self.notify(action(SELECTED, j, j+1, None))#notify amb quin estas comparant
                    time.sleep(SLEEP_TIME)
                    # traversearrayay from 0 to n-i-1
                    # Swap if the element found is greater
                    # than the next element
                    if self.elements[j] > self.elements[j+1] :
                        self.notify(action(FOUND_LOWER, j+1, None, None)) #notify modified
                        time.sleep(SLEEP_TIME)
                        self.elements[j], self.elements[j+1] = self.elements[j+1], self.elements[j]
                        self.notify(action(MODIFIED, j, j+1, self.elements)) #notify modified
                        time.sleep(SLEEP_TIME)
                self.notify(action(COMPARED, j+1, None, None))
                time.sleep(SLEEP_TIME)   
        self.notify(action(DONE, None, None, None))#notify done
        pass
            
    
    def notify(self, action):
        self.observer.update(action)
        
        
#array = array_to_sort([64, 34, 25, 12, 22, 11, 90])
  
#array.selection_sort()

#print ("Sorted arrayay is:")
#for i in range(array.length):
#   print ("%d" %array.elements[i])