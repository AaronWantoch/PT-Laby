import javax.persistence.*;

public class Test {
    public static void addTestData(EntityManager em) {
        Tower t1 = new Tower("Tower of water", 300);
        Tower t2 = new Tower("Tower of Fire", 600);

        Mage m1 = new Mage("Aaron",4,t1);
        Mage m2 = new Mage("Bartek",99,t1);
        Mage m3 = new Mage("Błażej",1,t1);

        Mage m4 = new Mage("Bogna",50,t2);
        Mage m5 = new Mage("Michał",2,t2);

        em.getTransaction().begin();
        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.persist(m4);
        em.persist(m5);
        em.persist(t1);
        em.persist(t2);
        em.getTransaction().commit();
    }
}
