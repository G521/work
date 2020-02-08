package translation;

import java.io.BufferedReader;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;

import java.math.BigInteger;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 查查 {
    private static final String key="Gu0fnkEDNhgvRJFKmxTA";
    public static final String appid="20190206000264030";
    public static String result(String info,String from,String to) {
        //接口地址
        String requestUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate/";
        //params用于存储要请求的参数
        Map params = new HashMap();
        //showapi_appid的值，把###替换成你的appid
        params.put("appid", "20190206000264030");
        long salt= (long) (new Date().getTime()+7897988*Math.random());
        String query=info;
        params.put("from",from);
        params.put("to",to);
        String q=appid+info+salt+key;
        String sign=getMD5String(q);
        params.put("q",info);
        params.put("salt",salt);
        params.put("sign",sign);
//        params.put("sign","0d3389d9dea66ae1");
        //数字签名，###填你的数字签名，可以在你的个人中心看到
        //调用httpRequest方法，这个方法主要用于请求地址，并加上请求参数
        String string = httpRequest(requestUrl, params);
        //处理返回的JSON数据并返回
        String s=string.replaceAll("\\{\"from.*\",\"","");
        s=s.replaceAll("dst\":\"","");
        s=s.replaceAll("\"}]}","");
        return  s;
    }
    public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private static String httpRequest(String requestUrl,Map params) {

        //buffer用于接受返回的字符
        StringBuffer buffer = new StringBuffer();
        try {
            //建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestUrl+"?"+urlencode(params));
            //打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            //获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            //断开连接
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串
        return buffer.toString();
    }
    public static String urlencode(Map<String,Object>data) {
        //将map里的参数变成像 showapi_appid=###&showapi_sign=###&的样子
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {

                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");

            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();

            }
        }
        return sb.toString();
    }
    public static String unicodeToString(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);// 转换出每一个代码点
            string.append((char) data);// 追加成string
        }
        return string.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String result = 查查.result(in.nextLine(), "en", "zh");
            if (result.startsWith("\\u")) {
                System.out.println(unicodeToString(result));
            } else {
                System.out.println(result);
            }
        }
    }
}
