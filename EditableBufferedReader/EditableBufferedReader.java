
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
						System.out.print("\033[C");
						break;
					case LEFT:
						l.moveCursorLeft();
						System.out.print("\033[D");
						break;
					case BEGIN:
						for(int i = l.cursor; i >= 0; i--){
							System.out.print("\033[D");
						}
						l.moveCursorBegin();
						break;
					case END:
						for(int i = l.cursor; i <= l.finalColumn; i++){
							System.out.print("\033[C");
						}
						l.moveCursorEnd();
						break;
					case DELETE:
						l.delChar();
						l.moveCursorLeft();
						System.out.print("\033[D");
						System.out.print("\033[P");
						break;
					default:
						/*if(l.cursor < l.finalColumn){
							this.unsetRaw();
							String cols = Integer.toString(l.finalColumn-l.cursor);
							//la comanda xterm que veu es CSI[10S (scroll 10 files) no CSI[10SPA
(shift 10 cols right)							System.out.print("\033["+cols+"SPA");
							this.setRaw();
						} */
						l.addChar((char)input);
						System.out.print((char)input);
						break;
				}
			}
		}finally{
			this.unsetRaw();
			return l.buffer.toString();
		}
	}
}
