/*import java.io.*;  
import java.net.*;  

public class OutputThread extends Thread{
    public MyServerSocket serverSocket;

    public OutputThread(MyServerSocket s) {
        serverSocket = s;
    }

    @Override
    public void run() {
	try{
	    InputStream input = socket.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    while ((line = reader.readline()) != null){
	        String text = new String(output.toString());
	        System.out.println("client: " + text);
	    }
	} catch (IOException e) { e.printStackTrace(); }
    } 



}*/
