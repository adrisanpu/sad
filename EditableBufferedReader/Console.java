import java.util.Observer;
import java.util.Observable;

class Console implements Observer{
    public int maxCols;

    public Console(){
	maxCols = 0;
    }

    @Override
    public void update(Observable o, Object object){
	ActionObject aux = (ActionObject) object;
	switch(aux.action){
	    case Constants.RIGHT:
		System.out.print("\033[C");
		break;
	    case Constants.LEFT:
		System.out.print("\033[D");
		break;
	    case Constants.BEGIN:
		System.out.print("\033[0G");
		break;
	    case Constants.END:
		System.out.print("\033["+Integer.toString(aux.finalColumn+1)+"G");
		break;
	    case Constants.DELETE:
		System.out.print("\033[D");
		System.out.print("\033[P");
		break;
	    case Constants.SUPR:
		System.out.print("\033[C");
		System.out.print("\033[D");
		System.out.print("\033[P");
		break;
	    case Constants.SHIFTCHAR:
		System.out.print("\033[@");
		break;
	    case Constants.TYPECHAR:
		System.out.print(aux.c);
		break;

	}	
    }
}
