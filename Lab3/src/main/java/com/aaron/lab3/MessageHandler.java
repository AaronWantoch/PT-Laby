/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab3;

import java.io.*;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class MessageHandler implements Runnable {

    private final Socket clientSocket;
      
  
    // Constructor
    public MessageHandler(Socket s) 
    {
        this.clientSocket = s;
    }
    
    @Override
    public void run() 
    {
        try 
        {
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());;
            oos.writeObject("ready");
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            int n = ois.readInt();
            oos.writeObject("ready for messages");
            oos.flush();
            int array[] = (int[]) ois.readObject();
            for(int i=0; i<n; i++)
            {
                Message msg=(Message)ois.readObject();  
                System.out.println("["+msg.getNumber()+"]" + msg.getContent());
            }
            System.out.print("[");
            for(int number : array)
            {
                System.out.print(number+", ");
            }
            System.out.print("]");
            System.out.println();
            
            oos.writeObject("finished");
            oos.flush();
            oos.close();
            ois.close();
            clientSocket.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
