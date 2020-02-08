package WeightGraphy;
import java.security.PublicKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class EdgeWeightGraphy {
    private final int V;
    private int E;
    private HashSet<Edge>[] adj;
    public EdgeWeightGraphy(Scanner in){
        this(in.nextInt());
        int e=in.nextInt();
        for (int i = 0; i <e ; i++) {
            addAdj(new Edge(in.nextInt(),in.nextInt(),in.nextDouble()));
        }
    }
    public EdgeWeightGraphy(int v) {
        V = v;
        this.E=0;
        adj=new HashSet[V];
        for (int i = 0; i <V; i++) {
            adj[i]=new HashSet<>();
        }
    }
    public int getV() {
        return V;
    }
    public int getE() {
        return E;
    }
    public void addAdj(Edge edge){
        int v=edge.either();
        int w=edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }
    public Iterator<Edge> getIterator(int v){
        return adj[v].iterator();
    }
}
