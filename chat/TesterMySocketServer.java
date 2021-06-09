import java.io.*;  
import java.net.*;  

public class TesterMySocketServer{

    public static void main(String[] args) {
	try {
	    int port = Integer.parseInt(args[0]);
	    MyServerSocket server = new MyServerSocket(port);
	    System.out.println("Server is listening on port " + port);
	    while(true){
		MySocket client = server.accept();
		new ServerThread(client,server).start();
	    }
	} catch (IOException e) { e.printStackTrace();}
    }
}
