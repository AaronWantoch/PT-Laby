import javax.persistence.*;

public class Main {
    public static void main(String args[]){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager em = factory.createEntityManager();

        DatabaseManager dm = new DatabaseManager(em);
        Test.addTestData(em);
        dm.printDatabase();
        Simulation s = new Simulation();
        s.interactWithUser(dm);
        em.close();
    }
}
