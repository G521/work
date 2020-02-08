package Server;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
public class server {
    private ServerSocket server;
    private LinkedList<channel> clients = new LinkedList<>();
    public static void main(String[] args) {
        new server();
    }
    public server() {
        try {
            server = new ServerSocket(8888); //打开端口
        } catch (IOException e) {
            e.printStackTrace();
        }
        new receive().start();     //接受客户端连接
        new receiveMsg().start();   //接受信息线程
    }
    private void sendSingle(channel client, String words) throws IOException {
        BufferedWriter writer;
        writer = client.getWriter();
        writer.write(words);
        writer.newLine();
        writer.flush();
    }
    private void sendOthers(channel client, String words) throws IOException {
        for (channel channel : clients) {
            if (client == channel) continue;
            sendSingle(channel, words);
        }
    }
    class receiveMsg extends  Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                for (int i = 0; i < clients.size(); i++) {
                    channel client=clients.get(i);
                    if (client.getMsg()==null)continue;
                    String str=client.getMsg();
                    System.out.println(str);
                    if (str!=null) {
                        try {
                            sendOthers(client,str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else continue;
                }
            }
        }
    }
    class receive extends  Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Socket socket=server.accept();
                    if (socket!=null){
                        channel n=new channel(socket);
                        clients.add(n);
                        sendOthers(n,n.getName()+"  进入聊天室！");
                        n.getWriter().write("欢迎进入聊天室！！");
                        n.getWriter().newLine();
                        n.getWriter().flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

