/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendService;
import atm.Main;
import backendService.exceptions.*;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author el
 */
public class AccountHandler {
    
    private Main main = new Main();
    private CheckingAccount targetedAccount;

    public AccountHandler(){
        this.targetedAccount = null;
    }
    public Account getTarget(){return this.targetedAccount;}
    
    //Procedure to create a new account, return a new Account object
    public Account registerAccount(){
        Scanner sc = new Scanner(System.in);
        char type = '0';  String str;
        ClientHandler ch = new ClientHandler();
        
        
        
        main.println("--- CREATING A NEW ACCOUNT ---\n\n");
        
        while(type != '1' && type != '2'){
        
            main.println("Which type of account shall it be  : 1- Checking or 2- Saving ?\n");
            str = sc.nextLine(); type = str.charAt(0);


            if(type == '1'){

                main.println("Enter the account number, formed by 10 intergers ..\n");
                String accountNumb = sc.nextLine();
                this.targetedAccount = new CheckingAccount(accountNumb);
                
                main.println("Enter the owner ID ...\n");
                try{
                    
                    this.targetedAccount.setOwner(ch.retrieveClient(sc.nextInt()));
                    sc.nextLine();
                }catch(ClientNotFoundException cne){}
                
                main.println("Enter the account password ... \n");
                this.targetedAccount.setPwd(sc.nextLine());
                
                try{
                    
                    saveAccount(this.targetedAccount);
                    main.println(this.toString());
                }catch(IOException io){
                    io.printStackTrace();
                }
            }else if(type == '2'){
    
            }else{
            
                main.println("WRONG ENTRY, TRY AGAIN ...");
            }
        }
        
        return this.targetedAccount;
    }
    
    public void saveAccount(Account account) throws IOException{
        
        ObjectOutputStream oos = null;
        String temp = new String();
        
        try{
            
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/backendService/checkingaccounts/"+temp.valueOf(account.getNumber()))));
            oos.writeObject(account);
        
        }finally{
            oos.close();
        }
    }
    
    public Account retrieveAccount(String accountNumb) throws AccountNotFoundException {
    
        Account account = null;
        ObjectInputStream ois = null;
        String temp = new String();
        
        try{
        
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/backendService/checkingaccounts/"+accountNumb)));
            account = (CheckingAccount)ois.readObject();
            
        
        }catch(ClassNotFoundException cnf){cnf.printStackTrace();
        
        }catch(FileNotFoundException fnf){ throw new AccountNotFoundException();
        
        }catch(IOException io){io.printStackTrace();
        
        }finally{
            try{if(ois != null)ois.close();}catch(IOException ioe){ioe.printStackTrace();}
            
        }
       
        
        return account;
    }
    
    //Procedure to deleted a given client object from the system, it return TRUE if it was successfull
    //It might be updated in the future
    public boolean deleteAccount(int accountNumb){
        
        File file = null;
        String temp = new String();
        boolean status = true;
        
        file = new File("src/backendService/customers/"+temp.valueOf(accountNumb));
        status = file.delete();
        
        return status;
    }



}
