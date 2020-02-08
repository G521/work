package translation;

import com.sun.source.tree.Tree;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class language_kinds {
    public static void main(String[] args) throws IOException {
        File file=new File("D://language_kinds");
        file.createNewFile();
        ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(file));
        HashMap<String,String> language_kinds=new HashMap<>();
        String str=getUrl("http://www.ichacha.net/fanyi.aspx/en/fanyi.aspx");
        String regex="<option value=\".*</option>";
        Pattern pattern=Pattern.compile(regex);
        Matcher m =pattern.matcher(str);
        String str2="";
        while (m.find())
            str2+=m.group();
        String regex2="<option value=.{2,5}>";
        String regex3=">.{0,11}<";
        pattern=Pattern.compile(regex2);
        Pattern pattern1=Pattern.compile(regex3);
        Matcher m2=pattern.matcher(str2);
        Matcher m3=pattern1.matcher(str2);
        StringBuilder result1=new StringBuilder();
        StringBuilder result2=new StringBuilder();
        while (m2.find())
            result1.append(m2.group()+" ");
        while (m3.find())
            result2.append(m3.group()+" ");

//        System.out.println(result1);
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(result2);
        String resul1=result1.toString().replaceAll("<option value=\""," ");
        resul1=resul1.replaceAll("\"","");
        resul1=resul1.replaceAll(">","");
        String resul2=result2.toString().replaceAll("[\\w/<>\\\\—]"," ");
//
        String[] re1=resul1.split("\\s");
        String[] re2=resul2.split("\\s");
        Queue<String> treeSet1=new LinkedList<>();
        Queue<String> treeSet2=new LinkedList<>();
        for (int i = 0; i < re1.length; i++) {
            if (re1[i].equals(""))continue;
            treeSet1.add(re1[i]);
        }
        for (int i = 0; i < re2.length; i++) {
            if (re2[i].equals(""))continue;
            treeSet2.add(re2[i]);
        }
        while (!treeSet1.isEmpty())
            language_kinds.put(treeSet2.poll(),treeSet1.poll());
        language_kinds.put("中文简体","zh");
        obj.writeObject(language_kinds);
    }
    public static String getUrl(String urladdress){
        StringBuilder context=new StringBuilder();
        HttpURLConnection connection = null;
        URL url;
        try {
            url=new URL(urladdress);
            connection= (HttpURLConnection) url.openConnection();
            connection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String string="";
            while (string!=null) {
                string = reader.readLine();
                context.append(string);
                context.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
        return context.toString();

}
}
