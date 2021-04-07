import java.io.*;  
import java.net.*;  

public class MyServerSocket extends ServerSocket{

    public MyServerSocket(int p) throws IOException{
	super(p);
    }

    @Override
    public MySocket accept() throws IOException {
	MySocket aSocket = new MySocket();
	try {
	    implAccept(aSocket);
	} catch (IOException e) {
	    aSocket.close();
	    throw e;
	}
	return aSocket;
    }

}
