import java.io.*;  
import java.net.*;  

public class TesterMySocket{

    public static void main(String[] args) {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	try {
	    System.out.print("nick: ");
	    String nick = in.readLine();
	    System.out.print("port: ");
	    int port = Integer.parseInt(in.readLine());
	    MySocket client = new MySocket(nick,"localhost", port);
	    InputThread inputThread = new InputThread(in, client);
	    //OutputThread outputThread = new OutputThread(client.);
	    inputThread.start();
	    //outputThread.start();
	    //client.close();
	} catch (IOException e) { e.printStackTrace(); 
	} //catch (UnknownHostException e) { e.printStackTrace(); }
    }

}
