import org.apache.commons.lang3.tuple.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileManager {
    private List<Path> files;
    public FileManager(String folderName){
        Path source = Path.of(folderName);
        try (Stream<Path> stream = Files.list(source)){
            files = stream.collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveImages(List<Pair<String, BufferedImage>> toSave, String folderName) throws IOException {
        for(Pair<String, BufferedImage> imageAndName:toSave){
            saveSingleImage(folderName, imageAndName);
        }
    }

    public void saveSingleImage(String folderName, Pair<String, BufferedImage> imageAndName) {
        try{
            BufferedImage image= imageAndName.getRight();
            String name = imageAndName.getLeft();
            File outputfile = new File(folderName +"/buffered_"+name);
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public List<Path> getFiles() {
        return files;
    }
}
