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
        for i in range(self.length):
            # Find the minimum element in remaining 
            # unsorted array
            min_idx = i
            self.notify(action(SELECTED, i, self.elements)) #notify primera seleccio
            time.sleep(0.8)
            for j in range(i+1, self.length):
                
                if self.elements[min_idx] > self.elements[j]:
                    min_idx = j
                    self.notify(action(SELECTED, j, self.elements))#notify amb quin estas comparant
                    time.sleep(0.8)
                    print("smaller than first selected.")
                    #notify compared
            # Swap the found minimum element with 
            # the first element        

            self.elements[i], self.elements[min_idx] = self.elements[min_idx], self.elements[i]
            self.notify(action(MODIFIED, j, self.elements)) #notify modified
            time.sleep(0.8)
            self.notify(action(COMPARED, i, self.elements))
            time.sleep(0.8)
        self.notify(action(DONE, i, self.elements))#notify done


    # Bubble sort algorithm
    def bubble_sort(self):
        n = len(self.elements)
        # Traverse through all arrayay elements
        for i in range(n-1):
            # range(n) also work but outer loop will repeat one time more than needed.
            if(i != n-1):
                self.notify(action(SELECTED, i, self.elements)) #notify primera seleccio
                time.sleep(0.8)

            # Last i elements are already in place
            for j in range(0, n-i-1):
                self.notify(action(SELECTED, j, self.elements))#notify amb quin estas comparant
                time.sleep(0.8)
                # traversearrayay from 0 to n-i-1
                # Swap if the element found is greater
                # than the next element
                if self.elements[j] > self.elements[j+1] :
                    self.elements[j], self.elements[j+1] = self.elements[j+1], self.elements[j]
                    self.notify(action(MODIFIED, j, self.elements)) #notify modified
                    time.sleep(0.8)
            self.notify(action(COMPARED, n-i-1, self.elements))
            time.sleep(0.8)   
        self.notify(action(DONE, i, self.elements))#notify done     
            
    
    def notify(self, action):
        self.observer.update(action)
        
        
#array = array_to_sort([64, 34, 25, 12, 22, 11, 90])
  
#array.selection_sort()

#print ("Sorted arrayay is:")
#for i in range(array.length):
#   print ("%d" %array.elements[i])