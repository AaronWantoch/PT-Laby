import org.junit.*;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class MageControllerTest {
    MageController mageController;
    MageRepository mr;
    @Before
    public void initialize(){
        mr = mock(MageRepository.class);
        Optional<Mage> mageOptional = Optional.of(new Mage("Aaron",5));

        when(mr.find("Aaron")).thenReturn(mageOptional);
        when(mr.find("Agata")).thenReturn(Optional.empty());

        doNothing().when(mr).delete("Aaron");
        doThrow(IllegalArgumentException.class).when(mr).delete("Agata");

        mageController = new MageController(mr);
    }
    @Test
    public void find_exist_sameText(){
        Mage m1 = new Mage("Aaron",5);
        String m2 = mageController.find("Aaron");
        assert m1.toString().equals(m2);
    }
    @Test
    public void find_noExist_notFound(){
        String m2 = mageController.find("Agata");
        assert m2.equals("not found");
    }

    @Test
    public void delete_exist_done(){
        String m2 = mageController.delete("Aaron");
        assert m2.equals("done");
    }
    @Test
    public void delete_noExist_notFound(){
        String m2 = mageController.delete("Agata");
        assert m2.equals("not found");
    }

    @Test
    public void save_noExist_done(){
        doNothing().when(mr).save(isA(Mage.class));
        String m2 = mageController.save("Agata", "8");
        assert m2.equals("done");
    }
    @Test
    public void save_exist_badRequest(){
        doThrow(IllegalArgumentException.class).when(mr).save(isA(Mage.class));
        String m2 = mageController.save("Aaron", "5");
        assert m2.equals("bad request");
    }
}
