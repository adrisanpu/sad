import java.io.*;
import java.lang.String;

class ConsoleProcess{
	
	public int getConsoleWidth() throws IOException{
		String[] command = new String[] {"/bin/bash", "-c", "tput cols 2> /dev/tty"};
		Process p = Runtime.getRuntime().exec(command);
		return this.getResultInteger(p);
	}

	public int getResultInteger(Process p) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		Integer result = Integer.parseInt(reader.readLine());
		return result;
	}

	public void printProcess(Process p) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
	}
	
}
