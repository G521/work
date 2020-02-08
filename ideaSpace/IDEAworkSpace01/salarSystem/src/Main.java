import usage.myImage;
import usage.values;

import java.awt.*;

public class Main extends myFrame {
    Image bg,buffer;
    Star sun;
    plane earth,moon,huo,tian,shui,hai,jin,mu,tu,weixing_1,weixing_2,weixing_3,weixing_4;
    Image img;
    public  Main()
    {
        bg= myImage.getImage("src/usage/images/bg.jpg");
        sun=new Star("src/usage/images/sun.png", values.SunX,
                values.SunY,values.sizeSun);
        earth=new plane(sun,values.sizeEarth,values.EarthR,
                0.1225,"src/usage/images/earth.png");
        moon=new plane(earth,values.sizeYue,values.yueR,
                0.3,"src/usage/images/moon.png");
        hai= new plane(sun,values.sizeHai,values.haiR,
                0.0125,"src/usage/images/hai.png");
        shui= new plane(sun,values.sizeShui,values.shuiR,
                0.33,"src/usage/images/shui.png");
        tu=new plane(sun,values.sizeTu,values.tuR,
                0.11,"src/usage/images/tu.png");
        tian=new plane(sun,values.sizeTian,values.tianR,
                0.05,"src/usage/images/tain.png");
        huo=new plane(sun,values.sizeHuo,values.huoR,
                0.09,"src/usage/images/huo.png");
        jin=new plane(sun,values.sizeJin,values.jinR,
                0.225,"src/usage/images/jin.png");
        mu=new plane(sun,values.sizeMu,values.muR,
               0.30,"src/usage/images/mu.png");
        weixing_1=new plane(tu,9,60,0.3,"src/usage/images/tu.png");
        weixing_2=new plane(tu,9,65,0.15,"src/usage/images/tu.png");
        weixing_3=new plane(tu,9,50,0.25,"src/usgage/images.png");
        weixing_4=new plane(tu,9,55,0.2,"src/usage/images/tu.png");
    }
    @Override
    public void paint(Graphics g) {
        if (img==null)img=this.createImage(values.FrameX,values.FrameY);
        Graphics g2=img.getGraphics();
        g2.drawImage(bg,0,0,values.FrameX,values.FrameY,null);
        sun.draw(g2);
        earth.draw(g2);
        moon.draw(g2);
        huo.draw(g2);
        jin.draw(g2);
        shui.draw(g2);
        tu.draw(g2);
        weixing_1.draw(g2);
        weixing_2.draw(g2);
        weixing_3.draw(g2);
        weixing_4.draw(g2);

        tian.draw(g2);
        hai.draw(g2);
        mu.draw(g2);
    g.drawImage(img,0,0,values.FrameX,values.FrameY,null);
    }
    @Override
    public void update(Graphics g) {
        if (buffer==null)
            buffer=myImage.getImage("src/usage.images/bg.jpg");
        g.drawImage(buffer,0,0,values.FrameX,values.FrameY,null);
        paint(g);
    }
    public static void main(String[] args) {
        new Main().lanuchFrame();
    }
}
