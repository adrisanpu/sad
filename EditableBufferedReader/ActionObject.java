
public class ActionObject extends Object{
    public int action;
    public int finalColumn;

    public ActionObject(int a){
	super();
	action = a;
    finalColumn = 0;
    }

    public void setFinalColumn(int f) {
        finalColumn = f;
    }
}
