import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Mage")
public class Mage {
    @Getter
    @Setter
    @Column(name = "name")
    @Id
    private String name;

    @Getter
    @Setter
    private int level;

    @ManyToOne
    @Getter
    private Tower tower;

    public Mage(String name, int level, Tower tower) {
        this.name = name;
        this.level = level;
        this.tower = tower;
        tower.addToTower(this);
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", tower=" + tower.getName() +
                '}';
    }
}
