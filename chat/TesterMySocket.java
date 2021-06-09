import java.io.*;  
import java.net.*;  

public class TesterMySocket{

    public static void main(String[] args) {
	try {
	    String host = args[1];
	    int port = Integer.parseInt(args[2]);
	    MySocket client = new MySocket(args[0],host,port);
	    System.out.println("client connecting to "+host+" in port "+Integer.toString(port));
	    new InputThread(client).start();
	} catch (IOException e) { e.printStackTrace(); 
	} //catch (UnknownHostException e) { e.printStackTrace(); }
    }

}
