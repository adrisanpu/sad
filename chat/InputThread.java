import java.io.*;  
import java.net.*;  

public class InputThread extends Thread{
    public MySocket socket;

    public InputThread(MySocket s) {
	socket = s;
    }

    @Override
    public void run() {
	try{
	    InputStream input = System.in;
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
	    writer.println(socket.getNick()+ " connected.");
	    String line = "";
            while ((line = reader.readLine()) != null){
	        writer.println(socket.getNick()+": " + line);
            }
	    writer.println(socket.getNick()+" disconnected.");
	} catch (IOException e) { e.printStackTrace(); }
    } 

}
