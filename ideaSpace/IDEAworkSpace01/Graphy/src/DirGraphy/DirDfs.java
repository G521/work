package DirGraphy;
import review.Graphy;
import java.util.Iterator;
public class DirDfs {
    private boolean[] markde;
    public DirDfs(dirGraphy graphy,int s){
        markde =new boolean[graphy.getE()];
    }
    private void dfs(dirGraphy graphy,int s){
        markde[s]=true;
        for (Iterator<Integer> it = graphy.getIterator(s); it.hasNext(); ) {
            int k = it.next();
            if (!markde[k]){ dfs(graphy,k); }
        }
    }
    private void dfs(dirGraphy g,Iterator<Integer> iterator){
        for (Iterator<Integer> it = iterator; it.hasNext(); ) {
            int k = it.next();
            if (!markde[k])
            dfs(g,k);
        }
    }
    private boolean marked(int w){
        return markde[w];
    }
}
