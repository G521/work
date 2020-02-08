package DIrEdge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.IntToDoubleFunction;
/*
 * 
8 15
4 5 0.35
5 4 0.35
4 7 0.37
5 7 0.28
7 5 0.28
5 1 0.32
0 4 0.38
0 2 0.26
7 3 0.39
1 3 0.29
2 7 0.34
6 2 0.40
3 6 0.52
6 0 0.58
6 4 0.93
 */
public class Dijkstra {
	private TreeMap<Integer,Double> pq;
	private double distTo[];
	private dirEdge[] Edgeto;
	public Dijkstra(diwiGraphy G,int start) {
		// TODO Auto-generated constructor stub
	pq=new TreeMap<Integer, Double>();
	distTo=new double[G.getV()];
	Edgeto=new dirEdge[G.getV()];
	for (int i = 0; i < distTo.length; i++) {
		distTo[i]=Double.MAX_VALUE;
	}
	distTo[start]=0.0;
	pq.put(start,0.0);
	while (!pq.isEmpty()) {
		relax(G, pq.pollFirstEntry().getKey());
	}
	}
	private void relax(diwiGraphy G,int v) {
		// TODO Auto-generated method stub
		G.getEdgeIterator(v).forEachRemaining(a->
		{
			int w=a.to();
			if (distTo[w]>distTo[v]+a.getWeight()) {
				Edgeto[w]=a;
				distTo[w]=distTo[v]+a.getWeight();
				pq.put(w,distTo[w]);
			}
		});
	}
	public boolean hasPathTo(int w) {
		return distTo[w]<Double.MAX_VALUE;
	}
	public Iterator<dirEdge> pathTo(int w){
		if(!hasPathTo(w))return null;
		Stack<dirEdge> stack =new Stack<dirEdge>();
		for(dirEdge dEdge=Edgeto[w];dEdge!=null;dEdge=Edgeto[dEdge.form()]) {
			stack.push(dEdge);
		}
		return stack.iterator();
	}
}
