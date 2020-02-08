package client;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class client {
    BufferedReader reader;
    BufferedWriter writer;
    Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public client(){

        try {
            Socket socket=new Socket(InetAddress.getLocalHost(),8888);
            reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String send="";
            new reader().start();
            while (true) {
                if ((send = in.nextLine()) != null && !send.equals("")) {
                    writer.write(send);
                    writer.newLine();
                    writer.flush();
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class reader extends Thread {
        @Override
        public void run() {
            while (true) {
                String string = null;
                try {
                    string = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (string != null && !string.equals("")) System.out.println(string);
            }
        }
    }
    public static void main(String[] args) {
        new client();
    }
}
