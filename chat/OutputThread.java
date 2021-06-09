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
	    InputStream input = client.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = client.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
	    String line = "";
            while ((line = reader.readLine()) != null) writer.println(line); //escriure missatge
	} catch (IOException e) { e.printStackTrace(); }
    } 



}
