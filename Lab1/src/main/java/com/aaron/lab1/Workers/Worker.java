/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab1.Workers;

import java.util.Set;

/**
 *
 * @author aaron
 */
public class Worker implements Comparable<Worker> {
    private String name;
    private String surname;
    private String department;
    private int pay;
    private double security;
    private Set<Worker> subordinates = null;
    
    public Worker(String n, String su, String d, int p, double se, Set<Worker> a)
    {
        this(n,su,d,p,se);
        subordinates = a;
    }
    public Worker(String n, String su, String d, int p, double se)
    {
        name=n;
        surname=su;
        department=d;
        pay=p;
        security = se;
    }
    
    @Override
    public boolean equals(Object other)
    {
        if (this == other) {
            return true; //very same object
        }
        if (other == null || getClass() != other.getClass()) {
            return false; //other is null or final classes are different
        }
        
        Worker otherWorker = (Worker) other;
        if(otherWorker.name.equals(name) 
            && otherWorker.surname.equals(surname) 
            && otherWorker.department.equals(department)
            && otherWorker.pay == pay
            && otherWorker.security == security)
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result += surname != null ? surname.hashCode() : 0;
        result += department != null ? department.hashCode() : 0;
        result += pay*149+security*87;
        return result;
   }

    
    @Override
    public int compareTo(Worker other) {
        if(name.compareTo(other.name)!=0)
            return name.compareTo(other.name);
        if(surname.compareTo(other.surname)!=0)
            return name.compareTo(other.name);
        return 0;
    }
    
    public String toString() {
        return name+" "+surname+" "+department+" "+pay+" "+security;
    }
    
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getDepartment()
    {
        return department;
    }
    public int getPay()
    {
        return pay;
    }
    public double getSecurity()
    {
        return security;
    }
    
    public Set<Worker> getSubordinates()
    {
        return subordinates;
    }
}
