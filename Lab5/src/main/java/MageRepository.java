import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class MageRepository {
    private Collection<Mage> collection;

    public MageRepository(){
        collection=new ArrayList<>();
    }

    public Optional<Mage> find(String name) {
        for(Mage m : collection){
            if(m.getName()==name)
                return Optional.of(m);
        }
        return  Optional.empty();
    }
    public void delete(String name) throws IllegalArgumentException {
        Optional<Mage> mageOptional = find(name);
        if(mageOptional.isEmpty())
            throw new IllegalArgumentException();
        collection.remove(mageOptional.get());
    }
    public void save(Mage mage) {
        Optional<Mage> mageOptional = find(mage.getName());
        if(!mageOptional.isEmpty())
            throw new IllegalArgumentException();
        collection.add(mage);
    }
}