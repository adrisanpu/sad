from model import *
from const import *

class controller:
    def __init__(self, window):
        self.view = window

    #notifies the model which the user's decision (array and sort algorithm)
    def sort_array(self, input_array, algo):
        array = array_to_sort(input_array)
        array.add_observer(self.view)
        if(algo == SELECTION_SORT):
            thread = threading.Thread(target=array.selection_sort)
            thread.start()
        elif(algo == BUBBLE_SORT):
            thread = threading.Thread(target=array.bubble_sort)
            thread.start()
        pass
