import java.io.*;  
import java.net.*;  
import java.util.*;

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
	    //entrada de client a servidor
	    InputStream input = client.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    //gestio de missategs que arriben al servidor
	    String line = "";
	    String[] data = null;
            while ((line = reader.readLine()) != null){
		data = line.split(":");
		//afegir client al diccionari
		if(data[0].equals("connected")) server.addClient(data[1],client);
		//treure client del diccionari
		else if(data[0].equals("disconnected")) server.removeClient(data[1]);
	        //mostra el missatge al servidor
	        System.out.println(line);
	        //envia el missatge a tots els altres clients
	        for (Map.Entry<String,MySocket> entry : server.clients.entrySet()) {
		    if(!entry.getKey().equals(data[0])){
		        OutputStream output = new DataOutputStream(entry.getValue().getOutputStream());
    		        PrintWriter writer = new PrintWriter(output, true);
		        writer.println(line);
		    }
	        }	
            }
	} catch (IOException e) { e.printStackTrace(); }
    } 
}
