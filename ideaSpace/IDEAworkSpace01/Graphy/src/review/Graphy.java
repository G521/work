package review;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
public class Graphy {
    private int V,E;
    private HashSet<Integer>[] adj;
    public Graphy(Scanner in)
    {
        this(in.nextInt());
        int n=in.nextInt();
        for (int i = 0; i <n ; i++) {
            int v=in.nextInt();
            int w=in.nextInt();
            addAdj(v,w);
        }
    }
    public int getE() {
        return E;
    }

    public Graphy(int V)
    {
        this.E=0;
        this.V=V;
        adj=new HashSet[V];
        for (int i = 0; i <V ; i++) {
        adj[i]=new HashSet<>();
        }
    }
    private void  addAdj(int v,int w)
    {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterator<Integer> getIterator(int v){
        return adj[v].iterator();
    }
}
