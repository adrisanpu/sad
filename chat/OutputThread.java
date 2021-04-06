import java.io.*;  
import java.net.*;  

public class OutputThread extends Thread{
    public MyServerSocket serverSocket;

    public OutputThread(ServerSocket s) {
        serverSocket = s;
    }

    @Override
    public void run() {
	while ((line = serverSocket.getOutputStream()) != null){
	    System.out.println("Server: " + line);
	}
    } 



}
