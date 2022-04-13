/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author aaron
 */
public class Client {
    public static void main(String args[])
    {
        try
        {
            Socket socket = new Socket("localhost", 9797);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);
            
            String isReady;
            do
            {
                isReady = (String) ois.readObject();
                System.out.println(isReady);
            }
            while(!isReady.equals("ready"));
            
            System.out.println("Server is ready");
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            int n;
            do
            {
                System.out.println("Give the number of messages");
                n=sc.nextInt();
            } while(n<2);
            oos.writeInt(n);
            oos.flush();
            
            String isReadyForMessages;
            do
            {
                isReadyForMessages = (String) ois.readObject();
            }
            while(!isReadyForMessages.equals("ready for messages"));
            System.out.println("Server ready for messages");
            oos.writeObject(generateRandom());//send array of random elements
            oos.flush();
            
            for(int i=0; i<n; i++)
            {
                
                String content = sc.next();
                Message msg = new Message(i, content);
                oos.writeObject(msg);
                oos.flush();   
            }
            String isFinished;
            do
            {
                isFinished = (String) ois.readObject();
            }
            while(!isFinished.equals("finished"));
            System.out.println("Server finished");
            oos.flush();
            
            oos.close();
            ois.close();
            socket.close();  
        }
        catch (Exception ex) {
            System.err.println(ex);
       }
    }
    
    private static int[] generateRandom()
    {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        return arr;
    }
}
