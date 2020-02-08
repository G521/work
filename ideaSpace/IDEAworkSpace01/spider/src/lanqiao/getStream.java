package lanqiao;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
/**
 * 获得url内容
 */
public class getStream {

    JButton
    private static URL url;
    private static HttpURLConnection connection;
    private static BufferedReader reader;
    public static String getContent(String u) throws IOException {
        StringBuilder content=new StringBuilder();
        url=new URL(u);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setRequestProperty("Cookie","Hm_lpvt_a808a1326b6c06c437de769d1b85b870=1579186955; c196c3667d214851b11233f5c17f99d5_gr_cs1=562374348; t=72419AFBC0BBEA16F8C84DF41369936F; NOWCODERUID=D3B8344BB8C04D83A0A6F2D6C4ED4321; NOWCODERCLINETID=3CCDDB554A26C06D796D56425C9D0D79; Hm_lvt_a808a1326b6c06c437de769d1b85b870=1578143649,1578466581,1578578294,1579186955; gr_user_id=40037e1e-5270-43e9-bd33-e77798e676d1; grwng_uid=948d3ab5-28ef-45b9-88a8-849e6b05c883; c196c3667d214851b11233f5c17f99d5_gr_last_sent_cs1=562374348; c196c3667d214851b11233f5c17f99d5_gr_session_id=33f3a087-8c54-4d4f-a0c1-c3a287e3bc48; c196c3667d214851b11233f5c17f99d5_gr_last_sent_sid_with_cs1=33f3a087-8c54-4d4f-a0c1-c3a287e3bc48; c196c3667d214851b11233f5c17f99d5_gr_session_id_33f3a087-8c54-4d4f-a0c1-c3a287e3bc48=true; SERVERID=e3ae776ec93508137541be6e8f3453bb|1579186954|1579186954");
//        connection.setRequestProperty("Connection"," Keep-Alive");
        connection.setRequestProperty("Accept-Language","zh-Hans-CN, zh-Hans; q=0.5");
        connection.setRequestProperty("Accept-Encoding","gzip, deflate, br");
        connection.setRequestProperty("Accept","text/html, application/xhtml+xml, application/xml; q=0.9, */*; q=0.8");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362");
        connection.setRequestProperty("Host","ac.nowcoder.com");
//        connection.setRequestProperty("Pragma","no-cache");
        connection.setRequestProperty("Upgrade-Insecure-Requests","1");
//        connection.setRequestProperty("Proxy-Connection","Keep-Alive");
        connection.setRequestProperty("Cache-Control","no-cache");
          reader=new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
        String st=reader.readLine();
        while (st!=null){
            content.append(st+"\n");
            st=reader.readLine();
        }
        return content.toString();
    }

    public static void main(String[] args) throws IOException {
        String url ="http://poj.org/problem?id=1001";
        System.out.println(getContent(url));
    }
}
