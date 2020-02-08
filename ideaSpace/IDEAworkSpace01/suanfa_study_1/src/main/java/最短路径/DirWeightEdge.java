package 最短路径;

public class DirWeightEdge {
    private int v, w;
    private double weight;

    public DirWeightEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int from(){
        return v;
    }
    public int to(){
        return w;
    }
    public double getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return new String(v+"->"+w+" :"+weight);
    }
}