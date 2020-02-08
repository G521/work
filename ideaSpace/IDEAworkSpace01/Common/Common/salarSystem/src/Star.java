import usage.myImage;

import java.awt.*;
public class Star {
    private Image img;
    int x,y;
    int r;
    public void draw(Graphics g){
        g.drawImage(img,x-r/2,y-r/2,r,r,null);
    }
    public Star(String imgpath,int x,int y,int r){
        this.r=r;
        img= myImage.getImage(imgpath);
        this.x=x;
        this.y=y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getSize(){return r;}
}
