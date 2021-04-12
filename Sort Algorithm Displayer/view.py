import Gtk
from const import *

class myWindow(Gtk.Window):
    sort_algo = SELECTION_SORT
    controller = controller(self)
    
    def __init__(self):
        Gtk.Window.__init__(self,title="SORT ALGORITHM DISPLAYER")
        
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
        elems.append(elem1)
        disp.pack_start(elem1, True, True, 0)
        elem2 = Gtk.Entry()
        elems.append(elem2)
        disp.pack_start(elem2, True, True, 0)
        elem3 = Gtk.Entry()
        elems.append(elem3)
        disp.pack_start(elem3, True, True, 0)
        elem4 = Gtk.Entry()
        elems.append(elem4)
        disp.pack_start(elem4, True, True, 0)
        elem5 = Gtk.Entry()
        elems.append(elem5)
        disp.pack_start(elem5, True, True, 0)

        
        bottom_menu_1 = Gtk.Box(spacing=10)
        bottom_menu_1.set_homogeneous(False)
        
        title = Gtk.Label(label="Fill the gaps with integer numbers or choose random ones.")
        bottom_menu_1.pack_start(title, True, True, 0)
        
        random_button = Gtk.Button.new_with_label("RANDOM")
        random_button.connect("clicked", self.on_random_button_clicked)
        bottom_menu_1.pack_start(random_button, True, True, 0)
        
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
            state = "on"
            self.sort_algo = algo;
        else:
            state = "off"
        #comunicar algoritme al controlador
        print("algorithm selected", algo, "was turned", state)
        
    def on_random_button_clicked(self, bub_sort):
        print('"random" button was clicked')
        for i in elems:
            if(i.get_text() == null):
                i.set_text(random.randint(0,100))    
        #assignar valors aleatoris a les caixes que queden buides
        
    def on_start_button_clicked (self, bub_sort):
        print('"start" button was clicked, sorting elements with algorithm', self.sort_algo)
        if(len(elems) == ELEMENTS):
            for i in elems:
                input_array.append(i.get_text())
            sorted_array = controller.sort_array(input_array, self.sort_algo);
            j = 0
            for i in elems:
                i.set_text(sorted_array[j]) 
                j++ 
        else
            print('fill all the entries to start.')

        #enviar al controlador el array i l'algorisme
        #sorted_array = controller.sort_array(input_array, algo) 
        #modificar la vista


if __name__ == "__main__":
    window = myWindow()
    window.connect("destroy", Gtk.main_quit)
    window.show_all()
    controller = controller(window)
    Gtk.main()