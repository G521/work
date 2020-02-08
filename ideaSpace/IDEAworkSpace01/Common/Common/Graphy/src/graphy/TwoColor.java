package graphy;

import java.util.Iterator;

public class TwoColor {
    private boolean[] marked;
    private boolean[] Color;
    private boolean isTwoGraphy=true;
    public TwoColor(graphy g){
        marked=new boolean[g.getE()];
        Color=new boolean[g.getE()];
        for (int s = 0; s <g.getE() ; s++) {
            if (!marked[s])
                dfs(g,s);
        }
    }
    private void dfs(graphy g,int v){
        marked[v]=true;
        for (Iterator<Integer> it = g.getIterator(v); it.hasNext(); ) {
            int k = it.next();
            if (!marked[k]){
                marked[k]=true;
                Color[k]=!Color[v];
                dfs(g,k);
            }else if (Color[k]==Color[v])isTwoGraphy=false;
        }
    }
    public boolean isTwoGraphy() {
        return isTwoGraphy;
    }
}
