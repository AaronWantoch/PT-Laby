import javax.persistence.*;
import java.util.List;

public class DatabaseManager {
    EntityManager em;
    public DatabaseManager(EntityManager em){
        this.em = em;
    }

    public void addEntity(Mage m){
        em.getTransaction().begin();
        if(em.find(m.getTower().getClass(), m.getTower().getName()) == null)
            em.persist(m.getTower());
        em.persist(m);
        em.getTransaction().commit();
    }
    public void addEntity(Tower t){
        em.getTransaction().begin();
        for(Mage m : t.getMages())
        {
            if(em.find(m.getClass(), m.getName()) == null)
                em.persist(m);
        }
        em.persist(t);
        em.getTransaction().commit();
    }

    public void deleteEntity(Mage m){
        em.getTransaction().begin();
        Tower t = em.find(m.getTower().getClass(), m.getTower().getName());
        t.getMages().remove(m);
        em.remove(m);
        em.getTransaction().commit();
    }
    public void deleteEntity(Tower t){
        em.getTransaction().begin();
        for(Mage m : t.getMages())
        {
            if(em.find(m.getClass(), m.getName()) != null)
                em.remove(m);
        }
        em.remove(t);
        em.getTransaction().commit();
    }

    public void printDatabase(){
        for(Tower t : em.createQuery("SELECT t FROM Tower t", Tower.class).getResultList()) {
            System.out.println(t);
        }
        for(Mage m : em.createQuery("SELECT m FROM Mage m", Mage.class).getResultList()) {
            System.out.println(m);
        }
    }

    //Print mages from tower higher then x and level larger then y
    public void printOnHeightAndLevel(int x, int y) {
        List<Mage> mages= em.createQuery("SELECT m FROM Mage m WHERE m.level > "+y+" AND m.tower IN " +
                "(SELECT t FROM Tower t WHERE t.height > "+x+")", Mage.class).getResultList();
        for(Mage m : mages) {
            System.out.println(m);
        }
    }
    //Print mages with level higher then
    public void printOnLevel(int x) {
        List<Mage> mages= em.createQuery("SELECT m FROM Mage m WHERE m.level > "+x, Mage.class).getResultList();
        for(Mage m : mages) {
            System.out.println(m);
        }
    }

    public Tower getTower(String name) {
        TypedQuery<Tower> t=em.createQuery("SELECT t FROM Tower t WHERE t.name=\'"+ name +"\'", Tower.class);
        if(t.getResultList().size()==0)
            return null;
        return t.getSingleResult();
    }
    public Mage getMage(String name) {
        TypedQuery<Mage> m=em.createQuery("SELECT m FROM Mage m WHERE m.name=\'"+ name +"\'", Mage.class);
        if(m.getResultList().size()==0)
            return null;
        return m.getSingleResult();
    }
}
