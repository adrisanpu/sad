import java.io.*;  
import java.net.*;  

public class OutputThread extends Thread{
    public ServerSocket serverSocket;

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
