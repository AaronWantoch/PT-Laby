/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab2;

import java.util.HashMap;

/**
 *
 * @author aaron
 */
public class Calculator implements Runnable {
    Resource resource;
    Results result;

    public Calculator(Resource resource, Results result) {
        this.resource = resource;
        this.result = result;
    }
    
    @Override
    public void run() {
        try
        {
            calculate();
        }
        catch(InterruptedException ex)
        {
            if(resource.isCompleted())
                System.out.println("Thread interupted sucesfully");
            else
            {
                System.out.println("Thread interupted unsucesfully");
                ex.printStackTrace();
            }
        }
    }
    
    public synchronized void calculate() throws InterruptedException
    {
        while(true)
        {
            int number = resource.getNumber();
            boolean isPrimary=true;
            for(int i=2; i<number; i++)
            {
                if(number%i==0){
                    isPrimary=false;
                    break;
                }
            }
            result.addResult(number, isPrimary);
            
            if(isPrimary)
                System.out.println("Thread checked " + number + " and it is a primary number");
            else
                System.out.println("Thread checked " + number + " and it is NOT a primary number");
        }
    }
}
