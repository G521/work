package usage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
public class myImage {
    private myImage(){}
    public static Image getImage(String path){
        BufferedImage bi=null;
        try {
            File file = new File(path);
            bi = javax.imageio.ImageIO.read(file);
        } catch (IOException e) {
        }
        return bi;
    }
}
