package DIrEdge;
import java.beans.IntrospectionException;
import java.util.HashMap;
public class sbGraphy {
	private diwiGraphy graphy;
	private HashMap<String, Integer> map;
	private int E;
	private String name[];
	public sbGraphy(int V) {
		// TODO Auto-generated constructor stub
	graphy=new diwiGraphy(V);
	this.E=0;
	name=new String[V];
	map=new HashMap<String, Integer>();
	}
	public void addEdge(String v,String w,double weight) {
		// TODO Auto-generated method stub
		if (!map.containsKey(v)) {
			map.put(v, map.size());
			name[E++]=v;
		}
		if (!map.containsKey(w)) {
			map.put(w, map.size());
			name[E++]=w;
			}
		graphy.addAdj(new dirEdge(map.get(v),map.get(w),weight));
		}
	public String getName(int inde) {
		return name[inde];
	}
    public diwiGraphy getGraphy() {
		return graphy;
	}
}
