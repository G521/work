package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class translation {
    public static String transla(String target) {
        String str = String.format("http://www.ichacha.net/en/%s.html", target);
        str = String.format(str, target);
        StringBuilder context = new StringBuilder();
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(str);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String string = "";
            while (string != null) {
                string = reader.readLine();
                context.append(string);
                context.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return context.toString();
    }
    public static String translate(String targer) {
        String result_1 = transla(targer);
        StringBuilder reslut_2 = new StringBuilder();
        String regex = "<br />[\\s\\S]*<br />";
//        String regex="<div id=\"tabbox\"[\\s\\S]+</div></div></div>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result_1);
        while (matcher.find())
            reslut_2.append(matcher.group());
        String reslut = reslut_2.toString().replaceAll("<br />", "");
        reslut = reslut.replaceAll("。", "。\n");
        reslut = reslut.replaceAll("<br />","");
        reslut = reslut.replaceAll("<span class=\"pos\">","");
        reslut = reslut.replaceAll("</span>","");
        reslut = reslut.replaceAll("<span.*>","");
        return reslut;
    }
    public static void main(String[] args) {
        System.out.println(translate("hello"));
    }
    public static String changeCharset(String str, String oldCharset, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //用源字符编码解码字符串
             byte[] bs = str.getBytes(oldCharset);
             return new String(bs, newCharset);        }
        return null;    }

}