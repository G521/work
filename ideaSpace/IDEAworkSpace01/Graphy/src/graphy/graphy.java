package graphy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class graphy {
    private  int E  ;
    private int V;
    private HashSet<Integer> adj[];
    public graphy(int V)
    {
        this.E=0;
        this.V=V;
        adj=new HashSet[V];
        for (int i = 0; i <V ; i++) {
            adj[i]=new HashSet<Integer>();
        }
    }
    public graphy(Scanner in)
    {
        this(in.nextInt());
        int E=in.nextInt();
        for (int i = 0; i <E ; i++) {
            int v=in.nextInt();
            int w=in.nextInt();
            addAdj(v,w);
        }
    }
    public int getE() {
        return E;
    }
    public Iterator<Integer> getIterator(int key)
    {
        return adj[key].iterator();
    }
    public int getV() {
        return V;
    }

    public void addAdj(int x, int y)
    {
       adj[x].add(y);
       adj[y].add(x);
    }
}
