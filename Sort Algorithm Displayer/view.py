import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from gi.repository import Gdk
from const import *

class myWindow(Gtk.Window):
    sort_algo = SELECTION_SORT
    
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
        
        elem = Gtk.Entry()
        disp.pack_start(elem, True, True, 0)
        elem = Gtk.Entry()
        disp.pack_start(elem, True, True, 0)
        elem = Gtk.Entry()
        disp.pack_start(elem, True, True, 0)
        elem = Gtk.Entry()
        disp.pack_start(elem, True, True, 0)
        elem = Gtk.Entry()
        disp.pack_start(elem, True, True, 0)
        
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
        print("algorithm selected", algo, "was turned", state)
        
    def on_random_button_clicked(self, bub_sort):
        print('"random" button was clicked')
        
    def on_start_button_clicked (self, bub_sort):
        print('"start" button was clicked, sorting elements with algorithm', self.sort_algo)


if __name__ == "__main__":
    window = myWindow()
    window.connect("destroy", Gtk.main_quit)
    window.show_all()
    Gtk.main()