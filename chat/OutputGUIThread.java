import java.io.*;  
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class OutputGUIThread extends Thread{
    public MySocket client;
    public JTextArea messages;
    public ArrayList<String> users;

    public OutputGUIThread(MySocket c, JTextArea m, ArrayList<String> u) {
        client = c;
	    messages = m;
        users = u;
    }

    @Override
    public void run() {
	try{
	    //entrada de servidor a client
	    InputStream input = client.getInputStream();
       	    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    //mostra missatges de servidor
	    String line = "";
            while ((line = reader.readLine()) != null) messages.append(line+'\n');;
	} catch (IOException e) { e.printStackTrace(); }
    } 



}
