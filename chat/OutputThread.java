import java.io.*;  
import java.net.*;  

public class OutputThread extends Thread{
    public MySocket client;

    public OutputThread(MySocket c) {
        client = c;
    }

    @Override
    public void run() {
	try{
	    //entrada de servidor a client
	    InputStream input = client.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    //mostra missatges de servidor
	    String line = "";
            while ((line = reader.readLine()) != null) System.out.println(line);
	} catch (IOException e) { e.printStackTrace(); }
    } 



}
