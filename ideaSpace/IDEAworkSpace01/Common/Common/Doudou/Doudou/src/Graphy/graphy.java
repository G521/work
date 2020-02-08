package Graphy;

import java.util.HashSet;
import java.util.Iterator;
/*
图论  数据结构
 */
public class graphy {
    private HashSet<Integer> adj[];
    private int E;
    private int V;
    public int getV() {
        return V;
    }

    public graphy(int V){
        adj=new HashSet[V];
        this.V=V;
        for (int i = 0; i <V ; i++) {
            adj[i]=new HashSet<>();
        }
    }
    public int getE() {
        return E;
    }
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public void delAll(){
        for (HashSet<Integer> integers : adj) {
            integers.clear();
        }  E=0;
    }
    public Iterator<Integer> getIterator(int v){
        return adj[v].iterator();
    }
    public boolean isConnect(int v,int w){
        return adj[v].contains(w);
    }
}
