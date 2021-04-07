import java.io.*;  
import java.net.*;  

public class TesterMySocketServer{

    public static void main(String[] args) {
	try {
	    int port = Integer.parseInt(args[0]);
	    MyServerSocket server = new MyServerSocket(port);
	    System.out.println("Server is listening on port " + port);
	    while(true){
		MySocket client = server.accept();
		new ServerThread(client).start();
	    }
	/*
	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    String line = reader.readLine();
	    System.out.println(client.getNick());
	
	    BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
	    String line = null;
	    while ((line = entrada.readLine()) != null){
		System.out.println(line);
		//System.out.print("test2");
	    }
	    //server.close();
	    */
	} catch (IOException e) { e.printStackTrace();}
    }
}
