package translation;

import translation.usage.getImg;
import translation.usage.url_context;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class baidu_spider{
    public static void main(String[] args) throws Exception {
        int count=1;
        for (String s : getcontext()) {
            for (String string : getImgUrl(url_context.getContent(s))) {
                if (string.contains("%"))continue;
//                System.out.println(string);
                    string=string.replaceAll("\\\\","");
                    string=string.replaceAll("http.*?\":\"","");
                    if (string.contains("img.tuguaishou"))continue;
                    string=string.substring(string.indexOf("http"));
                System.out.println(count++);
                getImg.download(string, "F:/pinganye/baidu/" + (int)(Math.random() * 99999999L) + System.currentTimeMillis() + ".jpg");
            } } }
    public static Queue<String> getImgUrl(String content){
        Queue<String> result=new LinkedList<>();
        String regex="https:.*?jpg";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(content);
        while (matcher.find()){
           String s=matcher.group();
//           s.replaceAll("src=\"","");
           result.add(s);
        }
        return result;
    }
    public static Queue<String> getcontext(){
        Queue<String> result=new LinkedList<>();
        String s="<a href=\"/i?q=%E9%AB%98%E6%B8%85%E5%B9%B3%E5%AE%89%E5%A4%9C%E5%9B%BE%E7%89%87%E7%B4%A0%E6%9D%90&amp;src=rel\n" +
                "<a href=\"/i?q=2019%E5%B9%B4%E5%9F%BA%E7%9D%A3%E6%95%99%E5%B9%B3%E5%AE%89%E5%A4%9C%E8%83%8C%E6%99%AF%E5%9B%BE%E7%89%87&amp;src=rel\n" +
                "<a href=\"/i?q=2019%E5%B9%B3%E5%AE%89%E5%A4%9C%E5%9B%BE%E7%89%87%E5%A4%A7%E5%85%A8&amp;src=rel\n" +
                "<a href=\"/i?q=2019%E5%B9%B3%E5%AE%89%E5%A4%9C%E5%9B%BE%E7%89%87&amp;src=rel\n" +
                "<a href=\"/i?q=ktv%E5%B9%B3%E5%AE%89%E5%A4%9C%E6%B4%BB%E5%8A%A8&amp;src=rel\n" +
                "<a href=\"/i?q=%E9%AB%98%E6%B8%85%E5%B9%B3%E5%AE%89%E5%A4%9C%E6%B5%B7%E6%8A%A5&amp;src=rel\n" +
                "<a href=\"/i?q=2019%E5%B9%B3%E5%AE%89%E5%A4%9C%E5%9B%BE%E7%89%87%E7%B4%A0%E6%9D%90&amp;src=rel\n" +
                "<a href=\"/i?q=2019%E5%B9%B4%E5%B9%B3%E5%AE%89%E5%A4%9Cppt%E8%83%8C%E6%99%AF%E5%9B%BE%E7%89%87&amp;src=rel\n" +
                "<a href=\"/i?q=2019%E5%B9%B4%E5%B9%B3%E5%AE%89%E5%A4%9C%E9%82%80%E8%AF%B7%E5%87%BD&amp;src=rel\n" +
                "<a href=\"/i?q=%E5%88%9B%E6%84%8F%E5%B9%B3%E5%AE%89%E5%A4%9C%E6%B5%B7%E6%8A%A5&amp;src=rel\n";
        String regex="<a href.*?rel";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(s);
        while (matcher.find()){
            String ss=matcher.group();
            ss=ss.replaceAll("<a href=\"","");
            ss=ss.replaceAll("\" data\n","");
            ss=ss.replaceAll("\" data","");
            ss="https://image.so.com/i?src=360pic_normal&z=1&i=0&cmg=cff5efd93bff0538f3ba53236839e288&q=%E7%8C%AB%E7%8C%AB"+ss;
            result.add(ss);
        }return result;
    }
}