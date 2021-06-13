import java.io.*;  
import java.net.*;  

public class InputThread extends Thread{
    public MySocket client;

    public InputThread(MySocket c) {
	client = c;
    }

    @Override
    public void run() {
	try{
	    //sortida de client al servidor
	    OutputStream output = new DataOutputStream(client.getOutputStream());
	    PrintWriter writer = new PrintWriter(output, true);
            //entrada de teclat al client	
	    InputStream input = System.in;
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    //avisa servidor de connexio
	    writer.println("connected:"+client.getNick());
            //enviament de missatges a servidor
	    String line = "";
            while ((line = reader.readLine()) != null){
	        writer.println(client.getNick()+": " + line);
            }
	    //avisa desconnexio a servidor
	    writer.println("disconnected:"+client.getNick());
	} catch (IOException e) { e.printStackTrace(); }
    } 

}
