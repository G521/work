package usage.music;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class music_eat extends Thread{
    long start=System.currentTimeMillis();
    @Override
    public void run() {
        try {
            File file= new File("Doudou\\src\\music\\eat.mp3");
            Player player=new  Player(new BufferedInputStream(new FileInputStream(file)));
            player.play();
            player.close();

        } catch (JavaLayerException e) {

        } catch (FileNotFoundException e) {
        }
    }
}