public class Mage {
    private String name;
    private int level;
    public Mage(String name, int level){
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }
    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}