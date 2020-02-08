package characters;

import usage.GameObject;
import usage.Map;
import usage.data;
import usage.node;

public class Characters extends GameObject {
    private Map map;
    public Characters(int x, int y,Map map) {
        super(x, y);
        this.map=map;
    }
    public boolean moveRight(){
        if (this.getX()+2*data.X<data.GameSizeX&&!map.getG().isConnect(new node(this.getX()+data.X,this.getY()),new node(this.getX()+data.X,this.getY()+data.X)))
        {
            setX(getX()+data.X);
        return true;
        }
        return false;
    }  // 判断人物能否移动，例如如果人物左边两条线连起来了就不能移动
    public boolean moveLeft(){
        if (this.getX()-data.X>0&&!map.getG().isConnect(new node(this.getX(),this.getY()),new node(this.getX(),this.getY()+data.X)))
        {
            setX(getX()-data.X);
        return true;
        }
        return false;
    }   //同上
    public boolean moveUp()
    {
        if (this.getY()-data.X>0&&!map.getG().isConnect(new node(this.getX(),this.getY()),new node(this.getX()+data.X,this.getY())))
        {
            this.setY(getY()-data.X);
            return true;
        }
        return false;
    }
    public boolean moveDown(){
        if (this.getY()+2*data.X<data.GameSizeY&&!map.getG().isConnect(new node(this.getX(),this.getY()+data.X),new node(this.getX()+data.X,this.getY()+data.X)))
        {
            setY(getY()+data.X);
        return true;
        }
        return false;
    }
}
