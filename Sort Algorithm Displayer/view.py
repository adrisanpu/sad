import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from gi.repository import Gdk

class myWindow(Gtk.Window):
    def __init__(self):
        Gtk.Window.__init__(self,title="SORT ALGORITHM DISPLAYER")
        
        hbox = Gtk.Box(spacing=20)
        hbox.set_homogeneous(False)
        
        title = Gtk.Label(label="SORT ALGORITHM DISPLAYER")
        hbox.pack_start(title, True, True, 0)
        
        sel_sort = Gtk.Button.new_with_label("SELECTION SORT")
        sel_sort.connect("clicked", self.on_sel_sort_clicked)
        hbox.pack_start(sel_sort, True, True, 0)
        
        bub_sort = Gtk.Button.new_with_label("BUBBLE SORT")
        bub_sort.connect("clicked", self.on_bub_sort_clicked)
        hbox.pack_start(bub_sort, True, True, 0)
        
        self.add(hbox)
        
    def on_sel_sort_clicked(self, sel_sort):
        print('"selection sort" button was clicked')
    def on_bub_sort_clicked(self, bub_sort):
        print('"bubble sort" button was clicked')
        


if __name__ == "__main__":
    window = myWindow()
    window.connect("destroy", Gtk.main_quit)
    window.show_all()
    Gtk.main()
