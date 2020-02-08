package usage;
import java.util.Iterator;
import java.util.Stack;
/*
这个类是定义图上的点
 */
public class node{
    private int x,y;
    private node right,left,up,down;//定义该点的上下左右点
    public node(int x,int y) {
        this.x = x;
        this.y = y;
    }
    /*
    一下就是设置和获取该点的临近点
     */
    public void setRight() {
        if (getX()+data.X<data.GameSizeX)this.right=new node(getX()+data.X,getY());
    }
    public void setLeft() {
        if (getX()-data.X>0)this.left=(new node(getX()-data.X,getY()));
    }
    public void setUp() {
        if (getY()-data.X>0)this.up=new node(getX(),getY()-data.X);
    }
    public void setDown() {
        if (getY()+data.X<data.GameSizeY)this.down=new node(getX(),getY()+data.X);
    }
    public node getRight() {
        return right;
    }
    public node getLeft() {
        return left;
    }
    public node getUp() {
        return up;
    }
    public node getDown() {
        return down;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    /*
    重写* * 方法，为了是系统可以自动判断两个node对象是否是一个  这个很重要，因为程序中用的很多该类都是匿名内部类，所以只能系统自己判定

     */
    @Override
    public int hashCode() {
        return new String(x+"@"+y+"").hashCode();
    }
    public Iterator<node> getNec(){
        Stack<node> stack =new Stack<>();
        if (this.getDown()!=null)stack.add(this.getDown());
        if (this.getLeft()!=null)stack.add(this.getLeft());
        if (this.getUp()!=null)stack.add(this.getUp());
        if (this.getRight()!=null)stack.add(this.getRight());
        return stack.iterator();
    }
    @Override
    public boolean equals(Object obj) {
        return this.hashCode()==obj.hashCode();
    }
}
