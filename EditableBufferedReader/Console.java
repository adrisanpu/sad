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
	}
    }






}
