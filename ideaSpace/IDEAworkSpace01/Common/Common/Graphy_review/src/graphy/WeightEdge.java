package graphy;

public class WeightEdge implements Comparable<WeightEdge>{
	private int v,w;
	private double weight;
	public WeightEdge(int v,int w,double d) {
		// TODO Auto-generated constructor stub
	this.v=v;
	this.w=w;
	this.weight=d;
	}
	public int eight() {
		return v;
	}
	public int other(int v)
	{
		return v==v?w:v;
	}
	public double getWeight() {
		return weight;
	}
	@Override
	public int compareTo(WeightEdge arg0) {
		// TODO Auto-generated method stub
		if (weight<arg0.getWeight()) {
			return -1;
		}
		else if (weight==arg0.getWeight()) {
			return 0;
		}
		return 1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return v+"->"+w+": "+weight;
	}
}
