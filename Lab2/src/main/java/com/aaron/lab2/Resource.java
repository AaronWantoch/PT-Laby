/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab2;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author aaron
 */
public class Resource {
    private LinkedList<Integer> numbers;
    public Resource()
    {
        numbers = new LinkedList<>();
    }
    
    public synchronized void putNumber(int n)
    {
        numbers.add(n);
        notifyAll();
    }
    
    public synchronized int getNumber() throws InterruptedException
    {
        while(numbers.isEmpty())
            wait();
        int n=numbers.getFirst();
        numbers.remove(0);
        return n;
    }
    
    public boolean isCompleted()
    {
        return numbers.isEmpty();
    }
    
}
