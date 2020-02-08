package usage;

import characters.myCharacter;
import usage.music.music_eat;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
/*
        这个类是用来画吃豆人上面的小星星的
 */
public class small_Star {
    private Map map;//地图
    private boolean GameOver;//豆豆吃完后就游戏胜利了
    private myCharacter character;
    private HashSet<star> stars;  // 用来装小豆豆的容器
    private int goal=0;  //得分
    private int E;    //小豆豆的数量
    public small_Star(Map map, myCharacter character){//传来地图，玩家控制的人物
        this.map=map;
        GameOver=false;
        E=0;
        stars=new HashSet<>();
        this.character=character;
        this.init();
    }
    private void check(){  //检查玩家人物是否吃到小豆豆
        for (star s: stars ) {
            if (s.x==character.getX()&&s.y==character.getY()&&s.isLive){
                s.isLive=false;
                new music_eat().start();
                E--;
                goal+=2;
                if (E<=0)GameOver=true;
            }
        }
    }
    public boolean isGameOver() {
        return GameOver;
    }
    public void draw(Graphics graphics){   // 绘制小豆豆
        check();//检查
        graphics.setColor(Color.orange);  //设置小豆豆的颜色
        for (star s: stars) {
            if (s.isLive)     //如果小豆豆没有被吃就画出来 因为用的是foreach 尽量不要直接删除会报异常
            graphics.fillOval(s.x+data.X/2,s.y+data.X/2,data.X/6,data.X/6);
        } }
    public int getGoal() {
        return goal;
    }  // 获取分数
    //初始化小豆豆
    public void init(){
        for (Iterator<node> it = map.getG().getNodes(); it.hasNext(); ) {
            node nd = it.next();
            star star=new star(nd.getX(),nd.getY());
            if ((star.moveDown()||star.moveLeft()||star.moveUp()||star.moveRight())&&(nd.getY()+data.X<data.GameSizeY))
            {
                if (Math.random()>0.3)continue;
                E++;
                stars.add(star);
            }
        }
    }
    // 小豆豆的类
    class star{
        private int x,y;
        private boolean isLive;
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        star(int x, int y) {
            this.x = x;
            this.y = y;
            isLive=true;
        }

        /*
        重写小豆豆的hashCode 和equal方法
        为了系统能自动判定两个小豆豆是否是同一对象
         */
        @Override
        public int hashCode() {
            return new String(x+"@"+y+"").hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            return this.hashCode()==obj.hashCode();
        }

        /*
        一下是判断位置是否是死区，也就是玩家人物到达不到的地方，也就吃不到豆豆，所以该位置不能有小豆豆
        如果可以左右上下移动说明不是死区；
         */
        private boolean moveRight(){
            if (this.getX()+2*data.X<data.GameSizeX&&!map.getG().isConnect(new node(this.getX()+data.X,this.getY()),new node(this.getX()+data.X,this.getY()+data.X)))
                return true;
            return false;
        }
        public boolean moveLeft(){
            if (this.getX()-data.X>0&&!map.getG().isConnect(new node(this.getX(),this.getY()),new node(this.getX(),this.getY()+data.X)))
                return true;
            return false;
        }
        public boolean moveUp()
        {
            if (this.getY()-data.X>0&&!map.getG().isConnect(new node(this.getX(),this.getY()),new node(this.getX()+data.X,this.getY())))
                return true;
            return false;
        }
        public boolean moveDown(){
            if (this.getY()+2*data.X<data.GameSizeY&&!map.getG().isConnect(new node(this.getX(),this.getY()+data.X),new node(this.getX()+data.X,this.getY()+data.X)))
                return true;
            return false;
        }
    }
}
