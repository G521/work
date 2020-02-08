package JMST;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;
public class DJ {
    private double[] dist;
    private WeightDirEdge [] edgeTo;
    private TreeMap<Integer,Double> pq;
    private WDGraphy G;
    public DJ(WDGraphy G,int s){
        edgeTo=new WeightDirEdge[G.getE()];
        pq=new TreeMap<>();
        dist=new double[G.getV()];
        for (int i = 0; i < dist.length; i++) {
            dist[i]=Double.MAX_VALUE;
        }
        this.G=G;
        dist[s]=0;
        pq.put(s,0.0);
        while (!pq.isEmpty()){
            relax(G,pq.pollFirstEntry().getKey());
        }
    }
    private void relax(WDGraphy G,int s){
        for (Iterator<WeightDirEdge> it = G.getAdj(s); it.hasNext(); ) {
            WeightDirEdge edge = it.next();
            int w=edge.to();
            if (dist[w]>dist[s]+edge.getWeight()){
                edgeTo[w]=edge;
                dist[w]=dist[s]+edge.getWeight();
                pq.put(w,dist[w]);
            }
        }
    }
    public boolean hasPathTo(int w){
        return dist[w]<Double.MAX_VALUE;
    }
    public Iterator<WeightDirEdge> pathTo(int w){
        if (!hasPathTo(w))return null;
        Stack<WeightDirEdge> stack =new Stack<>();
        for (WeightDirEdge edge=edgeTo[w];edge!=null;edge=edgeTo[edge.getFrom()]){
            stack.push(edge);
        }
        return stack.iterator();
    }

}
