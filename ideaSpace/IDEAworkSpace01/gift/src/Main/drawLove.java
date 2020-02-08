package Main;
import Main.usage.data;
import java.awt.*;
public class drawLove extends Thread{
    double r;
    private Graphics g;
    private boolean canDraw=false;
    private double x = 150;
    private double y = 100;
    private boolean write=false;
    private double xx,yy;
    int i=0,j=0;
    public void setGraphy(Graphics graphy)
    {
        g=graphy;
        canDraw=true;
    }
    @Override
    public void run() {
        while (true)
        {
            if (canDraw)drawLove();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void drawLove() {
                if (j>90){ i++;j=0;
                    }
                if (i>90){ i=0;write=true;}
                j++;
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                xx = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i)
                        + x;
                yy = -r * Math.sin(Math.PI / 45 * j) + y;
                //设置画笔颜色
                //绘制椭圆
                g.setColor(Color.red);
                g.fill3DRect((int) xx, (int) yy, 2, 2, true);
                     if (write){
                        g.setColor(Color.red);
                    g.drawString("It's for you!",120,350);
    }}
        }