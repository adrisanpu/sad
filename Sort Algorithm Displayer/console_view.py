from const import *
from controller import *
import random
import time
import subprocess

class consoleView():
    
    def __init__(self):
        self.control = controller(self)
        self.input_array = []
        
    def initialize_window(self):
        print("-----WELCOME TO THE SORT ALGORTITH VISUALIZER-----\n"+
        "    · Selection sort [1]\n"+
        "    · Bubble sort [2]\n")
        correct_input = False
        while correct_input == False:
            print("Choose an algorithm and click enter:", end=' ')
            algo = input()
            if algo.isnumeric() == False or int(algo) > BUBBLE_SORT:
                correct_input = False
            else:
                algo = int(algo)
                correct_input = True
        correct_input = False
        while correct_input == False:
            print("Type numbers separated by blank spaces or type [r/R] for random numbers:")
            numbers = input()
            if numbers.lower() == 'r':
                for i in range(ELEMENTS):
                    self.input_array.append(random.randint(0,100))
                    correct_input = True
            else:
                self.input_array = numbers.split(' ')
                correct_input = True
                for i in self.input_array:
                    if i.isnumeric() == False:
                        correct_input = False
                    else:
                        i = int(i)
        print("The array to sort is: ", end = ' ')
        for i in self.input_array:
            print(i, end=' ')
        print('\n')
        subprocess.call(["stty", "-echo", "raw"])
        self.control.sort_array(self.input_array, algo)
        subprocess.call(["stty", "echo", "-raw"])
        
    
    def update(self, action):
        if(action.event == SELECTED):
            print("\033[36m")
            print("\033A")
            print(action.array[action.widget], end=' ')
            print("\033[0m")
            print("\033A")
            #print(" selected: " + str(action.array[action.widget]))
        elif(action.event == MODIFIED):
            for i in action.array:
                print(i, end=' ')
            
            #print("Order modified:", end=' ')
            #for i in action.array:
            #    print(i, end=' ')
        elif(action.event == COMPARED):
            j = 0
            for i in action.array:
                if(j == action.widget):
                    print("\033[35m")
                    print(i, end=' ')
                    print("\033[0m")
                j += 1
            #print("Compared widget: " + str(action.array[action.widget]))
        elif(action.event == DONE):
            print("\033[32m")
            for i in action.array:
                print(i, end=' ')
            print("\033[0m")
            #print("Finished:", end=' ')
            #for i in action.array:
            #   print(i, end=' ')
        elif(action.event == FOUND_LOWER):
            print("\033[33m")
            j = 0
            for i in action.array:
                if(j == action.widget):
                    print(i, end=' ')
            j += 1
            print("\033[0m")
        time.sleep(SLEEP_TIME)
        pass
    
if __name__ == "__main__":
    window = consoleView()
    window.initialize_window()
