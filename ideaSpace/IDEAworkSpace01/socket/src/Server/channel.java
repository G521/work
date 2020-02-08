package Server;
import java.io.*;
import java.net.Socket;

public class channel {
    private BufferedReader reader;
    private BufferedWriter writer;
    private String name;
    public channel(Socket socket){
        try {
            reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.name=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(String words){
        try {
            this.writer.write(words);
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getMsg(){
        String str="";
        try {
            str=reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str!=null&&!str.equals(""))return str;
        else return null;
    }
    public BufferedReader getReader() {
        return reader;
    }
    public BufferedWriter getWriter() {
        return writer;
    }
    public String getName() {
        return name;
    }
}
