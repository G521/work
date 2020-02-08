package DIrEdge;

import java.util.Iterator;

public class Topological {
	private Iterator<Integer> order;
	public Topological(diwiGraphy G) {
		// TODO Auto-generated constructor stub
	order=new DepthFirstOrder(G).order();
	order.forEachRemaining(s->System.out.println(s));
	}
	public Iterator<Integer> getOrder() {
		return order;
	}
}
