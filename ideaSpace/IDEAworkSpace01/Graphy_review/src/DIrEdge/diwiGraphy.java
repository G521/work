package DIrEdge;
import java.util.HashSet;
import java.util.Iterator;
public class diwiGraphy {
	private int E,V;
	private HashSet<dirEdge>[] adj;
	public diwiGraphy(int V) {
		// TODO Auto-generated constructor stub
	this.V=V;
	this.E=0;
	adj=new HashSet[V];
	for (int i = 0; i < adj.length; i++) {
		adj[i]=new HashSet<dirEdge>();
	}
	}
	public void addAdj(dirEdge edge) {
		int v=edge.form();
		adj[v].add(edge);
		E++;
	}
	public Iterator<dirEdge> getEdgeIterator(int v) {
		return adj[v].iterator();
	}
	public int getV() {
		return V;
	}
	public int getE() {
		return E;
	}
	public diwiGraphy reverse() {
		diwiGraphy reverse=new diwiGraphy(V);
		for (int i = 0; i < V; i++) {
			for ( dirEdge edge: adj[i]) {
				reverse.addAdj(new dirEdge(edge.to(),edge.form(),edge.getWeight()));
			}
		}
		return reverse;
	}
}
