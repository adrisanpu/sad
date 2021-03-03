
// s'han de posar els pritns a readLine, line nomes es el model i els metodes han de modificar 
// line, no el terminal.

import java.lang.StringBuilder;
import java.io.*;

public class Line{
	public StringBuilder buffer;
	public int cursor;
	public int finalColumn;
	public int row;
	
	public Line(){
		buffer = new StringBuilder("");
		cursor = 0;
		finalColumn = 0;
		row = 0;
	}

	public void addChar(char c) throws IOException{
		buffer.insert(cursor, c);
		cursor ++;
		if(cursor > finalColumn) finalColumn = cursor;
	}

	public void delChar() throws IOException{
		buffer.delete(cursor-1, cursor);
		finalColumn --;
		
	}
	

	public void moveCursorRight() throws IOException{
		if(cursor == finalColumn){
			addChar(' ');
		}
		moveCursorRight();
	}

	public void moveCursorLeft() throws IOException{
		if(cursor > 0) cursor --;	
	}

	public void moveCursorBegin() throws IOException{
		cursor = 0;
	}

	public void moveCursorEnd() throws IOException{
		cursor = finalColumn;
	}
}
