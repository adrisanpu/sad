import java.io.*;  
import java.net.*;  

public class MySocket extends Socket{
    public String nick;
    public DataOutputStream message; 

    public MySocket(String n,String h,int p) throws IOException{
	super(h,p);
	nick = n;
	message = new DataOutputStream(this.getOutputStream());
    }

    public String getNick(){
	return nick;
    }

    public void send(String line) throws IOException{
	message.writeUTF(line);
	//System.out.print("test1");
    }

}
