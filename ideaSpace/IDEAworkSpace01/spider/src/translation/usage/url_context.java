package translation.usage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
/**
 * 获得url内容
 */
public class url_context {
    private static URL url;
    private static HttpURLConnection connection;
    private static BufferedReader reader;
    public static String getContent(String u) throws IOException {
        StringBuilder content=new StringBuilder();
        url=new URL(u);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setRequestProperty("Cookie","ssoflag=0; webp_enabled=0; wlsource=ext360key29; wluuid=WLGEUST-EC5009B4-9142-4E5D-587F-98789713BB48; weilisessionid3=7127e4c03421386ab9c49253b50f3b0c; _ga=GA1.3.1096091198.1576462971; _gid=GA1.3.1000437823.1577611892");
        connection.setRequestProperty("Connection"," Keep-Alive");
        connection.setRequestProperty("Accept-Language","zh-Hans-CN, zh-Hans; q=0.5");
        connection.setRequestProperty("Accept-Encoding","gzip, deflate, br");
        connection.setRequestProperty("Accept","application/json, text/plain, */*");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362");
        connection.setRequestProperty("Host","stock.tuchong.com");
        connection.setRequestProperty("Cache-Control","no-cache");
        connection.setRequestProperty("Referer","https://stock.tuchong.com/search?term=%E5%AD%A6%E7%94%9FIT&use=0");
        connection.setRequestProperty("Upgrade-Insecure-Requests","1");
        connection.setRequestProperty("X-Requested-With","XMLHttpRequest");
        reader=new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
        String st=reader.readLine();
        while (st!=null){
            content.append(st+"\n");
            st=reader.readLine();
        }
        return content.toString();
    }
}
