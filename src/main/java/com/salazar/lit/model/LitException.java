/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.model;

/**
 *
 * @author Johnny
 */
public class LitException extends Exception {

    private String message;
   
    
    
    public LitException( String message){
        this.message = message;
        
    }
    public String getMessage(){
        return this.message;
    }
    
} 

