package DIrEdge;

import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;

public class Dijokstra2 {
		private double distTo[];
		private TreeMap<Integer, Double> pq;
		private dirEdge[] edgeTo;
		public Dijokstra2(diwiGraphy G) {
			// TODO Auto-generated constructor stub
		distTo=new double[G.getV()];
		pq=new TreeMap <Integer, Double>();
		edgeTo=new dirEdge[G.getV()];
		for (int i = 0; i < distTo.length; i++) {
			distTo[i]=Double.MAX_VALUE;
		}
		Topological cTopological =new Topological(G);
		cTopological.getOrder().forEachRemaining(a->
		{
			dfs(G, a);
		});
		}
		private void dfs(diwiGraphy g, int start) {
			// TODO Auto-generated method stub
			g.getEdgeIterator(start).forEachRemaining(a->
			{
				int w=a.to();
				if (distTo[w]>distTo[start]+a.getWeight()) {
					distTo[w]=distTo[start]+a.getWeight();
					edgeTo[w]=a;
					pq.put(w, distTo[w]);
				}
			});
		}
		public boolean hasPathTo(int v) {
			return distTo[v]<Double.MAX_VALUE;
		}
		public Iterator<dirEdge> pathTo(int v){
			if (!hasPathTo(v)) {return null;}
			Stack<dirEdge> stack =new Stack<dirEdge>();
			for(dirEdge edge=edgeTo[v];edge!=null;edge=edgeTo[edge.form()]) {
				stack.push(edge);
			}
			return stack.iterator();
		}
}
