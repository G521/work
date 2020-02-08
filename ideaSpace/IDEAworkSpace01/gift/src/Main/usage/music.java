package Main.usage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;

/**
 * 注意，播放音乐必须要用线程，因为我们是要图片和音乐一起播放，就必须是多线程的，否则的话，
 * 如果音乐先开始，就会一直放音乐，等音乐播放完才会开始放图片，先放图片就音乐播放不了。
 * 所以就用到线程，其实也很简单的，直接照着格式用就行了
 */
public class music extends Thread{
     Player player;
    @Override
    public void run() {
            try {
                //这个调用音频文件的和那个图片的方法也是相同的呢
                File file= new File(music.class.getClassLoader().getResource("Main/usage/music/first.mp3").getFile());
                //得到音频文件之后通过下面的方法播放
                player=new Player(new FileInputStream(file));
                player.play();//开启播放
            } catch (JavaLayerException e) {
//                e.printStackTrace();
            } catch (FileNotFoundException e) {
//                e.printStackTrace();
            }
    }

    /**
     * 在我们主类中要播放音乐直接在init()方法中添加下面两条语句就行了
     * @param args
     */
    public static void main(String[] args) {
       music music= new music();
       music.start();
       //必须是用线程的start（）方法，这样才是新建一个线程，
        // 而run（）方法是仅仅调用run（）方法，而不是我们期望的新建一个线程；
    }
}