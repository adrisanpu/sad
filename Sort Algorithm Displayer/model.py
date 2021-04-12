import sys

class array_to_sort:

    def __init__(self, array):
        self.elements = array
        self.length = len(array)

    # Selection sort algoithm
    def selection_sort(self):
        for i in range(self.length):
            # Find the minimum element in remaining 
            # unsorted arrayay
            min_idx = i
            for j in range(i+1, self.length):
                if self.elements[min_idx] > self.elements[j]:
                    min_idx = j
            # Swap the found minimum element with 
            # the first element        
            self.elements[i], self.elements[min_idx] = self.elements[min_idx], self.elements[i]


    # Bubble sort algoithm
    def bubble_sort(self):
        n = len(self.elements)
        # Traverse through all arrayay elements
        for i in range(n-1):
        # range(n) also work but outer loop will repeat one time more than needed.
      
            # Last i elements are already in place
            for j in range(0, n-i-1):
                # traversearrayay from 0 to n-i-1
                # Swap if the element found is greater
                # than the next element
                if self.elements[j] > self.elements[j+1] :
                    self.elements[j], self.elements[j+1] = self.elements[j+1], self.elements[j]
  

array = array_to_sort([64, 34, 25, 12, 22, 11, 90])
  
array.selection_sort()

print ("Sorted arrayay is:")
for i in range(array.length):
    print ("%d" %array.elements[i])
