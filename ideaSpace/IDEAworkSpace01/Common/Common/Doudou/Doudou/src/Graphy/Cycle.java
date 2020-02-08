package Graphy;

import java.util.Iterator;

public class Cycle {
    private boolean marked[];
    private boolean isCycle=false;
    public Cycle(graphy G){
        marked=new boolean[G.getV()];
        for (int i = 0; i <G.getV() ; i++) {
            if (!marked[i])dfs(G,i,i);
        }
    }
    private void dfs(graphy G,int v,int u){
        marked[v]=true;
        for (Iterator<Integer> it = G.getIterator(v); it.hasNext(); ) {
            int k = it.next();
            if (!marked[k])
            dfs(G,k,v);
            else if (k!=u)isCycle=true;
        }
    }
    public boolean isCycle() {
        return isCycle;
    }
}
