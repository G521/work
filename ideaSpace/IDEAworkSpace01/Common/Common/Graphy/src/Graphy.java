import java.security.PublicKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Graphy {
    private HashSet<Integer>[] adj;
    private int E;
    public Graphy(int V){
        adj=new HashSet[V];
        for (int i = 0; i <V ; i++) {
            adj[i]=new HashSet<>();
        }}
    public Graphy(Scanner in){
        this(in.nextInt());
        int e=in.nextInt();
        for (int i = 0; i <e ; i++) {
            int v=in.nextInt();
            int w=in.nextInt();
            addAdj(v,w); } }
    public Iterator<Integer> getIterator(int v){
        return adj[v].iterator();
    }
    public int getE() {
        return E;
    }

    public void  addAdj(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
}
