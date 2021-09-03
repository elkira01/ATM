/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendService;
import java.util.Scanner;
import atm.Main;
import backendService.exceptions.ClientNotFoundException;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author el
 */
public class ClientUpdater {
    
    private Client targetedClient;
    private Main m = new Main();
    
    
    public ClientUpdater(){this.targetedClient = null;}
    
    Scanner sc = new Scanner(System.in);
    ClientHandler ch = new ClientHandler();
    
    
    //Steps procedure for altering a client Name
    public void  changeClientName(int clientID){
        
        ObjectOutputStream oos = null;
        String temp = new String();
        
        try{
            Client client = ch.retrieveClient(clientID);
        ch.deleteClient(clientID);
        
        try{
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/backendService/customers/"+temp.valueOf(clientID))));
        
            m.println("Enter the complete name :");
            client.setClientName(sc.nextLine());
            
            client.setDateModified();
            oos.writeObject(client);
        }catch(IOException io){}
        finally{
            try{
                oos.close();
                m.println(client.toString());
            }catch(IOException io){io.printStackTrace();}
            
        }
       }catch(ClientNotFoundException cne){
        }
        
        
    }
    
    public void  changeClientID(int clientID) throws Exception{
        
        ObjectOutputStream oos = null;
        String temp = new String();
        
        Client client = ch.retrieveClient(clientID);
        ch.deleteClient(clientID);
        
        try{
            m.println("Enter the new ID :");
            client.setID(sc.nextInt());
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/backendService/customers/"+temp.valueOf(client.getID()))));
            
            client.setDateModified();
            oos.writeObject(client);
        }
        finally{
            oos.close();
            m.println(client.toString());
        }
        
    }
}
