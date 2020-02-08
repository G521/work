package Main;

import characters.monsters;
import characters.myCharacter;
import usage.Img;
import usage.Map;
import usage.data;
import usage.music.music_fail;
import usage.small_Star;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
public class Frame extends JFrame {
    Map map =new Map();
    boolean isGameOver=false;
    private int numofMonsters=8;
    int i=0;
    myCharacter character=new myCharacter(2*data.X,2*data.X,map);
    small_Star star=new small_Star(map,character);
    Image bg= Img.getImg("usage/imgs/bg.png");
//    monsters monsters_5=new monsters(getLo(),getLo(),map,character);
    HashSet<monsters> monsters=new HashSet<>();
    Image bufferImg;
    public Frame(){
        this.init();
    }
    private void init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(data.GameSizeX,data.GameSizeY);
        this.setVisible(true);
        new repaint().start();
        this.addKeyListener(new Key());
        for (int i=0;i<numofMonsters;i++){
            monsters.add(new monsters(getLo(),getLo(),map,character));
        }
    }
    private void  drawMonsters(Graphics g){// 画小怪物
        for (monsters m: monsters) {
            m.draw(g);
            if (m.isGame_Over())isGameOver=true;
        }
    }
    private int getLo(){   //获得小怪物的初始化随机坐标值
        return (int) (Math.random()*(data.GameSizeY/data.X-2)+1)*data.X;
    }

    /**
     * 获得分数
     * @param
     */
    public int getGoal(){
        return this.star.getGoal();
    }
    public boolean isGameOver() {
        return isGameOver;
    }

    @Override
    public void paint(Graphics g) {
        if (bufferImg == null) bufferImg = this.createImage(data.GameSizeX, data.GameSizeY);
        Graphics g2 = bufferImg.getGraphics();//双缓冲的一部分
        super.paint(g2);
        g2.setColor(Color.black);

        g2.fillRect(0,0,data.GameSizeX,data.GameSizeY);
        if (!isGameOver)character.draw(g2, true);
        map.draw(g2);  // 画地图
        star.draw(g2);//画小点点
        drawEdge(g2); //画边界
        drawMonsters(g2);//画小怪物
        g2.setColor(Color.red); //为了下面的游戏结束文字
        g2.drawString("分数："+star.getGoal(),50,50);
        g2.setFont(new Font("宋体",Font.BOLD,33));
        if (star.isGameOver()&&!isGameOver)g2.drawString("恭喜通关！！",200,300);
        if (isGameOver){
            if (i==0)new music_fail().start();
            g2.drawString("游戏失败！！",200,300);
            i=9;
        }
        //下面是双缓冲的核心
        g.drawImage(bufferImg, 0, 0, data.GameSizeX, data.GameSizeY, null);
    }
    /*
    下面是画图的边界
    */
    private void drawEdge(Graphics graphics){
        graphics.setColor(Color.blue);
        Graphics2D g2= (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(data.X,data.X,data.GameSizeX-data.X,data.X);
        g2.drawLine(data.GameSizeX-data.X,data.X,data.GameSizeX-data.X,data.GameSizeY-data.X);
        g2.drawLine(data.X,data.X,data.X,data.GameSizeY-data.X);
        g2.drawLine(data.X,data.GameSizeY-data.X,data.GameSizeX-data.X,data.GameSizeY-data.X);
    }
    public static void main(String[] args) {
        new Frame();
    }
    /*
    重画线程
     */
    class repaint extends Thread{
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
             Thread.sleep(10);
                } catch (InterruptedException e) {
//                e.printStackTrace();
                }
            }
        }
    }
    /*
    键盘监听类
     */
    class Key implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()){
                case KeyEvent.VK_UP:character.move("up");break;  //人物移动
                case KeyEvent.VK_DOWN:character.move("down");break;
                case KeyEvent.VK_LEFT:character.move("left");break;
                case KeyEvent.VK_RIGHT:character.move("right");break;
            }
        }
        @Override
        public void keyReleased(KeyEvent keyEvent) {
        }
    }
}
