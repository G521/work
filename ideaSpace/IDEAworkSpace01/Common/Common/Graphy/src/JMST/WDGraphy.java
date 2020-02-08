package JMST;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class WDGraphy {
    private int E,V;
    private HashSet<WeightDirEdge>[] adj;
    public WDGraphy(int V){
        E=0;
        this.V=V;
        adj=new HashSet[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new HashSet<>();
        }
    }

    public WDGraphy(Scanner in) {
    this(in.nextInt());
    int e=in.nextInt();
        for (int i = 0; i < e; i++) {
            this.addEdge(new WeightDirEdge(in.nextInt(),in.nextInt(), in.nextDouble()));
        }
    }

    public void  addEdge(WeightDirEdge edge){
        adj[edge.getFrom()].add(edge);
        E++;
    }
    public int getE() {
        return E;
    }
    public int getV() {
        return V;
    }
    public Iterator<WeightDirEdge> getAdj(int v) {
        return adj[v].iterator();
    }
}
