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
            print("Type numbers separated by blank spaces or type [r/R] for random numbers:", end=' ')
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
        print("\033[1M"+"\033A")
        if(action.event == SELECTED):
            for i in action.array:
                if i == action.array[action.widget_1]: print("\033[36m"+str(i)+ "\033[0m", end=' ')
                elif i == action.array[action.widget_2]: print("\033[36m"+str(i)+ "\033[0m", end=' ')
                else: print(str(i), end=' ')
            #print('\n')
        if(action.event == MODIFIED):
            for i in action.array:
                print("\033[33m"+str(i)+ "\033[0m", end=' ')
            #print('\n')
        if(action.event == COMPARED):
            compared = True
            for i in action.array:
                if(compared): print("\033[1m"+str(i)+"\033[0m", end=' ')
                else: print(str(i), end=' ')
                if i == action.array[action.widget_1]: compared = False
            #print('\n')
        if(action.event == DONE):
            for i in action.array:
                print("\033[32m"+str(i)+"\033[0m", end=' ')
        if(action.event == FOUND_LOWER):
            for i in action.array:
                if(i == action.array[action.widget_1]): print("\033[31m"+str(i)+"\033[0m", end=' ')
                else: print(str(i), end=' ')
            #print('\n')

if __name__ == "__main__":
    window = consoleView()
    window.initialize_window()
