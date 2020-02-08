package DIrEdge;

import java.util.Iterator;

public class DijikstraAll {
	private Dijkstra[] allDijkstras;
	public DijikstraAll(diwiGraphy G) {
		// TODO Auto-generated constructor stub
	for (int i = 0; i < G.getV(); i++) {
		allDijkstras[i]=new Dijkstra(G,i);
	}
	}
	public Iterator<dirEdge> pathTo(int v,int w){
		return allDijkstras[v].pathTo(w);
	}
}
