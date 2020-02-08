package DIrEdge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstOrder {
	private Stack<Integer> post;
	private boolean marked[];
	public DepthFirstOrder(diwiGraphy G) {
		// TODO Auto-generated constructor stub
	post =new Stack<Integer>();
	marked=new boolean[G.getV()];
	for (int i = 0; i < marked.length; i++) {
		if (!marked[i]) {
			dfs(G,i);
		}
	}
}
	private void dfs(diwiGraphy G,int v) {
		// TODO Auto-generated method stub
		
		marked[v]=true;
		G.getEdgeIterator(v).forEachRemaining(ele->
		{
			int w=ele.to();
			if (!marked[w]) {
				dfs(G, w);
			}
		});
		post.push(v);
	}
	public Iterator<Integer> order(){
		LinkedList<Integer> list=new LinkedList<Integer>();
		while (!post.isEmpty()) {
			list.add(post.pop());
		}
		return list.iterator();
	}
}
