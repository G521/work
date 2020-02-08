package graphy;

import java.util.Iterator;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    public CC(graphy g){
        marked=new boolean[g.getE()];
        id=new int[g.getE()];
        for (int s = 0; s <g.getE() ; s++) {
            dfs(g,s);
            count++;
        }
    }
    private void dfs(graphy g, int s){
        marked[s]=true;
        id[s]=count;
        for (Iterator<Integer> it = g.getIterator(s); it.hasNext(); ) {
            int k = it.next();
            if (!marked[k])dfs(g,k);
        }
    }
    public boolean connected(int v,int w)
    {
        return id[v]==id[w];
    }
    public int getCount() {
        return count+1;
    }
}
