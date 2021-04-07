import java.io.*;  
import java.net.*;  

public class ServerThread extends Thread{
    public MySocket socket;

    public ServerThread(MySocket s) {
	socket = s;
    }

    @Override
    public void run() {
	try{
	    InputStream input = socket.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    String line = "";
            while ((line = reader.readLine()) != null){
	        System.out.println(line);
            }
	} catch (IOException e) { e.printStackTrace(); }
    } 
}
