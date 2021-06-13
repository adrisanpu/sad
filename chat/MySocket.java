import java.io.*;  
import java.net.*;  

public class MySocket extends Socket{
    public String nick;

    public MySocket() throws IOException{
	super();
	nick = "";
    }

    public MySocket(String n,String h,int p) throws IOException{
	super(h,p);
	nick = n;
    }
	
    public String getNick(){
	return nick;
    }

}
