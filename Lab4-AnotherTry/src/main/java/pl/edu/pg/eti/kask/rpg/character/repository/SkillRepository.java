package pl.edu.pg.eti.kask.rpg.character.repository;

import pl.edu.pg.eti.kask.rpg.character.entity.Skill;
import pl.edu.pg.eti.kask.rpg.repository.JpaRepository;

import javax.persistence.EntityManagerFactory;

/**
 * Repository for storing {@link Skill} entities.
 */
public class SkillRepository extends JpaRepository<Skill, String> {

    public SkillRepository(EntityManagerFactory emf) {
        super(emf, Skill.class);
    }

}
