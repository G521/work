package graphy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import javax.lang.model.element.Element;
import javax.sound.midi.Soundbank;
public class Ksi {
	private union_find find;
	private WeightGraphy G;
	HashSet<WeightEdge> mstEdges;
	TreeSet<WeightEdge> edges;
	private double weight;
	private int count;
	public Ksi(WeightGraphy G) {
		// TODO Auto-generated constructor stub
		this.G=G;
		mstEdges=new HashSet<WeightEdge>();
		find=new union_find(((WeightGraphy) G).getV());
		edges=new TreeSet<WeightEdge>();
		G.Edges().forEachRemaining(action->edges.add(action));
		while (!edges.isEmpty()&&mstEdges.size()<G.getV()-1) {
			visit(edges.pollFirst());
	}
}
	public void visit(WeightEdge edge) {
		int v=edge.eight();
		int w=edge.other(v);
		if (find.connected(v, w)) {
			return;
		}	
		find.connect(v,w);
		mstEdges.add(edge);
		weight+=edge.getWeight();
	}
	public double getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		StringBuilder wordString=new StringBuilder("** ");
//		mstEdges.forEach(action->wordString.append(action.eight()+"->"+action.other(action.eight())+":"+action.getWeight()+" "));
		mstEdges.forEach(ele->System.out.print(ele+"  "));
		return wordString.toString();
	}
}
