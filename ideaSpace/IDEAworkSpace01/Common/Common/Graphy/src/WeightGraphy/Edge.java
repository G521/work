package WeightGraphy;
public class Edge implements Comparable<Edge>{
    private int v;
    private int w;
    private double weight;
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public int either() {
        return v;
    }
    public int other(int v) {
        return (v==this.v?w:this.v);
    }
    @Override
    public int compareTo(Edge edge) {
        if (this.weight>edge.weight)return 1;
        else return (this.weight==edge.weight?0:-1);
    }
}
