import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from gi.repository import Gdk

class myWindow(Gtk.Window):
    def __init__(self):
        Gtk.Window.__init__(self,title="SORT ALGORITHM DISPLAYER")
        
        screen = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)
        screen.set_homogeneous(False)
        
        top_menu = Gtk.Box(spacing=10)
        top_menu.set_homogeneous(False)
        
        title = Gtk.Label(label="Choose a sort algorithm:")
        top_menu.pack_start(title, True, True, 0)
        
        sel_sort = Gtk.Button.new_with_label("SELECTION SORT")
        sel_sort.connect("clicked", self.on_sel_sort_clicked)
        top_menu.pack_start(sel_sort, True, True, 0)
        
        bub_sort = Gtk.Button.new_with_label("BUBBLE SORT")
        bub_sort.connect("clicked", self.on_bub_sort_clicked)
        top_menu.pack_start(bub_sort, True, True, 0)
        
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
        
        bottom_menu = Gtk.Box(spacing=10)
        bottom_menu.set_homogeneous(False)
        
        title = Gtk.Label(label="Fill the gaps with integer numbers or choose random ones.")
        bottom_menu.pack_start(title, True, True, 0)
        
        random_button = Gtk.Button.new_with_label("RANDOM")
        random_button.connect("clicked", self.on_random_button_clicked)
        bottom_menu.pack_start(random_button, True, True, 0)
        
        screen.pack_start(top_menu, True, True, 0)
        screen.pack_start(disp, True, True, 0)
        screen.pack_start(bottom_menu, True, True, 0)
        self.add(screen)
        
    def on_sel_sort_clicked(self, sel_sort):
        print('"selection sort" button was clicked')
    def on_bub_sort_clicked(self, bub_sort):
        print('"bubble sort" button was clicked')
    def on_random_button_clicked(self, bub_sort):
        print('"random" button was clicked')
        


if __name__ == "__main__":
    window = myWindow()
    window.connect("destroy", Gtk.main_quit)
    window.show_all()
    Gtk.main()