import java.io.*;  
import java.net.*;  

public class TesterMySocketServer{

    public static void main(String[] args) {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	try {
	    System.out.print("port: ");
	    int port = Integer.parseInt(in.readLine());
	    MyServerSocket server = new MyServerSocket(port);
	    Socket socket = server.accept();
	    BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    String mensajeRecibido = "";
            mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);
	    //server.close();
	} catch (IOException e) { e.printStackTrace(); 
	}
    }

}
