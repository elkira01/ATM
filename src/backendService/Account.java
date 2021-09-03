/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendService;
import java.io.File;
import java.io.Serializable;
/**
 *
 * @author el
 */
public abstract class Account implements Serializable {
    
    protected Client owner;
    protected String password;
    protected String accountNumber;
    protected double balance;
    protected File accountHistory;
    
    public Client getOwner(){return this.owner;}
    
    public String getPwd(){return this.password;}
    
    public String getNumber(){return this.accountNumber;}
    
    public double getBalance(){return this.getBalance();}
    
    public File getHistory(){return this.accountHistory;}
    
    abstract void setOwner(Client ow);
    
    abstract void setPwd(String pwd);
    
    public String toString(){
        
        return "Account Number : "+this.accountNumber+"\n"+"Account Owner  : "+this.owner.getClientName()+"\n"+
                "Owner ID       : "+this.owner.getID()+"\nAccount balance: "+this.balance;
    }
    
    
}
