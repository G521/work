import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPath {
    private boolean[] marked;
    private int edge[];
    private int s;
    public DepthFirstPath(Graphy g,int s){
        marked=new boolean[g.getE()];
        edge=new int[g.getE()];
        dfs(g,0);
    }
    public DepthFirstPath(Graphy g){
        this(g,0);
    }
    private void dfs(Graphy g,int v){
        marked[v]=true;
        for (Iterator<Integer> it = g.getIterator(v); it.hasNext(); ) {
            int k = it.next();
            if (!marked[k]){
                edge[k]=v;
                dfs(g,k);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterator<Integer> pathTo(int v){
        Stack<Integer> stack=new Stack<>();
        for (int k=v;k!=s;k=edge[k]){
            stack.push(k);
        }
        stack.push(s);
        return stack.iterator();
    }
}
