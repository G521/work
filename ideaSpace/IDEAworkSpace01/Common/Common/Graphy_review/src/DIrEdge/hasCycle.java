package DIrEdge;
import java.util.Iterator;
import java.util.Stack;
public class hasCycle {
	private diwiGraphy G;
	private boolean[] onStack;
	private boolean[] marked;
	private boolean isCycle;
	private int[] edgeTo;
	private Stack<Integer> stack;
	public hasCycle(diwiGraphy G) {
		// TODO Auto-generated constructor stub
	this.G=G;
	onStack=new boolean[G.getV()];
	marked=new boolean[G.getV()];
	edgeTo=new int[G.getV()];
	for (int i = 0; i < marked.length; i++) {
		if (!marked[i]) {
			dfs(G, i);
		}
	}
	}
	private void dfs(diwiGraphy G,int v) {
		// TODO Auto-generated method stub
		onStack[v]=true;
		marked[v]=true;
		G.getEdgeIterator(v).forEachRemaining(ele->
		{
			if (isCycle) {return;}
			int w=ele.to();
			if (!marked[w]) {
				edgeTo[w]=v;
				dfs(G, w);
			}else if (onStack[w]) {
			 stack=new Stack<Integer>();
			for(int x=v;x!=w;x=edgeTo[x])
				stack.push(x);
				stack.push(w);
				stack.push(v);
			}
		});
			onStack[v]=false;
	}
	public boolean isCycle() {
		return edgeTo==null;
	}
	public Iterator<Integer> cycle() {
		return stack.iterator();
		
	}
}
