/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendService.exceptions;

/**
 *
 * @author el
 */
public class ClientNotFoundException extends Exception{

    /**
     * Creates a new instance of <code>ClientNotFountException</code> without
     * detail message.
     */
    public ClientNotFoundException() {
        System.out.println("The Client you're seeking is missing");
    }

    /**
     * Constructs an instance of <code>CleintNotFountException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
   
}
