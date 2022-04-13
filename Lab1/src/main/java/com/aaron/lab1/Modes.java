/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab1;

import com.aaron.lab1.Workers.Worker;
import com.aaron.lab1.Workers.WorkerComparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author aaron
 */
public class Modes {
    public class NoSortMode implements ModeManager
    {
        @Override
        public Set<Worker> generateSet()
        {
            return new HashSet<>(); 
        }
        
        @Override
        public Map<Worker, Integer> generateMap()
        {
            return new HashMap<>(); 
        }
    }
    
    public class DefaultSortMode implements ModeManager
    {
        @Override
        public Set<Worker> generateSet()
        {
            return new TreeSet<>(); 
        }
        
        @Override
        public Map<Worker, Integer> generateMap()
        {
            return new TreeMap<>(); 
        }
    }
    
    public class AlternativeSortMode implements ModeManager
    {
        
        @Override
        public Set<Worker> generateSet()
        {
            WorkerComparator comparator = new WorkerComparator();
            return new TreeSet<>(comparator); 
        }
        
        @Override
        public Map<Worker, Integer> generateMap()
        {
            WorkerComparator comparator = new WorkerComparator();
            return new TreeMap<>(comparator); 
        }
    }
}
