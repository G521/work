package Main;
import java.awt.*;
import java.util.ArrayList;
/**蛋糕容器
 * 管理所有要画的蛋糕
 *这是个线程类，为了实现蛋糕可以自己下降移动。
 *
 * 其实也可以不用这个线程，因为主类那里有一个画的线程，
 * 然后让主类中每一次重画调用一次这个类的方法 也能实现蛋糕移动的效果，但是为了使蛋糕移动的更自然，
 * 我这里又用了一个‘重画’线程，
 */
public class drawCandlesThread extends Thread{
    Graphics graphics;
    private int capacity=80;
    boolean canDraw=false;
    boolean isLive=false;
    ArrayList<Candle> candles=new ArrayList<>(capacity);
    public drawCandlesThread(){
        for (int i = 0; i <capacity ; i++) {
            candles.add(new Candle());
            isLive=true;
        }
    }
    /**
     * 得到画纸，Java中的Graphics 就相当于画纸
     * 很多人说是画笔，但是我认为是画纸才恰当，
     * 当两个Graphics对象相同，就是同一张画纸，所以显示出来的图片就在同一个窗口了
     * 下面这个方法就是得到共同的那张纸
     * @param g
     */
    public void getGraphy(Graphics g)
    {
        graphics=g;
        canDraw=true;
    }

    /**
     *
     */
    @Override
    public void run() {
        while (isLive) {
            if (canDraw) {   //加这个判断主要是看纸是否传过来了，不然下面用纸（Graphics）画蛋糕
                            // 会抛出空对象异常
                drawCandles();
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }//  在纸上画蛋糕
    //直接把纸传给每一个蛋糕对象，让让他们自己画
    public void drawCandles()
    {
        for (Candle candle : candles) {
            candle.draw(graphics);
        }
    }
}
