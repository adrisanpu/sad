import java.io.*;  
import java.net.*;  

public class ServerThread extends Thread{
    public MySocket client;
    public MyServerSocket server;

    public ServerThread(MySocket c, MyServerSocket s) {
	client = c;
	server = s;
    }

    @Override
    public void run() {
	try{
	    OutputStream output = new DataOutputStream(client.getOutputStream());
	    PrintWriter writer = new PrintWriter(output, true);
	    InputStream input = client.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    String line = "";
	    String[] data = null;
            while ((line = reader.readLine()) != null){
		data = line.split(":");
		if(data[0] == "connected") server.addClient(data[1],client); //afegir al diccionari data[1] = client;
		else if(data[0] == "disconnected") server.removeClient(data[1]);//treure del diccionari data[1] = client;
	        else{
		    System.out.println(line); //escriure missatge
		    writer.println(line);
            }
	} catch (IOException e) { e.printStackTrace(); }
    } 
}
