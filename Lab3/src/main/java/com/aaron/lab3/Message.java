/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab3;

import java.io.Serializable;

/**
 *
 * @author aaron
 */
public class Message implements Serializable {
    private int number;
    private String content;
    
    public Message(int number, String content)
    {
        this.number = number; 
        this.content = content;
    }
    //setters and getters
    public void setNumber(int number)
    {
       this.number = number; 
    }
    public void setContent(String content)
    {
       this.content = content; 
    }
    
    public int getNumber()
    {
        return number;
    }
    public String getContent()
    {
        return content;
    }
}
