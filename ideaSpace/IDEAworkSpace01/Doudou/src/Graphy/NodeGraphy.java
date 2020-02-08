package Graphy;
import usage.node;
import java.util.HashMap;
import java.util.Iterator;
/*
符号图  这些图都是算法书里面的原型，基本没怎么变
 */
public class NodeGraphy {
    private HashMap<node,Integer> mst;
    private node[] nodes;
    private graphy graphy;
    private int E;
    public NodeGraphy(int V){
        graphy =new graphy(V);    //基础图
        mst=new HashMap<>(400);
        nodes=new node[V];
        E=0;
    }
    public void clean(){
        graphy.delAll();
    }
    public void addNode(node node){    //把结点都存进容器
        mst.put(node,E);
        nodes[E]=node;
        E++;
    }
    public void ctNode(node x,node y){     // 将两个节点连接起来
        if (mst.get(x)==null||mst.get(y)==null)return ;
        graphy.addEdge(mst.get(x),mst.get(y));     //通过基础图把两个节点在基础图中的映射连接
    }
    public boolean isConnect(node x,node y){    //判断两个节点是否相连接，主要是把获得节点在基础图的映射，查找基础图是否相连接
        if (mst.get(x)==null||mst.get(y)==null)return false;
        return graphy.isConnect(mst.get(x),mst.get(y));
    }
    public node getNode(int index){
        return nodes[index];
    }    //查找结点通过序号
    public Iterator<node> getNodes(){     //获得所有节点的迭代器
        return mst.keySet().iterator();
    }

    public Graphy.graphy getGraphy() {
        return graphy;
    }

    public int getE() {
        return E;
    }   //获得节点的数量
}
