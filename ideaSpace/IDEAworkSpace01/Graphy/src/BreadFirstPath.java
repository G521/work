import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadFirstPath {
    private boolean marked[];
    private int s;
    private int edge[];
    private LinkedBlockingQueue<Integer> mst;

    public BreadFirstPath(Graphy g) {
        this(g,0);
        marked=new boolean[g.getE()];
        edge=new int[g.getE()];
        mst=new LinkedBlockingQueue<>();
        try {
            bfs(g,0);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }

    public BreadFirstPath(Graphy g, int s) {
        this.s = s;
    }
    private void bfs(Graphy g,int v) throws InterruptedException {
     marked[v]=true;
        mst.add(s);
        while (!mst.isEmpty()){
            int e=mst.poll();
            for (Iterator<Integer> it = g.getIterator(v); it.hasNext(); ) {
                int k = it.next();
                mst.put(k);
                edge[k]=e;
            }
        }
    }
}
