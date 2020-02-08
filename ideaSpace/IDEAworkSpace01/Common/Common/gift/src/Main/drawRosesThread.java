package Main;
import Main.usage.data;
import Main.usage.myImage;
import java.awt.*;
public class drawRosesThread extends  Thread{
    private int x=20,y=40;
    private int sizeX= data.roseSizeX;
    private int sizeY=data.roseSizeY;
    private Graphics graphics;
    private Boolean canDraw=false;
    Image[] images=new Image[12];
    public drawRosesThread()
    {//初始化，把图片都装进数组中
        for (int i = 0; i <12 ; i++) {
            images[i]= myImage.getImage("Main/usage/images/rose_S/rose"+(i+1)+".png");
        }
    }
    /*
    画线程
     */
    @Override
    public void run() {
        while (true){
            if (canDraw)   //画纸传过来后开始画
                draw();
            else {
                /**
                 * 不要问我为什么下面线程睡眠0但是不删，
                 * 尽量不要动这个sleep（0）
                 * 删了程序就出bug，我也不知为什么，
                 *
                 *
                 * 我推测，当canDraw=false时，这个线程就没什么东西在跑，
                 * 系统就会把这个线程关闭，当我加一个sleep（0）时，就没bug了，
                 * emmm。。。。。。。。。。。。。。。。。。。。。。。
                 * 还有其他地方都有slee（0） 我也不知道，但是不要删，删了就不出错。。。
                 */
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public void getGraphy(Graphics g){    //得到画纸
        graphics=g;
        canDraw=true;   //只有得到画纸后才能画，不然后有空对象异常抛出；
    }
    private void draw()
    {
        for (int i = 0; i <12 ; i++) {
            graphics.drawImage(images[i],x,y,sizeX,sizeY,null);
        }
    }
}
