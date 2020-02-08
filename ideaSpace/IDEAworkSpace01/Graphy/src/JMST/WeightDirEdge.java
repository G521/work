package JMST;
public class WeightDirEdge {
    private  int v,w;
    private double weight;
    public WeightDirEdge(int v, int w, double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }
    public int getFrom(){
        return v;
    }
    public int to(){
        return w;
    }
    public double getWeight()
    {
        return weight;
    }
    @Override
    public String toString() {
        return String.format("%d->%d,%f  ",v,w,weight );
    }
}
