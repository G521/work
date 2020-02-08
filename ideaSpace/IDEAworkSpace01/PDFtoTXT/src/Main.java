import java.io.*;
import java.nio.charset.Charset;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<String,String> words=new HashMap<>();
        File mywords=new File("D:\\words.txt");
        mywords.createNewFile();
        File file=new File("F:/words");
        for (File listFile : file.listFiles()) {
            for (File list :listFile.listFiles()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(list),"GBK"));
                String english = reader.readLine();
                String fanyi = reader.readLine();
                while (fanyi != null && !fanyi.equals("") && english != null && !english.equals("")) {
                    words.put(english, fanyi);
                    english=reader.readLine();
                    fanyi=reader.readLine();
                }System.out.println("一个文件已经弄完");
            }
            System.out.println("一个文件已经弄完");
        }
        File my=new File("C:\\Users\\Void\\Desktop\\EnglishWords (1).txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(my),"GBK"));
        String english ="   ";
        String fanyi ="";
        while (fanyi != null  && english != null ) {
            english = reader.readLine();
            fanyi = reader.readLine();
            if (fanyi==null||english==null)break;
            if (fanyi.startsWith("  ")||english.startsWith("  "))continue;
            words.put(english, fanyi);

        }
        ObjectOutputStream obi=new ObjectOutputStream(new FileOutputStream(mywords));
        obi.writeObject(words);
        words= (HashMap<String, String>) new ObjectInputStream(new FileInputStream("D:/words.txt")).readObject();
        HashMap<String, String> finalWords = words;
        words.keySet().forEach(w-> System.out.println(w+"\r\n"+ finalWords.get(w)+""));
        System.out.println(words.size());
    }
}