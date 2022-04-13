import org.apache.commons.lang3.tuple.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImageConverter {
    private List<Pair<String, BufferedImage>> originalImages;
    private List<Pair<String, BufferedImage>> bufferedImages;

    public ImageConverter(){
        originalImages = new ArrayList<>();
        bufferedImages= new ArrayList<>();
    }

    public ImageConverter(List<Path> files){
        originalImages = new ArrayList<>();
        bufferedImages= new ArrayList<>();
        try {
            loadImages(files);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadImages(List<Path> files) throws IOException {
        for (Path file:files) {
            BufferedImage image = ImageIO.read(file.toFile());
            String name = file.getFileName().toString();
            originalImages.add(new MutablePair<String, BufferedImage>(name,image));
        }
    }

    public MutablePair<String, BufferedImage> loadOneImage(Path file){
        try {
            BufferedImage image = ImageIO.read(file.toFile());
            String name = file.getFileName().toString();
            return new MutablePair<String, BufferedImage>(name,image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void bufferImages() {
        for (Pair<String, BufferedImage> imageAndName:originalImages) {
            bufferedImages.add(bufferOneImage(imageAndName));
        }
    }

    public MutablePair<String, BufferedImage> bufferOneImage(Pair<String, BufferedImage> imageAndName) {
        BufferedImage original = imageAndName.getRight();
        BufferedImage image = new BufferedImage(original.getWidth(),
                original.getHeight(),
                original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {
                int rgb = original.getRGB(i, j);
                Color color = new Color(rgb);
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                Color outColor = new Color(blue, red, green);
                int outRgb = outColor.getRGB();
                image.setRGB(i, j, outRgb);
            }
        }
        String name = imageAndName.getLeft();
        return new MutablePair<>(name,image);
    }

    public List<Pair<String, BufferedImage>> getBufferedImages() {
        return bufferedImages;
    }
}
