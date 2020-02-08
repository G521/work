package translation.usage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
public class getImg {
    static ByteArrayOutputStream by=new ByteArrayOutputStream();
    static FileOutputStream fileOutputStream;
    static URL url;
    static DataInputStream inputStream;
    public static void download(String urlString, String filename) throws Exception {
        // 构造URL
//        if (Math.random()>0.3)Thread.sleep(200);
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {

            os.write(bs, 0, len);

        }

        // 完毕，关闭所有链接

        os.close();

        is.close();

    }

}
