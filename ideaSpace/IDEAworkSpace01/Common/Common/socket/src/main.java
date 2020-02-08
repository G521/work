import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class main {
    public void run(){
        try {
            Socket socket=new Socket("129.211.88.233",8888);
            System.out.println(socket.getInetAddress());
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str="";
            while (true){
                System.out.println(reader.readLine());
            }} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new main().run();
    }
}
