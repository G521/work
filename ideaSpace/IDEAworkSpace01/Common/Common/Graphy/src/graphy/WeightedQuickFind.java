package graphy;
public class WeightedQuickFind{
    private int id[];
    private int sz[];
    private int count;
    public WeightedQuickFind(int V){
        id=new int[V];
        count=V;
        for (int i = 0; i <V ; i++){id[i]=i; }
        sz=new int[V];
        for (int i = 0; i <V ; i++){ sz[i]=1; }
    }
    private int find(int k){
        while (k!=id[k])
           k=id[k];
        return k;
    }
    public void union(int v,int w){
        int i=find(v);
        int j=find(w);
        if (i==j)return;
        if (sz[i]>sz[j]){id[j]=id[i];sz[i]+=sz[j];}
        else {id[i]=id[j];sz[j]+=sz[i];
        } count--;
    }
    public boolean connected(int v,int w){
        return find(v)==find(w);
    }
}
