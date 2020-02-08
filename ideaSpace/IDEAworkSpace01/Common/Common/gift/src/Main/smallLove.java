package Main;
import Main.usage.data;

import java.awt.*;
/** 使用Java中画直线的方法
 *  需要两个点（x1，y1）,(x2,y2)
 *
 *  使用的笛卡尔函数; r=a(1-cosθ)  (极坐标方程高中应该学过)
 *
 */
public class smallLove {

    private double a=80;   // 线条的长度公式中的a
    private double D=Math.random()*Math.PI*2;   //角度，注意角度生成要随机，
    // 因为每次添加五条线，如果不随机的画这五条线是在一起的，就相当于一条线了
    private double x,y;    //位置坐标
    public smallLove(){
        x= data.windowSizeX/2-100;  //使用窗口大小生成坐标，这样窗口改变的时候，坐标也会自动改变，这样就不会那么乱
        y=data.windowSizeY/2-300;
    }
    public void draw(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;//使用Graphics2D 是为了线条粗点，Graphics类不能改变线条粗细，默认的太细了
        g2.setStroke(new BasicStroke(2));//线条加粗，会用就行
        g2.setColor(Color.red);//设置红色
        D+=0.05; //每次画的时候就是转动角度，这样那个心其实是一直在动的，比照片上好看点
        g2.drawLine((int)x,(int)y,(int)(x+a*(1-Math.sin(D))*Math.cos(D)),(int)(y-a*(1-Math.sin(D))*Math.sin(D)));
       g.setColor(Color.black); //用完之后，把颜色重新弄回去
    }
}
