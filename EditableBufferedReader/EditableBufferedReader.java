
import java.io.*;

class EditableBufferedReader extends BufferedReader{

	public EditableBufferedReader(Reader in){
		super(in);
	}

	public void setRaw() throws IOException{
		String[] command = {"/bin/sh", "-c", "stty raw </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
	}

	public void unsetRaw() throws IOException{
		String[] command = {"/bin/sh", "-c", "stty -raw </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
	}

	@Override
	public int read() throws IOException{
		Console console = System.console(); 
		int c = console.reader().read();
		return c;
	}

	@Override
	public String readLine() throws IOException{
		Line l = new Line();
		this.setRaw();
		l.addChar((char)this.read());
		this.unsetRaw();
		return l.buffer;
	}
}
