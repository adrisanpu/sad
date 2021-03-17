
public class ActionObject extends Object{
    public int action;
    public int finalColumn;
    public char c;    

    public ActionObject(int a){
	super();
	action = a;
    	finalColumn = 0;
    }

    public ActionObject(int a, char typedChar){
	super();
	action = a;
    	finalColumn = 0;
	c = typedChar;
    }
    

    public void setFinalColumn(int f) {
        finalColumn = f;
    }

}
