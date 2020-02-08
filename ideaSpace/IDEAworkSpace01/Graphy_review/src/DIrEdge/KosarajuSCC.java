package DIrEdge;

public class KosarajuSCC {
     private boolean[] marked;
     private int[] id;
     private int count;
     public KosarajuSCC(diwiGraphy G) {
		// TODO Auto-generated constructor stub
    	 DepthFirstOrder order=new DepthFirstOrder(G.reverse());
    	 marked=new boolean[G.getV()];
    	 id=new int[G.getV()];
    	order.order().forEachRemaining(a->{
    	if (!marked[a]) {
			dfs(G, a);
			count++;
		}	
    	});
     }
     private void dfs(diwiGraphy G,int v) {
		// TODO Auto-generated method stub
    	 marked[v]=true;
    	 id[v]=count;
    	 G.getEdgeIterator(v).forEachRemaining(a->{
    		 if (!marked[a.to()]) {
				dfs(G, a.to());
			}
    	 });
	}
     public boolean strongly(int v,int w) {
		return id[v]==id[w];
	}
}
