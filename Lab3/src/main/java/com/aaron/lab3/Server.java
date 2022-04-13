/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aaron
 */
public class Server {
    public static void main(String args[])
    {
        try (ServerSocket server = new ServerSocket(9797)) 
        {
            Socket socket = null;
            for(int i=0; true; i++)
            {
                socket=server.accept();
                MessageHandler mh = new MessageHandler(socket);

                Thread th = new Thread(mh);
                th.start();
            }
           // server.close(); 
        } catch (Exception ex) 
        {
            System.err.println(ex);
        }

        
    }

}
