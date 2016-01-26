/* Completed by Nathan Smith - 657423*/
/*Chat App*/
/*Main.java*/

package chatclient; //WebService package

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.xml.ws.WebServiceRef;
import chatclient.ChatServerService;
import chatclient.ChatServer;
        
/*Main class*/
public class Main {
    @WebServiceRef(wsdlLocation="http://localhost:8080/WSChatServer/ChatServerService?wsdl")
    
    private JFrame frame;
    private JTextArea myText;
    private static JTextArea otherText;
    private JScrollPane myTextScroll;
    private JScrollPane otherTextScroll;
    private static TextThread otherTextThread;
    private String textString = "";
    public static String userName = ""; //variable to hold the username
    private JTextField nameField; //textfield to enter name
    public String privname = ""; //variable to hold the private username
    private JTextField privMessageField; //variable to enter a private username
    private boolean priv = false; //sets sending a private username to automatically off
    
    private static final int HOR_SIZE = 400;
    private static final int VER_SIZE = 150;
    
    private ChatServerService service;
    private ChatServer port;
    private int id;

    /*Method to create and implement all aspects of the interface*/
    private void initComponents(String host) {
    	frame = new JFrame("Chat Client");
        myText = new JTextArea();
        
        /*Where the text is written*/
        myTextScroll = new JScrollPane(myText);			
        myTextScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            myTextScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myTextScroll.setMaximumSize(
                    new java.awt.Dimension(HOR_SIZE, VER_SIZE));
		myTextScroll.setMinimumSize(new java.awt.Dimension(HOR_SIZE, VER_SIZE));
		myTextScroll.setPreferredSize(new java.awt.Dimension(
                    HOR_SIZE, VER_SIZE));
                
                myText.setEditable(false); //Won't allow text to be entered until a username is entered.

        myText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTyped(evt);
            }
        });
        
        frame.getContentPane().add(myTextScroll, java.awt.BorderLayout.CENTER); //positioned as the middle
        
        /*Where the text is printed/shown */
        otherText = new JTextArea();
        
        otherTextScroll = new JScrollPane(otherText);
        otherText.setBackground(new java.awt.Color(200, 200, 200));
        otherTextScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        otherTextScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        otherTextScroll.setMaximumSize(
            new java.awt.Dimension(HOR_SIZE, VER_SIZE));
        otherTextScroll.setMinimumSize(
            new java.awt.Dimension(HOR_SIZE, VER_SIZE));
        otherTextScroll.setPreferredSize(new java.awt.Dimension(
		    HOR_SIZE, VER_SIZE));
        otherText.setEditable(false);
        
        /*Where all buttons and namefield are positioned*/
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Enter Name: "); //Label for understanding purposes
        namePanel.add(nameLabel);
        nameField = new JTextField(); //Where the username is entered
        nameField.setPreferredSize(new Dimension(100,30));
        namePanel.add(nameField);
        JButton nameButton = new JButton("SUBMIT"); //Button to process the above details
        namePanel.add(nameButton);
        JLabel privMessageLabel = new JLabel("Private User: "); //Label for understanding purposes of private messaging
        namePanel.add(privMessageLabel);
        privMessageField = new JTextField(); //Where a user specifies who they want to send their private message to
        privMessageField.setPreferredSize(new Dimension(100,30));
        privMessageField.setEditable(false); //Will not let the user use this feature until a username is entered
        namePanel.add(privMessageField);
        JButton privMessageButton = new JButton("Private"); //Button to process the above private messaging details 
        namePanel.add(privMessageButton);
        JButton leaveButton = new JButton("Leave"); //Button to process the leaving function. 
        namePanel.add(leaveButton);
       
        /*Action listener for the Name Button - processes the information once the button has been clicked*/
        nameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                nameField.setEditable(false); //once a username has been entered, it cannot be changed until you leave.
                myText.setEditable(true); // this enables the user to enter messages once a username has been entered.
                privMessageField.setEditable(true); // A private message can be sent once a username has been entered.
                userName = nameField.getText(); // stores the username in a variable
            
                /*Calls the SystemStart method with the userName, otherwise it attempts to print the name before it has been entered*/
                SystemStart(userName); 
            }
        });
        
        /*Action listener for the Private Message Button - instructions for when the button has been clicked*/
        privMessageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                privname = privMessageField.getText(); //stores the private message recipient name in a variable
                priv = true; //States that the next message must be sent to only the specified user
            }
        });
            
        /*Action listener for the Leave Button -  instructions for when the leave button has been clicked*/
        leaveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                /*Closes the specific conversation window and informs all other users that they have left*/  
                frame.dispose(); 
                port.talk(userName + " has left");
            }
        });
        
        frame.getContentPane().add(namePanel,java.awt.BorderLayout.NORTH); //Adds the new panel to the top of the frame
        frame.getContentPane().add(otherTextScroll,
            java.awt.BorderLayout.SOUTH); //sets the panel to the bottom of the frame
            
        frame.pack();
        frame.setVisible(true);
    } 
    
    /*Method to start the server with the program - 
    required as a fix to it attempting to print a username before it has been entered.
    This is the called with the userName (which would have been entered)*/
    public void SystemStart(String users){
        try {

            service = new chatclient.ChatServerService();
            port = service.getChatServerPort();
            port.join(userName);
            port.talk(userName + " has joined"); //userName is placed into here, rather than it doing this without anything to read

            otherTextThread = new TextThread(otherText,id, port);
          
            otherTextThread.start();
            
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try {
                        port.leave(userName);
          	  }
          	  catch (Exception ex) {
          	      otherText.append("Exit failed.");
          	  }
          	  System.exit(0);
                }
          });
          
        }
        
        catch (Exception ex) {
            otherText.append("Failed to connect to server.");
        }
    }

    /*Method to read messages*/
    private void textTyped(java.awt.event.KeyEvent evt) {
        
        userName = nameField.getText(); //Gets the name of the userName for printing purposes.
        
        char c = evt.getKeyChar();
        /*Unless the private button is clicked, then send it as a normal message*/
        if(priv == false){
            if (c == '\n'){
                try {
                    port.talk(userName + ":" + textString); //Places the entered userName before the message
        	}
        	catch (Exception ie) {
                    otherText.append("Failed to send message.");
        	}
                    
                textString = "";
            } else {
            textString = textString + c;
        }
    }
        
    /*If the private button is clicked, then send it to the specified user only*/
    if(priv ==true){
        if (c == '\n'){
            try {
                /*Specifies the private user, and then prints a message to them like normal*/
                port.privatename(privname, userName + ":" + textString); 
                priv = false; //Sets it back to normal messaging once sent
        }
        catch (Exception ie) {
            otherText.append("Failed to send message.");
        }
        textString = "";
    }else{
        textString = textString + c;
        }
        
      }
        
   }
    
    /*Main method*/
    public static void main(String[] args) {
    	final String host = "localhost";
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            Main client = new Main();
            public void run() {
                client.initComponents(host);
            }
        });
    	
    }
    
    /*Method to simply get the Username*/
     public static String getUser(){
        return userName;
     }
  }

  class TextThread extends Thread {

    ObjectInputStream in;
    JTextArea otherText;
    int id;
    ChatServer port;
    
    TextThread(JTextArea other, int id, ChatServer port) throws IOException{
        otherText = other;
        this.id = id;
        this.port = port;
    }
    
    public void run() {
        while (true) {
            try {    
                String newText = port.listen(Main.getUser()); //updates the conversation with username and mesasge
                if (!newText.equals("")) {
                    otherText.append(newText + "\n");
                }
                Thread.sleep(1000);
            }
            catch (Exception e) {
                    otherText.append("Error reading from server.");     
            }  
        }
    }
}