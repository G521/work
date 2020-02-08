package graphy;

import java.util.Iterator;

public class Cycle {
    private boolean isCycle;
    private boolean[] marked;
    public Cycle(graphy g)
    {
        marked=new boolean[g.getE()];
        isCycle=false;
        dfs(g,0,0);
    }
    private void dfs(graphy g,int s,int u){
        marked[s]=true;
        for (Iterator<Integer> it = g.getIterator(s); it.hasNext(); ) {
            int k = it.next();
            if (!marked[k]) {
                marked[k]=true;
                dfs(g,k,s);
            }else if (k==u)isCycle=true;
        }
    }
    public boolean isCycle() {
        return isCycle;
    }
}
