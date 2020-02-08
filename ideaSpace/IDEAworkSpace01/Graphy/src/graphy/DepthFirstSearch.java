package graphy;

import java.util.Iterator;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(graphy g, int s){
        marked=new boolean[g.getV()];
        dfs(g,s);
    }
    private void dfs(graphy g, int v)
    {
        System.out.println(v);
        marked[v]=true;
        count++;
        for (Iterator<Integer> it = g.getIterator(v); it.hasNext(); ) {
            int w = it.next();
            marked(w);
            if (!marked(w))dfs(g,w);

        }
    }
    private boolean marked(int v)
    {
        return marked[v];
    }
    public int getCount()
    {
        return count;
    }
}
