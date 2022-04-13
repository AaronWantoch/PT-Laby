package pl.edu.pg.eti.kask.rpg.character.repository;

import pl.edu.pg.eti.kask.rpg.character.entity.Profession;
import pl.edu.pg.eti.kask.rpg.repository.JpaRepository;

import javax.persistence.EntityManagerFactory;

/**
 * Repository for storing {@link Profession} entities.
 */
public class ProfessionRepository extends JpaRepository<Profession, String> {

    public ProfessionRepository(EntityManagerFactory emf) {
        super(emf, Profession.class);
    }

}
