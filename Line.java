
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
		System.out.print(c);
		this.cursor ++;
	}

	public void delChar() throws IOException{
		this.buffer.delete(this.cursor-1, this.cursor);
		System.out.print("\033[P");
		this.cursor --;
	}
	
	public void moveCursorRight() throws IOException{
		System.out.print("\033[C");
		this.cursor ++;
	}

	public void moveCursorLeft() throws IOException{
		System.out.print("\033[D");
		this.cursor --;
	}

	public void moveCursorBegin() throws IOException{
	}

	public void moveCursorEnd() throws IOException{
	}
}
