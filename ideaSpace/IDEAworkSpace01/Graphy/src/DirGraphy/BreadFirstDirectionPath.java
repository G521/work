package DirGraphy;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
public class BreadFirstDirectionPath {
    private  boolean marked[];
    private int s;
    private int[] edge;
    private LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue();
    BreadFirstDirectionPath(dirGraphy graphy,int s){
        marked=new boolean[graphy.getE()];
        edge=new int[graphy.getE()];
        this.s=s;
        try {
            bfs(graphy,s);
        } catch (InterruptedException e) {
        }
    }
    private void bfs(dirGraphy graphy,int s) throws InterruptedException {
        marked[s]=true;
        queue.put(s);
        while (!queue.isEmpty()){
            int v=queue.poll();
            for (Iterator<Integer> it = graphy.getIterator(v); it.hasNext(); ) {
                int k = it.next();
                if (!marked[k]){
                    queue.put(k);
                    edge[k]=v;
                    marked[k]=true;
                }
            }
        }
    }
    public boolean marked(int w) {
        return marked[w];
    }

    public Iterator<Integer> pathTo(int s, int v){
        Stack<Integer> stack=new Stack<>();
        for (int i = v; i !=s ; i=edge[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack.iterator();
    }
}
