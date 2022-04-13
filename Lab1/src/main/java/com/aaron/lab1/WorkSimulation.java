package com.aaron.lab1;


/**
 * Application main class. Contains application main entry point.
 */
import com.aaron.lab1.Modes;
import com.aaron.lab1.Workers.Worker;
import com.aaron.lab1.Workers.WorkerComparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
public class WorkSimulation {

    /**
     * Application entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String mode = args[0]; //1-brak sortowania 2-sortowanie z naturalnym inne - alternatywne
        //mode manager is used to create instances of Set acording to mode
        ModeManager modeManager;
        Modes modes = new Modes();
        //Creating instance of acording to chossen mode
        if(mode.equals("1"))
            modeManager =  modes.new NoSortMode();
        else if(mode.equals("2"))
            modeManager = modes.new DefaultSortMode();
        else
            modeManager = modes.new AlternativeSortMode();
        
        Set<Worker> workersLevel1 = modeManager.generateSet();
        Map<Worker, Integer> workerMap = modeManager.generateMap();
        
        CreateTest(modeManager, workersLevel1);
        
        WriteWorkers(workersLevel1,"-");
        MapWorkers(workersLevel1, workerMap);
        
    }

    private static int MapWorkers(Set<Worker> workers, Map<Worker, Integer> workerMap) {
        int total = 0;
        for(Worker current : workers)
        {
            int numberOfSubordinates = 0;
            
            if(current.getSubordinates()!=null)
            {
                numberOfSubordinates+=MapWorkers(current.getSubordinates(), workerMap) + current.getSubordinates().size();;
            }
            workerMap.put(current, numberOfSubordinates);
            System.out.println(current.toString() + " number of subordinates: " + workerMap.get(current));
            total+=numberOfSubordinates;
        }
        return total;
    }
    
    private static void WriteWorkers(Set<Worker> workers, String pre) {
        for(Worker current : workers)
        {
            System.out.print(pre);
            System.out.println(current);
            if(current.getSubordinates()!=null)
                WriteWorkers(current.getSubordinates(),pre+"-");
        }
    }

    private static void CreateTest(ModeManager modeManager, Set<Worker> workersLevel1) {
        Worker worker1;
        Worker worker2;
        worker2 = new Worker("Marek","Burek","Magazyn",10000,3, modeManager.generateSet());
        worker1 = new Worker("Franciszek","Opalski","Magazyn",6000,3, modeManager.generateSet());
        worker1.getSubordinates().add(new Worker("Adam","Cybulski","Magazyn",3000,0));
        worker1.getSubordinates().add(new Worker("Michal","Iwanowicz","Magazyn",3500,0));
        worker2.getSubordinates().add(worker1);
        worker2.getSubordinates().add(new Worker("Maria","Iwanowicz","Magazyn",4000,2));
        workersLevel1.add(worker2);
        
        workersLevel1.add(new Worker("Bartosz","Nowicki","Sprzedaz",8000,6));
        workersLevel1.add(new Worker("Milosz","Ukluty","Sprzedaz",6000,8));
        
        worker1 = new Worker("Czarek","Czarodziej","IT",6000,3,modeManager.generateSet());
        worker1.getSubordinates().add(new Worker("Pawel","Obczaj","IT",4500,3));
        worker1.getSubordinates().add(new Worker("Marian","Kulka","IT",4000,2));
        workersLevel1.add(worker1);
    }

}
