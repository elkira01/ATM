/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendService;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author el
 */
public class Client implements Serializable {
    
    private String name;
    private int ID;
    private Date dateOfCreation;
    private Date lastModified;
    
    public Client(){}
    
    public Client(int id){
        
        this.ID = id;
    }
    
    public void setClientName(String _name){
    
        this.name  = _name;
    }
    
    public String getClientName(){
        return this.name;
    }
    
    public void setID(int id){this.ID = id;}
    
    public int getID(){
        return this.ID;
    }
    
    @Override
    public String toString(){
        
        return "Name          : "+this.name+"\n"+"ID Number     : "+this.ID+"\n"+"Registred on  : "+this.dateOfCreation+"\n"+"Last modified : "+this.lastModified+"\n\n";
    }
    
    public void setDateCreated(){
        this.dateOfCreation = new Date();
    }
    
    public Date getDateCreated(){
        return this.dateOfCreation;
    }
    
    public void setDateModified(){
        this.lastModified = new Date();
    }
    
    public Date getDateModified(){
        return this.lastModified;
    }
    
}
