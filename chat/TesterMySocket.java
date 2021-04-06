import java.io.*;  
import java.net.*;  

public class TesterMySocket{

    public static void main(String[] args) {
	try {
	    String host = args[1];
	    int port = Integer.parseInt(args[2]);
	    MySocket client = new MySocket(args[0],host,port);
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String line = "";
	    while ((line = in.readLine()) != null){
		client.send(line);
	    }

	    /*
	    InputThread inputThread = new InputThread(client);
	    //OutputThread outputThread = new OutputThread(client.);
	    inputThread.start();
	    //outputThread.start();
	    //client.close();
	    */
	} catch (IOException e) { e.printStackTrace(); 
	} //catch (UnknownHostException e) { e.printStackTrace(); }
    }

}
