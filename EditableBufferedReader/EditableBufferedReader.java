
import java.io.*;
import static java.lang.System.in;


class EditableBufferedReader extends BufferedReader{

    private final static int RIGHT = 7;
    private final static int LEFT = 8;
    private final static int END = 9;
    private final static int BEGIN = 10;
    private final static int DELETE = 11;
    private final static int SUPR = 12;
    private final static int CHANGE_INPUT_MODE = 15;
    public boolean overTypeMode;

    public EditableBufferedReader(Reader in){
	super(in);
	overTypeMode = false;
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
		case 38:	//utilitzo caracter & per suprimir
		    result = SUPR;
		    break;
		case 37:	//utilitzo caracter % per mode insercio/sobre-escriptura
		    result = CHANGE_INPUT_MODE;
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
		
		//System.out.print(maxCols);
		switch(input){
		    case CHANGE_INPUT_MODE:
			if(overTypeMode) overTypeMode = false;
			else overTypeMode = true;
			break;
		    case RIGHT:
			if(l.cursor < l.finalColumn){
			    l.moveCursorRight();
			    System.out.print("\033[C");
			}
			break;
		    case LEFT:
			if(l.cursor > 0){
			    l.moveCursorLeft();
			    System.out.print("\033[D");
			}
			break;
		    case BEGIN:
			System.out.print("\033[0G");
			l.moveCursorBegin();
			break;
		    case END:
			System.out.print("\033["+Integer.toString(l.finalColumn+1)+"G");
			l.moveCursorEnd();
			break;
		    case DELETE:
			l.delChar();
			l.moveCursorLeft();
			/*if(l.cursor == maxCols-1){
				System.out.print("\033[A");
				System.out.print("\033["+Integer.toString(maxCols+1)+"G");
			}*/
			System.out.print("\033[D");
			System.out.print("\033[P");
			break;
		    case SUPR:
			if(l.cursor < l.finalColumn){
			    l.suprChar();
			    System.out.print("\033[C");
			    System.out.print("\033[D");
			    System.out.print("\033[P");
			}
			break;
		    default:
			if(!overTypeMode){
			    System.out.print("\033[@");
			    l.addChar((char)input, overTypeMode);
			    System.out.print((char)input);
			}
			else{
			    l.addChar((char)input, overTypeMode);
			    System.out.print((char)input);
			}
			break;
		}
	    }
        }finally{
	    this.unsetRaw();
	    return l.buffer.toString();
        }
    }
}
