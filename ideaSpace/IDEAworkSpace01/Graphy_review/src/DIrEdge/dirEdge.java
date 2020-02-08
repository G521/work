package DIrEdge;

public class dirEdge {
	private int v, w;
	private double weight;

	public dirEdge(int v,int w,double weight) {
		// TODO Auto-generated constructor stub
	this.v=v;
	this.w=w;
	this.weight=weight;
}

	public int form() {
		return v;
	}

	public int to() {
		return w;
	}
	public double getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String(v+"->"+w+" :"+weight);
	}
}
