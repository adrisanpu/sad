import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.*;
import java.io.*;  
import java.net.*;

/**
 * general purpose powerful free layouts:
 * JGoodies' FormLayout
 * MigLayout
 * DesignGridLayout
 */

public class ChatGUI {
    private static MySocket client;
    private static ArrayList<String> users = new ArrayList<>();
    private static JTextField text;
    private static JButton button;
    public static JTextArea messages;
    private static PrintWriter writer;

    private static JList userList;
    private static DefaultListModel usernames;

    public static void createAndShowGUI() {
        TitledBorder titleUsers = new TitledBorder("Users Online");
        titleUsers.setTitleColor(new Color(91, 120, 25));
        usernames = new DefaultListModel();
        userList = new JList(usernames);
        userList.setBorder(titleUsers);

        //Set the look and feel.
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch (Exception e){}
        
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an output JPanel and add a JTextArea(20, 30) inside a JScrollPane
        JPanel out = new JPanel();
        out.setLayout(new BoxLayout(out, BoxLayout.PAGE_AXIS));
        messages = new JTextArea(20,30);
        messages.setEditable(false);
        out.add(new JScrollPane(messages));
        
        // Create an input JPanel and add a JTextField(25) and a JButton
        JPanel inp = new JPanel();
        inp.setLayout(new BoxLayout(inp, BoxLayout.LINE_AXIS));
        text = new JTextField(25);
        button = new JButton("send");
        inp.add(text);
        inp.add(button);
	
	//add actionListener to the button and the entry
	Listener listener = new Listener();
	button.addActionListener(listener);
	text.addActionListener(listener);

        // add panels to main frame
        frame.add(out, BorderLayout.CENTER);
        frame.add(inp, BorderLayout.PAGE_END);
        frame.add(new JScrollPane(userList), BorderLayout.WEST);
        
        //Display the window centered.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

	//new InputThread(client).start();
	try{
		OutputStream output = new DataOutputStream(client.getOutputStream());
		writer = new PrintWriter(output, true);
		writer.println("connected:"+client.getNick());
	} catch (IOException e) { e.printStackTrace(); }
	new OutputGUIThread(client, messages, users).start();
    }

    static class Listener implements ActionListener{
	//makes the function of the inputThread()
	@Override
	public void actionPerformed(ActionEvent event){
		String line = text.getText();
		if(!line.equals("")){
		    String messageToSend = client.getNick()+": " + line;
		    writer.println(messageToSend);
		    messages.append(messageToSend+'\n');
		}
		text.setText("");
	}
    }

    public static void main(String[] args) {
	try {
	    //per executar el client escriure a terminal:
	    // java ChatGUI 'NICK' localhost 'PORT'
	    String host = args[1];
	    int port = Integer.parseInt(args[2]);
	    client = new MySocket(args[0],host,port);
	} catch (IOException e) { e.printStackTrace();} 
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
