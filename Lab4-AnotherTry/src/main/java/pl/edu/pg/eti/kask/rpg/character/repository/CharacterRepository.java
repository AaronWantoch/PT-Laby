package pl.edu.pg.eti.kask.rpg.character.repository;

import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.character.entity.Profession;
import pl.edu.pg.eti.kask.rpg.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Repository for storing {@link Character} entities.
 */
public class CharacterRepository extends JpaRepository<Character, String> {

    public CharacterRepository(EntityManagerFactory emf) {
        super(emf, Character.class);
    }

    public List<Character> findAllCharactersByProfession(Profession profession) {
        EntityManager em = getEmf().createEntityManager();
        List<Character> characters = em.createQuery("select c from Character c where c.profession = :profession", Character.class)
                .setParameter("profession", profession)
                .getResultList();
        em.close();
        return characters;
    }

}
