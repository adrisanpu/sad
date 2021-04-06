import java.io.*;  
import java.net.*;  

public class TesterMySocketServer{

    public static void main(String[] args) {
	try {
	    MyServerSocket server = new MyServerSocket(Integer.parseInt(args[0]));
	    MySocket client = server.accept();
	    System.out.println(client.getNick());
	    BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
	    String line = null;
	    while ((line = entrada.readLine()) != null){
		System.out.println(line);
		//System.out.print("test2");
	    }
	    //server.close();
	} catch (IOException e) { e.printStackTrace();}
    }
}
