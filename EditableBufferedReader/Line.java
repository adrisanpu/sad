
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

	public void showLine() throws IOException{
		String[] command = {"/bin/sh", "-c", "\033[M >/dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
		System.out.print(this.buffer.toString());	
	}

	public void addChar(char c) throws IOException{
		this.buffer.insert(this.cursor, c);
		this.moveCursorRight();
	}

	public void delChar() throws IOException{
		this.buffer.delete(this.cursor, 1);
		this.moveCursorLeft();		
	}
	
	public void moveCursorRight() throws IOException{
		String[] command = {"/bin/sh", "-c", "\033[1C >/dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
		this.cursor ++;
	}

	public void moveCursorLeft() throws IOException{
		String[] command = {"/bin/sh", "-c", "\033[1D >/dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
		this.cursor --;
	}

	public void moveCursorBegin() throws IOException{
	}

	public void moveCursorEnd() throws IOException{
	}
}
