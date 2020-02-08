package usage;
import Graphy.Cycle;
import Graphy.NodeGraphy;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;
/*
定义游戏地图类
 */
public class Map {
    NodeGraphy graphy;
    Random random=new Random(System.currentTimeMillis());//产生随意数
    private int X=(int)(data.GameSizeX/data.mySize);    //计算地图的x方向的点数
    private int Y=(int)(data.GameSizeY/data.mySize);   // y轴方向的点数
     public Map(){
        this.initMap();
    }
    //初始化地图
    private void initMap(){
        graphy=new NodeGraphy((X)*(Y));
        for (int i = 2; i <X-1;i+=1) {
            for (int j = 2; j <Y-1 ; j+=1) {
                node node=new node((int)(i*data.mySize),(int)(j*data.mySize));
                graphy.addNode(node);// 向地图中加入点
            }
        }
        this.addEdge();  // 设置线
    }
    private void addEdge(){
      do {
          graphy.clean();
          for (int i = 0; i < graphy.getE(); i++) {
              node node = graphy.getNode(i);
              // 下面随机产生的线（地图） 每个点只用产生右边和下边的，然后从左上到右下有全地图都会随机产生边了
              if (Math.random() > 0.7) {
                  node.setDown();
                  graphy.ctNode(node, node.getDown());
              }
              if (Math.random() > 0.7) {
                  node.setRight();
                  graphy.ctNode(node, node.getRight());
              }
          }
      } while (new Cycle(this.getG().getGraphy()).isCycle());
    }
    //画地图
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        for (int i = 0; i <graphy.getE(); i++) {
            node n=graphy.getNode(i);
            for (Iterator<node> it = n.getNec(); it.hasNext(); ) {
                node node = it.next();
                if (graphy.isConnect(n,node)){
                    Graphics2D g2=(Graphics2D)g; //
                    g2.setStroke(new BasicStroke(3));//设置线的粗细 只能用Graph2D
                    g2.drawLine(node.getX(),node.getY(),n.getX(),n.getY());
                }

            }
        }
    }
    //得到地图的抽象图  图论算法
    public NodeGraphy getG() {
        return this.graphy;
    }
}
