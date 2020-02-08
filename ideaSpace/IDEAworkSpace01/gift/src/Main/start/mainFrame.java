package Main.start;
import Main.drawCandlesThread;
import Main.drawRosesThread;
import Main.smallLove;
import Main.usage.T;
import Main.usage.data;
import Main.usage.music;
import Main.usage.location;
import Main.usage.myImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashSet;

public class mainFrame extends JFrame implements MouseListener {
    HashSet<location> locations=new HashSet<>();    //记录每次点击时的位置
    HashSet<smallLove> Loves=new HashSet<>();//每次点击增加的线条都存在这里
    Image[] roseImages=new Image[5];   //还记得那个location对象中的z吗，就是用来从这个数组中取图片的
    Image buffer;//双缓冲要用的图片对象
    Image bg= myImage.getImage(data.bgImage);  //背景图片
    drawRosesThread roses; //这是画那个左上角闪光玫瑰要用的线程类
    drawCandlesThread candles;//这是画蛋糕雨要用的线程类
    public mainFrame()
    {
        this.init();
    }
    private void init(){
        //初始化窗口
        this.setLocation(300,0);
        this.setResizable(false);
        new music().start();
        this.setSize(data.windowSizeX,data.windowSizeY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//初始化窗口

        candles=new drawCandlesThread();
        candles.start();//蛋糕雨线程开启
        roses=new drawRosesThread();
        roses.start();//闪光玫瑰线程开启
        new paintThread().start();//重画线程开启
        this.addMouseListener(this);//添加鼠标监听器
        this.initRosesImages();//玫瑰数组初始化照片
    }
    /**
     * 玫瑰数组初始化照片
     */
    private void initRosesImages()
    {
        for (int i=0;i<5;i++)  //注意我那些玫瑰照片的名字特意命名位rose1，rose2了，所以可以用下面这个，反正能把图片装进数组就行
        {
            roseImages[i]=(myImage.getImage("Main/usage/images/roses/rose"+(i+1)+".png"));
        }
    }
    private void drawRose(Graphics g)//画点击时产生玫瑰
    {
        for (location location : locations){ //根据我们每次点击记录的坐标来画
            g.drawImage(roseImages[location.getZ()],location.getX(),location.getY(),(int)data.reseSize,(int)data.reseSize,null);
        }
            Loves.forEach(drawLove -> { //这个是画那个心的 很多线条组成的心
                drawLove.draw(g);
            }
            );
    }
    @Override
    public void paint(Graphics g) {
        if (buffer==null) buffer=this.createImage(data.windowSizeX,data.windowSizeY);//为了防止每次都创建新对象
        Graphics g2=buffer.getGraphics();  //获取双缓冲用到的图片的’纸‘ 因为要在这张纸上画
        g2.drawImage(bg,0,0,data.windowSizeX,data.windowSizeY,null);//画背景
        if (candles!=null)candles.getGraphy(g2);//给蛋糕传过去这张’纸‘
        if (roses!=null)roses.getGraphy(g2);//给左上角那个闪光玫瑰传过去这张‘纸’。
        this.drawRose(g2);//给我们点击生成的玫瑰传过去‘纸’
        g.drawImage(buffer,0,0,data.windowSizeX,data.windowSizeY,null);//最后画这张’纸图片‘
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {  // 每次点击记录一个坐标
        locations.add(new location(mouseEvent.getX(), mouseEvent.getY()));
        Loves.add(new smallLove()); //每次点击都会增加这么多的线条，
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());
        Loves.add(new smallLove());//可以用个循环，emm ，都一样，每次点击增加10几条线，免得点几十次都出不来那个心型的轮廓

    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
    class paintThread extends Thread{
        @Override
        public void run() {
            while (true) { //注意，是个循环，因为线程开始只会调用一次run（）
                repaint();
                try {
                    this.sleep(20);  //每次隔20ms重画，免得程序一直连着画，耗内存，能让肉眼看不见就行
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static void main(String[] args) {
        new mainFrame();
    }
}
