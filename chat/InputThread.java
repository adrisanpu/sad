import java.io.*;  
import java.net.*;  

public class InputThread extends Thread{
    public BufferedReader in;
    public MySocket socket;

    public InputThread(BufferedReader i, MySocket s) {
	socket = s;
        in = i;
    }

    @Override
    public void run() {
	try{
	    socket.send("holaa!");
	} catch (IOException e) { e.printStackTrace(); }
	/*
	String line = "";
	try{
	    while ((line = in.readLine()) != null){
		socket.send(line);
	    }
	} catch (IOException e) { e.printStackTrace(); }
	*/
    } 

}
