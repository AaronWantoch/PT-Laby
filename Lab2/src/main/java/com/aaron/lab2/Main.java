/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab2;

import java.util.Scanner;
import java.util.Stack;
import java.util.Random;

/**
 *
 * @author aaron
 */
public class Main {
    public static void main(String[] args)
    {
        Stack<Thread> threads = new Stack<>();
        Resource resource = new Resource();
        Results results = new Results();
        Random randGenerator = new Random();
        
        int n = Integer.parseInt(args[0]);
        for(int i=0; i<n; i++)
        {
            Thread thread = new Thread(new Calculator(resource, results));
            threads.add(thread);
            thread.start();
        }
        
        System.out.println("Type number of random numbers to check if you want to end type 0: ");
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            
            int howMany = sc.nextInt();
            if(howMany==0)
                break;
            for(int i=0; i<howMany; i++)
            {
                int number = randGenerator.nextInt(1000000);
                resource.putNumber(number);
            }
            
        }
        while(true)
        {
            if(resource.isCompleted())
                break;
        }
        System.out.println("ALL OF GENERATED NUMBERS: ");
        results.printMap();
        
        for (Thread t : threads) 
            t.interrupt(); 
        
    }
}
