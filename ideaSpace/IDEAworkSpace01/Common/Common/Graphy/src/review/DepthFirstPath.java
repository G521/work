package review;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPath {
    private boolean marked[];
    private  int edge[];
    private int s;
    public DepthFirstPath(Graphy g,int s)
    {
        this.s=s;
        edge=new int[g.getE()];
        marked=new boolean[g.getE()];
        dfg(g,s);
    }
    private void dfg(Graphy g,int s){
        marked[s]=true;
        for (Iterator<Integer> it = g.getIterator(s); it.hasNext(); ) {
            int k = it.next();
            if (!marked[k]){
                edge[k]=s;
                dfg(g,k);
            }
        }
    }
    public boolean hasPahtTo(int v){
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
