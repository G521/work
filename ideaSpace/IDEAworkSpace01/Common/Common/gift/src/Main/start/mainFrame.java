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
    HashSet<location> locations=new HashSet<>();
    HashSet<smallLove> Loves=new HashSet<>();
    game game;
    music first=new music();
    T t;//礼物
    Image[] roseImages=new Image[5];
    Image buffer;
    Image bg= myImage.getImage(data.bgImage);
    drawRosesThread roses;
    Image last =myImage.getImage("Main/usage/images/candles/candle7.png");
    drawCandlesThread candles;
    public mainFrame()
    {
        this.init();
    }
    private void init(){
        first.start();
        game=new game();
        game.start();
        this.setLocation(300,0);
        this.setResizable(false);
        this.setSize(data.windowSizeX,data.windowSizeY);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        candles=new drawCandlesThread();
        candles.start();
        roses=new drawRosesThread();
        roses.start();
        new paintThread().start();
        this.addMouseListener(this);
        this.initRosesImages();
    }
    private void initRosesImages()
    {
        for (int i=0;i<5;i++)
        {
            roseImages[i]=(myImage.getImage("Main/usage/images/roses/rose"+(i+1)+".png"));
        }
    }
    private void drawRose(Graphics g)
    {
        //关闭第一个音乐
        if (game.isOver()){
            first.stop();}
        for (location location : locations){
            g.drawImage(roseImages[location.getZ()],location.getX(),location.getY(),(int)data.reseSize,(int)data.reseSize,null);
        }
        if (game.isGameover()&&t==null){ //画礼物
          t=new T();
      }
            Loves.forEach(drawLove -> {
                drawLove.draw(g);
            }
            );
    }
    @Override
    public void paint(Graphics g) {
        if (buffer==null)
        buffer=this.createImage(data.windowSizeX,data.windowSizeY);
        Graphics g2=buffer.getGraphics();
        g2.drawImage(bg,0,0,data.windowSizeX,data.windowSizeY,null);
        if (candles!=null)candles.getGraphy(g2);
        if (roses!=null)roses.getGraphy(g2);
        this.drawRose(g2);
        if (game.getGoal()>0) {
            g2.setFont(new Font("微软雅黑", Font.BOLD, 60));
            g2.setColor(Color.pink);
            g2.drawString(String.format("恭喜你吃到了%s个", game.getGoal()), 300, 400);
            g2.drawImage(last,800,350,60,60,null);
        }
        g2.setFont(new Font("华文新魏",Font.ITALIC,20));
        g2.drawString("---高梦瑶",220,115);
        g.drawImage(buffer,0,0,data.windowSizeX,data.windowSizeY,null);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        locations.add(new location(mouseEvent.getX(), mouseEvent.getY()));
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
        Loves.add(new smallLove());
        Loves.add(new smallLove());

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
            while (true) {
                repaint();
                try {
                    this.sleep(20);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static void main(String[] args) {
        new mainFrame();
    }
}
