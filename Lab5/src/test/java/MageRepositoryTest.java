import org.junit.*;

import java.util.Optional;


public class MageRepositoryTest {
    MageRepository repository;

    @Before
    public void initialize(){
        repository=new MageRepository();
    }

    @Test
    public void find_nonExistent_emptyOptional(){
        Optional<Mage> optionalMage = repository.find("Aaron");
        assert optionalMage.isEmpty();
    }
    @Test
    public void findAndSave_exist_optionalEqualToObject(){
        Mage m = new Mage("Aaron", 5);
        repository.save(m);
        Optional<Mage> optionalMage = repository.find("Aaron");
        assert optionalMage.isPresent();
        assert optionalMage.get() == m;
    }
    @Test(expected = IllegalArgumentException.class)
    public void save_Existent_ThrowError(){
        repository.save(new Mage("Aaron", 5));
        repository.save(new Mage("Aaron", 7));
    }

    @Test
    public void delete_Existent_deleted(){
        repository.save(new Mage("Aaron", 5));
        repository.delete("Aaron");
        Optional<Mage> optionalMage = repository.find("Aaron");
        assert optionalMage.isEmpty();
    }
    @Test(expected = IllegalArgumentException.class)
    public void delete_noExistent_ThrowError(){
        repository.delete("Aaron");
    }
}
