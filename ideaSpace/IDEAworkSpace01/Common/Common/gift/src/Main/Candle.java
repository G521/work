package Main;
import Main.usage.data;
import Main.usage.myImage;
import java.awt.*;
public class Candle {
    private double x,y;
    private int size= data.candleSize; //蛋糕的大小
    private double speed=data.candleSpeed*Math.random()+0.1;  //蛋糕下降的速度， 使用Math.random（）为了使每个蛋糕下降的速度都不一样
    private Image image= myImage.getImage(data.candleImage());  // 获得图片
    Candle(){
    this.x=(int)(Math.random()*data.windowSizeX)-30; //获得随机位置，为了像下雨那样，
    this.y=(int)(Math.random()*(-400));//如果是固定的高度，一排一起下来就不好看了，
    }
    private void move() {   //移动
        y +=speed;  //每次往下移动speed个距离
        /**
         * //判断是否下降出边界 如果是 就重新回到上面
         */
        if (y>data.windowSizeY) {
            y = (int) (Math.random() * (-100));    //y轴位置
            x=(int)(Math.random()*data.windowSizeX)-30;//x轴位置
            speed=data.candleSpeed*Math.random()+0.1;//速度
        }
    }
    public void draw(Graphics g){
        move();    //每次画之前都要移动一下，这样就能出现下雨那样的效果了
        g.drawImage(image,(int)x,(int)y,size,size,null);
    }
}
