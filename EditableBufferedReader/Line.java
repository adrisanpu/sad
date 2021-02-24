
public class Line{
	public String buffer;
	public int cursor;
	public int row;
	
	public Line(){
		buffer = "";
		cursor = 0;
		row = 0;
	}

	public void addChar(char c, int cursor){
		this.buffer.charAt(cursor) = c;
		this.moveCursorRight();
	}

	public void delChar(char c, int cursor){
		this.buffer.charAt(cursor-1) = '';
		this.moveCursorLeft();		
	}
	
	public void moveCursorRight(){
		String[] command = {"/bin/sh", "-c", "\033[1C </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
		this.cursor ++;
	}

	public void moveCursorLeft(){
		String[] command = {"/bin/sh", "-c", "\033[1D </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
		this.cursor --;
	}
}
