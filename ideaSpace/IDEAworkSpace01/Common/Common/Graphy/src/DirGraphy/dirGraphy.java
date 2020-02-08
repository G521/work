package DirGraphy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
public class dirGraphy {
    private int E;
    private HashSet<Integer>[] edges;
    private dirGraphy(int V){
        E=0;
        edges=new HashSet[V];
        for (int i = 0; i <V ; i++) { edges[i]=new HashSet<>(); }
    }
    public dirGraphy(Scanner in){
        this(in.nextInt());
        int E=in.nextInt();
        for (int i = 0; i <E ; i++) {
            addEdge(in.nextInt(),in.nextInt());
        }
    }
    public int getE() {
        return E;
    }
    public Iterator<Integer> getIterator(int v){
        return edges[v].iterator();
    }
    public dirGraphy reverese()
    {
        dirGraphy reverst=new dirGraphy(E);
        for (int i = 0; i <E ; i++) {
            for (Iterator<Integer> it = reverst.getIterator(i); it.hasNext(); ) {
                int w = it.next();
                reverst.addEdge(i,w);
            }
        }
        return reverst;
    }

    public void addEdge(int w, int v){
        edges[w].add(v);
        E++;
    }
}
