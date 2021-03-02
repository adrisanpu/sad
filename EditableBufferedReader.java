
import java.io.*;
import static java.lang.System.in;


class EditableBufferedReader extends BufferedReader{

	public final static int RIGHT = 7;
	public final static int LEFT = 8;
	public final static int END = 9;
	public final static int BEGIN = 10;
	public final static int DELETE = 11;

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
		int ch, result = 0;
		try{
			ch = in.read();
			switch(ch){
				case 127:
					result = DELETE;
					break;
				case 60:	//utilitzo caracter < per anar inici
					result = BEGIN;
					break;
				case 62:	//utilitzo caracter > per anar final
					result = END;
					break;
				case 27:	//seq ESC
					if(in.read() == 91){	//seq [ 
						int aux = in.read();
						if(aux == 'D') result = LEFT;
						else if(aux == 'C') result = RIGHT;
						else result = 0;
					}
					break;
					
				default:
					result = ch;
					break;

			}
		}catch (IOException e) { e.printStackTrace(); }
		return result;
	}

	@Override
	public String readLine() throws IOException{
		Line l = new Line();
		int input;
		this.setRaw();
		try{
			while ((input = read()) != '\r'){
				//System.out.print(input);
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
