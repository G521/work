package characters;
import usage.Img;
import usage.Map;
import usage.data;
import java.awt.*;
/*
吃豆人中的那些小怪物们，
 */
public class monsters extends Characters {
    Image image;
    private static dir dir;
    private boolean Game_Over;
    private myCharacter character;
    public monsters(int x, int y, Map map,myCharacter character) {
        super(x, y, map);
        this.image=initImg();
        new thread().start();
        this.dir= dir.down;
        Game_Over=false;
        this.character=character;
    }
    private enum dir{   // 方向
        left,right,up,down
    }
    /*
        随机选择一种图片
         */
    private Image initImg(){
        String path="";
        switch ((int)(Math.random()*5)){
            case 0:path="usage/imgs/monster_1.png";break;
            case 1: path="usage/imgs/monster_2.png";break;
            case 2:path="usage/imgs/monster_3.png";break;
            case 3:path="usage/imgs/monster_4.png";break;
            case 4:path="usage/imgs/monster_5.png";break;
        }
        return Img.getImg(path);
    }
    public boolean isGame_Over() {
        return Game_Over;
    }
    /*
    检查是否与游戏玩家相撞，
     */
    private void check(){
        if (character.getX()==this.getX()&&character.getY()==this.getY()){
            Game_Over=true;  //撞到就游戏结束
        }
    }
    public void draw(Graphics graphics){
        this.check();
        if (isGame_Over())return; // 这个怪物被撞到就游戏结束
        graphics.drawImage(image,this.getX(),this.getY(), data.X,data.X,null);
    }
    private void move(){  //根据当前方向移动
        switch (dir){
            case up: if (!moveUp())
               dir= Math.random()>0.5?monsters.dir.down: Math.random()>0.5?monsters.dir.left: monsters.dir.right;
                break;
            case down:if (!moveDown())
                dir= Math.random()>0.5?monsters.dir.up:Math.random()>0.5?monsters.dir.left: monsters.dir.right;
                break;
            case left:if (!moveLeft())
                dir= Math.random()>0.5?monsters.dir.right:Math.random()>0.5?monsters.dir.down: monsters.dir.up;
                break;
            case right:if (!moveRight())
                dir= Math.random()>0.5?monsters.dir.left: Math.random()>0.5?monsters.dir.down: monsters.dir.up;
                break;
        }
        if (Math.random()>0.7){//随机改变方向，防止发生在一个地方内出不来
            switch ((int) (Math.random()*4)){
                case 0:dir= monsters.dir.right;break;
                case 1:dir= monsters.dir.left;break;
                case 2:dir= monsters.dir.up;break;
                case 3:dir= monsters.dir.down;break;
            }
        }
    }
    class thread extends Thread{   // 小怪物移动线程
        @Override
        public void run() {
            while (true){
                move();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }
}
