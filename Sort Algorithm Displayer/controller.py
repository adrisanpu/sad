
class controller
	def __init__(self, window):
        self.view = window

    def sort_array(self, input_array, algo):
    	array = array_to_sort(input_array)
        if(algo == const.SELECTION_SORT):
        	array.selection_sort()


        return array