package Main.start;
import Main.Frame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class game extends Thread {
    private boolean isOver;
    Player player;
    Frame frame;
    @Override
    public void run() {
         frame= new Frame();
        isOver=true;
    }
    public boolean isOver() {
        return isOver;
    }
    public int getGoal(){
        if (frame==null)return 0;
        return frame.getGoal();
    }
    public boolean isGameover() {
        return (frame!=null&&frame.isGameOver());
    }
    class music extends Thread {
        @Override
        public void run() {
            try {
                File file = new File("src\\music\\second.mp3");
                player=new Player(new BufferedInputStream(new FileInputStream(file)));
                player.play();
            } catch (JavaLayerException e) {
            } catch (FileNotFoundException e) {
            }
        }
    }
}