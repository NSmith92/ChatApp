/* Completed by Nathan Smith - 657423*/
/*Chat App*/
/*ChatServer.java*/

package ChatServer;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.*;


@WebService
public class ChatServer {

    /*Hashtable used for storing the users on the server - used for joining, leaving and private messaging
     - used as an alternative to ArrayLists*/
    private static Hashtable<String,String> serverList = new Hashtable<String,String>();
    
    /*Join method to register the name and message and place it in the server */
    @WebMethod
    public void join(String name){
        
            /*Uses pairs - places the name and an empty messag into the hashtable.
            The server then knows that a user has joined*/
            serverList.put(name, "");
    }
    
    
    /*Method to set the messages from each user*/
    @WebMethod
    public void talk(String message){
        
            /*Loops through each user, and prints each message next to the relevant user */
            Set<String> keys = serverList.keySet(); //used for each user
            for(String user : keys){
                
                serverList.get(user);
                serverList.put(user, message);          
            }
    }
    
    /*Method to print the message for each user,  then return it to nothing and waits for the next one */
    @WebMethod
    public String listen(String name) {
        
          String temp = serverList.get(name); //stored as a variable in order to return it
          serverList.put(name,""); //setting the message to nothing
          return temp;
        
    }
    
    /*Method to remove a user from the server - for Leaving purposes*/
    @WebMethod
    public void leave(String name){
        serverList.remove(name); //Removes a user from the hashtable - no need for int ID's
    }

    /*Method to send a private message to a user.*/
    @WebMethod
    public void privatename(String name, String message){
        serverList.put(name, message); //sends the message to the specified user
    }
}