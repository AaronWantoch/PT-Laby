package pl.edu.pg.eti.kask.rpg.character.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity for game character. Represents characters basic stats as well as profession and skills.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "characters")
public class Character implements Comparable<Character>, Serializable {

    /**
     * Creature's name.
     */
    @Id
    private String name;

    /**
     * Creature's strength stat. Described power of attack.
     */
    private int strength;

    /**
     * Creature's constitution stat. Described life energy.
     */
    private int constitution;

    /**
     * Creature's charisma stat. Described power of persuasion.
     */
    private int charisma;

    /**
     * Creature's actual health.
     */
    private int health;

    /**
     * Character's background story.
     */
    private String background;

    /**
     * Character's age.
     */
    private int age;

    /**
     * Character's profession (class).
     */
    @ManyToOne
    @JoinColumn(name = "profession")
    private Profession profession;

    /**
     * Character's level.
     */
    private int level;

    /**
     * Character's total experience.
     */
    private int experience;

    @Override
    public int compareTo(Character other) {
        int ret = name == null
                ? (other.name == null ? 0 : 1)
                : name.compareTo(other.name);
        if (ret == 0) {
            ret = profession == null
                    ? (other.profession == null ? 0 : 1)
                    : profession.compareTo(other.profession);
        }
        if (ret == 0) {
            ret = level - other.level;
        }
        return ret;
    }

}
