import java.io.*;  
import java.net.*;  

public class InputThread extends Thread{
    public BufferedReader in;
    public MySocket socket;

    public InputThread(MySocket s) {
	socket = s;
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
	String line = "";
	try{
	    while ((line = in.readLine()) != null){
		socket.send(line);
	    }
	} catch (IOException e) { e.printStackTrace(); }
    } 

}
