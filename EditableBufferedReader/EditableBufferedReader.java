
import java.io.*;
import static java.lang.System.in;


class EditableBufferedReader extends BufferedReader{

	public final static int RIGHT = 0;
	public final static int LEFT = 1;
	public final static int END = 2;
	public final static int BEGIN = 3;
	public final static int DELETE = 4;

	public EditableBufferedReader(Reader in){
		super(in);
	}

	public void setRaw() throws IOException{
		String[] command = {"/bin/sh", "-c", "stty -echo raw </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
	}

	public void unsetRaw() throws IOException{
		String[] command = {"/bin/sh", "-c", "stty echo cooked </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
	}

	@Override
	public int read() throws IOException{
		int ch;
		do {
			ch = in.read();
		} while (ch != '\r');
		return ch;
	}

	@Override
	public String readLine() throws IOException{
		Line l = new Line();
		int input;
		this.setRaw();
		try{
			while ((input = read()) != '\r'){
				switch(input){
					case RIGHT:
						l.moveCursorRight();
						break;
					case LEFT:
						l.moveCursorLeft();
						break;
					case BEGIN:
						l.moveCursorBegin();
						break;
					case END:
						l.moveCursorEnd();
						break;
					case DELETE:
						l.delChar();
						break;
					default:
						l.addChar((char)input);
						break;
				}
			}
		}finally{
			this.unsetRaw();
			return l.buffer.toString();
		}
	}
}
