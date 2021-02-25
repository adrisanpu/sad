import java.io.*;

class ConsoleWidth{

	public static void main(String[] args){
		ConsoleProcess c = new ConsoleProcess();
		try{
			int cols = c.getConsoleWidth();
			System.out.println(cols);
		}catch (IOException e) { e.printStackTrace(); }
			
	}
}
