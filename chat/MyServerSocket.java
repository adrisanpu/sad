import java.io.*;  
import java.net.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;

public class MyServerSocket extends ServerSocket{
    public HashMap<String,MySocket> clients;
    private final ReentrantLock lock;

    public MyServerSocket(int p) throws IOException{
	super(p);
	clients = new HashMap<String,MySocket>();
	lock = new ReentrantLock();
    }

    public void addClient(String nick, MySocket client){
	lock.lock();
	try{
	    clients.put(nick, client);
	}finally{
	    lock.unlock();
	}
    }

    public void removeClient(String nick){
	lock.lock();
	try{
	    clients.remove(nick);
	}finally{
	    lock.unlock();
	}
    }

    @Override
    public MySocket accept() throws IOException {
	MySocket aSocket = new MySocket();
	try {
	    implAccept(aSocket);
	} catch (IOException e) {
	    aSocket.close();
	    throw e;
	}
	return aSocket;
    }

}
