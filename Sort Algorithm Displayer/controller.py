from model import *
from const import *

class controller:
    def __init__(self, window):
        self.view = window

    def sort_array(self, input_array, algo):
        array = array_to_sort(input_array)
        if(algo == SELECTION_SORT):
            array.selection_sort()
        elif(algo == BUBBLE_SORT):
            array.bubble_sort()

        return array