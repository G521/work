import usage.values;

import javax.swing.*;
import java.awt.*;

public class myFrame extends JFrame {
    Image i;
    public void lanuchFrame()
    {
        this.setSize(values.FrameX,values.FrameY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(0,0);
        new thread().start();
    }
    class thread extends  Thread
    {
        public void run()
        {
            while (true)
            {
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
