package Main;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class startMusic extends Thread{
    @Override
    public void run() {
        try {
            File file= new File("src\\music\\start1.mp3");
            new  Player(new BufferedInputStream(new FileInputStream(file))).play();
        } catch (JavaLayerException e) {
        } catch (FileNotFoundException e) {
        }
    }
    public static void main(String[] args) {
        new Main.usage.music().start();
    }
}
