package Main.usage;
public class location {
    private int x,y,z;
    public int getZ() {
        return z;
    }
    public location(int x, int y)
    {
        this.x=x;
        this.y=y;
        z=(int)(Math.random()*5);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
