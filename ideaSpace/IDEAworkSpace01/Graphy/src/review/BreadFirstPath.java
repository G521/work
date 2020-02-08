package review;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
public class BreadFirstPath {
    private boolean marked[];
    private int[] edge;
    private int s;
    public BreadFirstPath(Graphy g,int s){
        this.s=s;
        edge=new int[g.getE()];
        marked=new boolean[g.getE()];
        try {
            bfs(g,s);
        } catch (InterruptedException e) {}
    }
    private void bfs(Graphy g,int s) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>();
        marked[s]=true;
        queue.put(s);
        while (!queue.isEmpty()) {
            int v=queue.poll();
            for (Iterator<Integer> it = g.getIterator(v); it.hasNext(); ) {
                int k = it.next();
                if (!marked[k]) {
                edge[k]=v;
                marked[k]=true;
                queue.put(k);
                }
            }
        }
    }
    public Iterator<Integer> pathTo(int v)
    {
        Stack<Integer> stack=new Stack<>();
        for (int i = v; i !=s ; i=edge[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack.iterator();
    }
}
