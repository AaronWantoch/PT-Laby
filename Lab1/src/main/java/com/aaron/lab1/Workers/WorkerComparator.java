/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab1.Workers;

import java.util.Comparator;

/**
 *
 * @author aaron
 */
public class WorkerComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
       int result=0;
       result += o1.getPay() - o2.getPay();
       if(result!=0)
           return result;
       result+=o1.getSecurity() - o2.getSecurity();
       return result;
    }
    
}
