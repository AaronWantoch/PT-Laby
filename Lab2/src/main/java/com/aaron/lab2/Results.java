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
public class Results {
    private HashMap<Integer, Boolean> results;
    
    public Results()
    {
        results = new HashMap<>();
    }
        
    public void printMap()
    {
        results.forEach((k, v) -> {
            if(v)
                System.out.println("The number " + k + " is a primary number");
            else
                System.out.println("The number " + k + " is NOT a primary number");
        });
    } 
    
    public synchronized void addResult(Integer number, Boolean is)
    {
        results.put(number,is);
    }
}
