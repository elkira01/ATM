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
public class ClientHandler {
    
    protected Client targetedClient;
    private Main main = new Main();
    
    /**
     *
     * @param cl
     */
    public ClientHandler(){this.targetedClient = null;}
    
    public Client getTarget(){return this.targetedClient;}
    
   
    
    //Procedure to create a new client, return a new Client object
    public Client registerClient(){
    
        Scanner sc = new Scanner(System.in);
        this.targetedClient = new Client();
        
        //creation steps
        main.println("---- ADDING A NEW CLIENT ---- \n");
        
        main.println("Enter the new client name :");
        this.targetedClient.setClientName(sc.nextLine());
        
        main.println("Enter the new client ID number :");
        this.targetedClient.setID(sc.nextInt());
        this.targetedClient.setDateCreated();
        
        try{
            saveClient(this.targetedClient);
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            main.println(this.targetedClient.toString());
        }
        
        return this.targetedClient;
    }
    
    public void saveClient(Client client) throws IOException{
        
        ObjectOutputStream oos = null;
        String temp = new String();
        
        try{
            
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/backendService/customers/"+temp.valueOf(client.getID()))));
            oos.writeObject(client);
        
        }finally{
            oos.close();
        }
    }
    
    //Procedure to for extracting a given Client object from its data file
    public Client retrieveClient(int clientID) throws ClientNotFoundException {
    
        Client client = null;
        ObjectInputStream ois = null;
        String temp = new String();
        
        try{
        
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/backendService/customers/"+temp.valueOf(clientID))));
            client = (Client)ois.readObject();
            
        
        }catch(ClassNotFoundException cnf){cnf.printStackTrace();
        
        }catch(FileNotFoundException fnf){ throw new ClientNotFoundException();
        
        }catch(IOException io){io.printStackTrace();
        
        }finally{
            try{if(ois != null)ois.close();}catch(IOException ioe){ioe.printStackTrace();}
            
        }
       
        
        return client;
    }
    
    //Procedure to deleted a given client object from the system, it return TRUE if it was successfull
    //It might be updated in the future
    public boolean deleteClient(int clientID){
        
        File file = null;
        String temp = new String();
        boolean status = true;
        
        file = new File("src/backendService/customers/"+temp.valueOf(clientID));
        status = file.delete();
        
        return status;
    }
    
    
}
