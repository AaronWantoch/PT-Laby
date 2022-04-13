import lombok.*;

import javax.persistence.*;
import java.util.*;

@EqualsAndHashCode
@Entity
public class Tower {
    @Getter
    @Setter
    @Id
    private String name;
    @Getter
    @Setter
    private int height;

    @Getter
    @OneToMany(mappedBy = "tower")
    private List<Mage> mages;

    public Tower(){
        mages = new ArrayList<>();
    }
    public Tower(String n, int h){
        mages = new ArrayList<>();
        name = n;
        height = h;
    }

    public void addToTower(Mage m) {
        mages.add(m);
    }
    public String toString() {
        return "Tower{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", Number of mages=" + mages.size() +
                '}';
    }
}
