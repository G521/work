package Main.usage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
public class myImage {
    public static Image getImage(String path)
    {
        BufferedImage image=null;
        URL uri=myImage.class.getClassLoader().getResource(path);
        try {
            image= ImageIO.read(uri);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println(path+"图片不存在！");
        }
        return image;
    }
}
