/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaron.lab1;

import com.aaron.lab1.Workers.Worker;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author aaron
 */

public interface ModeManager {
    public Set<Worker> generateSet();

    public Map<Worker, Integer> generateMap();
}
