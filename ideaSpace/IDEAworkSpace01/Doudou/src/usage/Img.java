package usage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
/*
这个类就是获取图片的工具类
 */
public class Img {
    public static Image getImg(String path){
        Image img=null;
        try {
            URL url= Img.class.getClassLoader().getResource(path);
             img= ImageIO.read(url);
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return img;
    }
}
