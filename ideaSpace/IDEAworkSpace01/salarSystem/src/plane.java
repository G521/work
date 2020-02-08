import usage.myImage;

import java.awt.*;
public class plane extends Star{
    private int cosX;
    public  int x;
    private boolean p=false;
    public  int y;
    private int cosY;
    private int size;
    Star center;
    private double speed;
    private Image image;
    private  double angle=Math.random()*360;
    public plane(Star center,int SizeR, int r,double speed,String path)
    {
        super(path,center.getX(),center.getY(),r);
        this.cosX=r;
        this.center=center;
        this.size=SizeR;
        this.cosY=(int)(r*(1.2));
        this.x=center.x+cosX+center.getSize()/2;
        this.y=center.y+cosY+center.getSize()/2;
        this.speed=speed;
        image = myImage.getImage(path);
    }
    public plane(plane center, int SizeR, int r,double speed,String path)
    {
        super(path,center.getX()+center.size/2,center.getY()+center.size/2,SizeR);
        this.center=center;
        this.cosX=r;
        this.size=SizeR;
        this.r=SizeR;
        this.cosY=(int)(r*(1.2));
        this.speed=speed;
        image = myImage.getImage(path);
    }
    public void draw(Graphics g)
    {
        x=center.getX()+(int)(cosX*Math.cos(angle));
        y=center.getY()+(int)(cosY*Math.sin(angle));
        angle+=speed;
        g.drawImage(image,x-size/2,y-size/2,size,size,null);
//        drawOval(g);
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getSize(){return size;}
}
