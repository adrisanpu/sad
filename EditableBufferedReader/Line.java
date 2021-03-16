import java.lang.StringBuilder;
import java.io.*;
import java.util.Observable;

public class Line extends Observable{
    public StringBuilder buffer;
    public int cursor;
    public int finalColumn;

    public Line(){
	buffer = new StringBuilder("");
	cursor = 0;
	finalColumn = 0;
    }

    public void addChar(char c, boolean overTypeMode) throws IOException{
	if(!overTypeMode) {
	    buffer.insert(cursor, c);
	    finalColumn++;
	} 
	else {
	    if(cursor < finalColumn) buffer.setCharAt(cursor,c);
	    else buffer.insert(cursor, c);
	}
	cursor ++;
	if(cursor > finalColumn) finalColumn = cursor;
    }

    public void delChar() throws IOException{
	if(cursor > 0){
		buffer.delete(cursor-1, cursor);
		finalColumn --;
	}
	
    }

    public void suprChar() throws IOException{
        buffer.delete(cursor, cursor+1);
	finalColumn --;
	
    }
	

    public void moveCursorRight() throws IOException{
	if(cursor < finalColumn){
	    cursor ++;
	    setChanged();
	    notifyObservers(new ActionObject(Constants.RIGHT));	    
	}

    }

    public void moveCursorLeft() throws IOException{
	cursor --;	
    }

    public void moveCursorBegin() throws IOException{
	cursor = 0;
    }

    public void moveCursorEnd() throws IOException{
	cursor = finalColumn;
    }
}

