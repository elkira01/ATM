/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import backendService.*;
import backendService.exceptions.AccountNotFoundException;
import java.io.*;
import java.util.Scanner;



/**
 *
 * @author el
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main main = new Main();
        AccountHandler ach = new AccountHandler();
        ClientHandler ch = new ClientHandler();
        Client client = new Client(12345);
        client.setClientName("coucou");
        client.setDateCreated();
        client.setDateModified();
        
       /*try{
        ch.saveClient(client);
        }catch(IOException ioi){}*/
        
        Account account = null;
        //account = ach.registerAccount();
        
        try{
        
            main.println(ach.retrieveAccount("1111"));
        }catch(AccountNotFoundException anf){}
        
    }
    
    
    
    
    
    
    public void println(Object obj){
    
        System.out.println(obj);
    }
}
