
import java.lang.*;
import java.io.*;


class EditableBufferedReader extends BufferedReader{

	public EditableBufferedReader(Reader in){
		super(in);
	}

	public void setRaw(){
		String[] command = {"/bin/sh", "-c", "stty raw </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
	}

	public void unsetRaw(){
		String[] command = {"/bin/sh", "-c", "stty -raw </dev/tty"};
		Process process = Runtime.getRuntime().exec(command);
	}

	public void read(){

	}

	public void readLine(){

	}

}
