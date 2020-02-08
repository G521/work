package characters;

import usage.Map;
import usage.data;

import java.awt.*;
public class myCharacter extends Characters {
    public myCharacter(int x, int y, Map map) {
        super(x, y, map);
    }
    private void drawMove(Graphics graphics){      //这个画的是张嘴的
        graphics.fillArc(this.getX(),
                this.getY(), data.X, data.X,(int)(5*Math.PI),(int)((100-(1.0/12))*Math.PI));  //扇形
    }
    private void drawStay(Graphics graphics){   //这个画的是闭嘴的 和上面那个配合就是一张一张的
        graphics.fillOval(this.getX(),
                this.getY(), data.X,   //圆
                data.X);
    }
    public void draw(Graphics graphics,boolean isMove){
        graphics.setColor(Color.darkGray);  //设置颜色
        if (isMove){     //控制张嘴，闭嘴，  有点乱，但是将就着能用，，，
            if (Math.random()>0.2) {
                this.drawMove(graphics);
            }
                else this.drawStay(graphics);
        }else {
            this.drawMove(graphics);
        }
        this.drawEye(graphics);    //画吃豆人的眼睛，上面画的是吃豆人的黄色身体
    }
    private void drawEye(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)(this.getX()+ data.X/1.5),
                this.getY()+ data.X/6,
                data.X/8, data.X/8);
    }
    public void move(String move){    //移动，调用父类的方法
        switch (move){
            case "right":moveRight();break;
            case "left":moveLeft();break;
            case "up":moveUp();break;
            case "down":moveDown();break;
        }
    }
}
