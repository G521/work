import javax.swing.*;
import java.awt.*;

public class main extends JFrame {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img_path,img_size_X,img_size_X,location_x,location_Y,null);
    }
}
