package review_WeightGraphy;

import javax.xml.stream.events.EndDocument;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class lazyPrim {
    private boolean[] marked;
    private LinkedBlockingQueue<Edge> mst;
    private PriorityQueue<Edge> pq;
    public lazyPrim(EdgeWeightGraphy G){
        marked=new boolean[G.getE()];
        mst=new LinkedBlockingQueue<>();
        pq=new PriorityQueue<>();
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
    private void visit(EdgeWeightGraphy G,int s){
        marked[s]=true;
        for (Iterator<Edge> it = G.getIteraor(s); it.hasNext(); ) {
            Edge e = it.next();
            if (!marked[e.other(s)])pq.offer(e);
        }
    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        LinkedBlockingQueue<Edge> queue=new LinkedBlockingQueue<>(mst);
        while (!queue.isEmpty()){
            Edge e=queue.poll();
            str.append("\n"+e.either()+"  -"+e.other(e.either())+" ++ "+e.getWeight());
        }
        return str.toString();
    }
}
