import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from gi.repository import Gdk
from const import *
import random
from controller import *
from styles import css


class myWindow(Gtk.Window):
    sort_algo = SELECTION_SORT
    elems = []
    
    def __init__(self):
        Gtk.Window.__init__(self,title="SORT ALGORITHM DISPLAYER")

        #add styles to screen
        screen = Gdk.Screen.get_default()
        provider = Gtk.CssProvider()
        style_context = Gtk.StyleContext()
        style_context.add_provider_for_screen(screen, provider, Gtk.STYLE_PROVIDER_PRIORITY_APPLICATION)
        provider.load_from_data(css)
        
        #add widgets and event handlers
        screen = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)
        screen.set_homogeneous(False)
        
        top_menu = Gtk.Box(spacing=10)
        top_menu.set_homogeneous(False)
        
        title = Gtk.Label(label="Choose a sort algorithm:")
        top_menu.pack_start(title, True, True, 0)
        
        sel_sort = Gtk.RadioButton.new_with_label_from_widget(None, "SELECTION SORT")
        sel_sort.connect("toggled", self.on_button_toggled, SELECTION_SORT)
        top_menu.pack_start(sel_sort, False, False, 0)
        
        bub_sort = Gtk.RadioButton.new_with_mnemonic_from_widget(sel_sort, "BUBBLE SORT")
        bub_sort.connect("toggled", self.on_button_toggled, BUBBLE_SORT)
        top_menu.pack_start(bub_sort, False, False, 0)
        
        disp = Gtk.Box(spacing=10)
        disp.set_homogeneous(False)
        
        elem1 = Gtk.Entry()
        self.elems.append(elem1)
        disp.pack_start(elem1, True, True, 0)
        elem2 = Gtk.Entry()
        self.elems.append(elem2)
        disp.pack_start(elem2, True, True, 0)
        elem3 = Gtk.Entry()
        self.elems.append(elem3)
        disp.pack_start(elem3, True, True, 0)
        elem4 = Gtk.Entry()
        self.elems.append(elem4)
        disp.pack_start(elem4, True, True, 0)
        elem5 = Gtk.Entry()
        self.elems.append(elem5)
        disp.pack_start(elem5, True, True, 0)
        
        bottom_menu_1 = Gtk.Box(spacing=10)
        bottom_menu_1.set_homogeneous(False)
        
        title = Gtk.Label(label="Fill the gaps with integer numbers or choose random ones.")
        bottom_menu_1.pack_start(title, True, True, 0)
        
        random_button = Gtk.Button.new_with_label("RANDOM")
        random_button.connect("clicked", self.on_random_button_clicked)
        bottom_menu_1.pack_start(random_button, True, True, 0)
        
        clear_button = Gtk.Button.new_with_label("CLEAR")
        clear_button.connect("clicked", self.on_clear_button_clicked)
        bottom_menu_1.pack_start(clear_button, True, True, 0)
        
        bottom_menu_2 = Gtk.Box(spacing=10)
        bottom_menu_2.set_homogeneous(False)
        
        start_button = Gtk.Button.new_with_label("START")
        start_button.connect("clicked", self.on_start_button_clicked)
        bottom_menu_2.pack_start(start_button, True, True, 0)
        
        screen.pack_start(top_menu, True, True, 0)
        screen.pack_start(disp, True, True, 0)
        screen.pack_start(bottom_menu_1, True, True, 0)
        screen.pack_start(bottom_menu_2, True, True, 0)
        self.add(screen)
        
    def on_button_toggled(self, button, algo):
        if button.get_active():
            self.sort_algo = algo;

        
    def on_random_button_clicked(self, random_button):
        for i in self.elems:
            if(i.get_text() == ""):
                i.set_text(str(random.randint(0,100)))
                
    def on_clear_button_clicked(self, clear_button):
        for i in self.elems:
            i.set_text("")
            i.set_name("default")
        
    def on_start_button_clicked (self, start_button):
        input_array = []
        control = controller(self)
        for i in self.elems:
            if(i.get_text().isnumeric()):
                input_array.append(int(i.get_text()))
        control.sort_array(input_array, self.sort_algo)
        
        #sorted_array = control.sort_array(input_array, self.sort_algo)
        #j = 0
        #for i in self.elems:
        #        i.set_text(str(sorted_array.elements[j]))
        #        j = j+1
    
    def update(self, action):
        if(action.event == SELECTED):
            self.elems[action.widget].set_name("selected")
            print("test selected widget" + str(action.widget))
        if(action.event == MODIFIED):
            j = 0
            for i in self.elems:
                i.set_text(str(action.array[j]))
                j = j+1
            print("Order modified")
        if(action.event == COMPARED):
            self.elems[action.widget].set_name("compared")
            print("Compared widget" + str(action.widget))
        if(action.event == DONE):
            for i in self.elems:
                i.set_name("finished")
        time.sleep(SLEEP_TIME) 
        
if __name__ == "__main__":
    window = myWindow()
    window.connect("destroy", Gtk.main_quit)
    window.show_all()
    Gtk.main()