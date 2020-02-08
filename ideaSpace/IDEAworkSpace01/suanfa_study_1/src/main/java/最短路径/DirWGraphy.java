package 最短路径;

import java.util.HashSet;
import java.util.Iterator;

public class DirWGraphy {
    HashSet<DirWeightEdge>[] adj;
    private int E,V;

    public DirWGraphy(int v) {
        V = v;
        E=0;
        adj=new HashSet[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new HashSet<>();
        }
    }

    public int getV() {
        return  V;
    }

    public void addAdj(DirWeightEdge edge){
        adj[edge.from()].add(edge);
        this.E++;
    }
    public Iterator<DirWeightEdge> getEdges(int from){
        return adj[from].iterator();
    }
}
