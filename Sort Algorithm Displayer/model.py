import sys
  
# Selection sort code
def selectionSort(arr)
    for i in range(len(arr)):
        # Find the minimum element in remaining 
        # unsorted array
        min_idx = i
        for j in range(i+1, len(arr)):
            if arr[min_idx] > arr[j]:
                min_idx = j
        # Swap the found minimum element with 
        # the first element        
        arr[i], arr[min_idx] = arr[min_idx], arr[i]


def bubbleSort(arr):
    n = len(arr)
  
    # Traverse through all array elements
    for i in range(n-1):
    # range(n) also work but outer loop will repeat one time more than needed.
  
        # Last i elements are already in place
        for j in range(0, n-i-1):
  
            # traverse the array from 0 to n-i-1
            # Swap if the element found is greater
            # than the next element
            if arr[j] > arr[j+1] :
                arr[j], arr[j+1] = arr[j+1], arr[j]
  
# Driver code to test above
arr = [64, 34, 25, 12, 22, 11, 90]
  
bubbleSort(arr)
  
print ("Sorted array is:")
for i in range(len(arr)):
    print ("%d" %arr[i]),