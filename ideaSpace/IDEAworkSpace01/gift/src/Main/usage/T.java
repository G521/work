package Main.usage;
import Main.drawLove;
import javax.swing.*;
import java.awt.*;
public class T extends JFrame {
    private boolean bg=true;
    drawLove drawLove=new drawLove();
    public T()
    {
    this.setSize(330,380);
    this.setVisible(true);
    this.setResizable(false);
    new thread().start();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBackground(Color.black);
}
    @Override
    public void paint(Graphics g) {
        if (bg) {
            g.setColor(Color.black);
            g.fillRect(0,0,800,800);

            bg = false;
        }
        drawLove.setGraphy(g);
        drawLove.drawLove();
    }
    class thread extends Thread{
        @Override
        public void run() {
            while (true)
            {
                repaint();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
