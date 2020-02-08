package graphy;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {
    private boolean marked[];
    private final int s;
    private int[] edgeTo;
    public DepthFirstPaths(graphy g, int s) {
        this.s = s;
        edgeTo=new int[g.getV()];
        marked=new boolean[g.getV()];
        dfs(g,s);
    }
    private void dfs(graphy g, int v)
    {
        marked[v]=true;
        for (Iterator<Integer> it = g.getIterator(v); it.hasNext(); ) {
            int w = it.next();
            if (!marked(w)){
                edgeTo[w]=v;
                dfs(g,w);
            }
        }
    }
    public boolean hasPathTo(int v)
    {
        return marked(v);
    }
    public Iterator<Integer> pathTo(int v)
    {
        if (!hasPathTo(v))return null;
        Stack<Integer> path=new Stack<>();
        for (int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path.iterator();
    }

    private boolean marked(int w) {
    return marked[w];
    }
}
