
// s'han de posar els pritns a readLine, line nomes es el model i els metodes han de modificar 
// line, no el terminal.

import java.lang.StringBuilder;
import java.io.*;

public class Line{
	public StringBuilder buffer;
	public int cursor;
	public int row;
	
	public Line(){
		buffer = new StringBuilder("");
		cursor = 0;
		row = 0;
	}

	public void addChar(char c) throws IOException{
		this.buffer.insert(this.cursor, c);
	}

	public void delChar() throws IOException{
		this.buffer.delete(this.cursor-1, this.cursor);
	}
	
	public void moveCursorRight() throws IOException{	
		this.cursor ++;
	}

	public void moveCursorLeft() throws IOException{
		this.cursor --;
	}

	public void moveCursorBegin() throws IOException{
	}

	public void moveCursorEnd() throws IOException{
	}
}
