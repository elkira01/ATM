/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendService;
import atm.Main;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author el
 */
public class CheckingAccount extends Account implements Serializable{
    
    public CheckingAccount(String accountnumber){
        
        this.accountHistory = new File("/src/backendService/checkingaccount"+accountnumber);
        this.balance = 0.0;
        this.owner = new Client();
        this.password = "";
        this.accountNumber = accountnumber;
        
    }

    @Override
    void setOwner(Client ow) {
        this.owner = ow;
    }

    @Override
    void setPwd(String pwd) {
        this.password = pwd;
    }
    
    
}
