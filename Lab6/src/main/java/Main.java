import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        //FileManager fm = new FileManager("./images");
        //ImageConverter ic = new ImageConverter(fm.getFiles());
        //ic.bufferImages();

        //fm.saveImages(ic.getBufferedImages(), "./buffered");

        FileManager fm2 = new FileManager("./images");
        ImageConverter ic2 = new ImageConverter();
        ForkJoinPool pool = new ForkJoinPool(6);
        long time = System.currentTimeMillis();
        try {
            pool.submit(() -> fm2.getFiles().stream().parallel()
                    .map(ic2::loadOneImage)
                    .map(ic2::bufferOneImage)
                    .forEach(e -> fm2.saveSingleImage("buffered", e))).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - time);

}
}
