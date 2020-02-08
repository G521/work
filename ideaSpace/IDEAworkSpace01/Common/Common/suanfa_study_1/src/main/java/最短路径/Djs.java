package 最短路径;
import java.util.*;

public class Djs {
    private DirWGraphy G;
    private double[] distTo;
    private DirWeightEdge edgeTo[];
    private TreeMap<Integer,Double>pq;
    public Djs(DirWGraphy g,int s) {
        G = g;
        distTo=new double[g.getV()];
        edgeTo=new DirWeightEdge[g.getV()];
        pq=new TreeMap<>();
        for (int i = 0; i < distTo.length; i++) {
            distTo[i]=Double.MAX_VALUE;
        }
        distTo[0]=0;
        pq.put(s,0.0);
        while (!pq.isEmpty())relax(pq.pollFirstEntry().getKey());
    }
    private void relax(int v){
        for (Iterator<DirWeightEdge> it = G.getEdges(v); it.hasNext(); ) {
            DirWeightEdge edge = it.next();
            int w=edge.to();
            if (distTo[w]>distTo[v]+edge.getWeight()){
                edgeTo[w]=edge;
                distTo[w]=distTo[v]+edge.getWeight();
                pq.put(w,distTo[w]);
            }

        }
    }
    public double distTo(int targer){
        return distTo[targer];
    }
    public boolean hasPathTo(int target){
        return distTo[target]<Double.MAX_VALUE;
    }
    public Iterator<DirWeightEdge> PathTo(int target){
        if (!hasPathTo(target))return null;
        Stack<DirWeightEdge> stack=new Stack();
        for (DirWeightEdge edge=edgeTo[target];edge!=null;edge=edgeTo[edge.from()]){
            stack.add(edge);
        }
        return stack.iterator();
    }
}
