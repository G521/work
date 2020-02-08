package review_WeightGraphy;

import java.security.PublicKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class EdgeWeightGraphy {
    private static  int E  ;
    private boolean[] marked;
    private HashSet<Edge>[] adj;

    public  int getE() {
        return E;
    }
    public EdgeWeightGraphy(int V){
        marked=new boolean[V];
        for (HashSet<Edge> edges : adj = new HashSet[V]);
        E=0;
        for (int i = 0; i <V ; i++) {
            adj[i]=new HashSet<>();
        }
    }
    public EdgeWeightGraphy(Scanner in){
        this(in.nextInt());
        int e=in.nextInt();
        for (int i = 0; i <e ; i++) {
            this.addAdj(new Edge(in.nextInt(),in.nextInt(),in.nextDouble()));
        }
    }
    private void  addAdj(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterator<Edge> getIteraor(int v){
        return adj[v].iterator();
    }

}
