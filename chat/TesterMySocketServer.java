import java.io.*;  
import java.net.*;  

public class TesterMySocketServer{

    public static void main(String[] args) {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	try {
	    int port = Integer.parseInt(args[0]);
	    MyServerSocket server = new MyServerSocket(port);
	    Socket socket = server.accept();
	    BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    String line = null;
	    while ((line = entrada.readLine()) != null) System.out.println(line);
	    //server.close();
	} catch (IOException e) { e.printStackTrace(); 
	}
    }

}
