import org.trans.GoogleApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class translation {
    public static void translate(String target) {
        String str = "http://tran.httpcn.com/en/?wd="+target;
        String context= null;
        try {
            context = getHtml(str,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String regex="<span class=\"span2\">.+</span>";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher =pattern.matcher(context);
        matcher.find();
        String result=matcher.group();
        if (result==null||result=="")
        result="不好意思，人家没找到嘛~~\n这也不能怪人家嘛~，\n我也是从网上找的，网上没有我也没办法嘛~";
        result=result.replace("<span class=\"span2\">","");
        result=result.replace("</span>　<span class=\"span3\">详细</span>","");
        System.out.println(result);
    }


    public static String getHtml(String url, String encoding) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader bf = null;
        InputStreamReader isr = null;
        try {
            //创建网络连接
            //
            //
            URL url1 = new URL(url);
            //打开网络
            URLConnection uc = url1.openConnection();
            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");    //建立文件输入流
             isr=new InputStreamReader(uc.getInputStream(),encoding);
            // 高效率读取
            bf = new BufferedReader(isr);    //下载页面源码
            String temp = null;
            while ((temp = bf.readLine()) != null) {
                sb.append(temp + "\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    //  e.printStackTrace();
                    //  }
                isr.close();
                }
            }
            return sb.toString();
        }
    }
}