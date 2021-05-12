from const import *
from action import *
import time
import threading

class Observable(object):
    def __init__(self):
        self._observers = set()

    #add an observer to the set
    def add_observer(self, observer):
        self._observers.add(observer)

    #remove an observer from the set
    def remove_observer(self, observer):
        self._observers.remove(observer)

    #notify all set observers a change
    def notify_observers(self, event):
        for observer in self._observers:
            observer.update(self, event)
        time.sleep(SLEEP_TIME)
            

class array_to_sort(Observable):

    def __init__(self, array, *args, **kargs):
        self.elements = array
        self.length = len(array)
        Observable.__init__(self, *args, **kargs)

    # Selection sort algorithm
    def selection_sort(self):
        for i in range(self.length-1):
            # Find the minimum element in remaining 
            min_idx = i
            for j in range(i+1, self.length):
                #notify two elements selected
                self.notify_observers(action(SELECTED, i, j, self.elements))
                if self.elements[min_idx] > self.elements[j]:
                    min_idx = j
                    #notify new minimum element found
                    self.notify_observers(action(FOUND_LOWER, j, None, self.elements))        
            # Swap the found minimum element with the first element        
            self.elements[i], self.elements[min_idx] = self.elements[min_idx], self.elements[i]
            #notify the array modification
            self.notify_observers(action(MODIFIED, i, min_idx, self.elements))
            #notify the element that is in its final position
            self.notify_observers(action(COMPARED, i, None, self.elements))
        #notify array has ben sorted
        self.notify_observers(action(DONE, None, None, self.elements))
        pass


    # Bubble sort algorithm
    def bubble_sort(self):
        n = len(self.elements)
        # Traverse through all arrayay elements
        for i in range(n-1):
            # range(n) also work but outer loop will repeat one time more than needed
            if(i != n-1):
                # Last i elements are already in place
                for j in range(0, n-i-1):
                    #notify two elements selected
                    self.notify_observers(action(SELECTED, j, j+1, None))
                    # Swap if the element found is greater than the next element
                    if self.elements[j] > self.elements[j+1] :
                        #notify a grater element has been found
                        self.notify_observers(action(FOUND_LOWER, j+1, None, None))
                        #modify the array
                        self.elements[j], self.elements[j+1] = self.elements[j+1], self.elements[j]
                        #notify the modification
                        self.notify_observers(action(MODIFIED, j, j+1, self.elements))
                #notify the element that is in its final position        
                self.notify_observers(action(COMPARED, j+1, None, None))
        #notify array has ben sorted               
        self.notify_observers(action(DONE, None, None, None))
        pass
            