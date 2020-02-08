package WeightGraphy;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
/*
8 16
4 5 0.35
4 7 0.37 5 7 0.28 0 7 0.16 1 5 0.32 0 4 0.38 2 3 0.17 1 7 0.19 0 2 0.26 1 2 0.36 1 3 0.36 2 7 0.34 6 2 0.40 3 6 0.52 6 0 0.58 6 4 0.93
 */
public class Prim {
    private boolean marked[];
    private LinkedBlockingQueue<Edge> mst;
    private PriorityQueue<Edge> pq;
    public Prim(EdgeWeightGraphy G){
        marked=new boolean[G.getE()];
        mst=new LinkedBlockingQueue<>();
        pq=new PriorityQueue<>(10);
        visit(G,0);
        while (!pq.isEmpty()){
            Edge e=pq.poll();
            int v=e.either();
            int w=e.other(v);
            if (marked[v]&&marked[w])continue;
            mst.add(e);
            if (!marked[v])visit(G,v);
            if (!marked[w])visit(G,w);
        }
    }
    private void visit(EdgeWeightGraphy g, int i) {
    marked[i]=true;
        for (Iterator<Edge> it = g.getIterator(i); it.hasNext(); ) {
            Edge k = it.next();
            boolean re=!marked[k.other(i)];
            if (re)pq.offer(k);
        }
    }
    public Iterator<Edge> edges(){
        return mst.iterator();
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        LinkedBlockingQueue<Edge> queue=new LinkedBlockingQueue(mst);
        while (!queue.isEmpty()){
            Edge e= queue.poll();
            str.append(e.either()+"-"+e.other(e.either())+"--"+e.getWeight()+"   ");
        }
        return str.toString();
    }
}