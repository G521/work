package graphy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class WeightGraphy {
	private HashSet<WeightEdge>[] adj;
	private int E,V;
		public WeightGraphy(int V) {
			// TODO Auto-generated constructor stub
		this.E=0;
		this.V=V;
		adj=new HashSet[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i]=new HashSet<WeightEdge>();
		}
	}
		public void addEdge(WeightEdge edge) {
			int v=edge.eight();
			int w=edge.other(v);
			adj[v].add(edge);
			adj[w].add(edge);
			E++;
		}
		public Iterator<WeightEdge> getEdges(int v){
			return adj[v].iterator();
		}
		public int getV() {
			// TODO Auto-generated method stub
			return V;
		}
		public Iterator<WeightEdge> Edges(){
		Stack<WeightEdge> edges=new Stack<WeightEdge>();
			for (int i = 0; i < V; i++) {
				int v=i;
				adj[i].forEach(action->{if (action.other(v)>v)edges.push(action);});
		}
			return edges.iterator();
		}
}
