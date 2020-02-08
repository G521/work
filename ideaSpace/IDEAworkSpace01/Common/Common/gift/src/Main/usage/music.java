package Main.usage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;
public class music extends Thread{
    static Player player;
    @Override
    public void run() {
            try {
                player=new Player(new FileInputStream(new File("src\\music\\first.mp3")));
                player.play();
                player=null;
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
       music music= new music();
       music.start();
    }
}