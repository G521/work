package 创建者模式.prototype;

import java.io.*;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Sheep s1 = new Sheep("zhangzang",new Date(123121));
        System.out.println(s1);
//        Sheep s2 = (Sheep) s1.clone();
//        System.out.println(s2);
        //使用序列化和反序列化实现实现深复制
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[]  bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s2 = (Sheep) ois.readObject();
        s1.setBirthday(new Date(9999999));
        System.out.println("++++++++++++++++++++");
        System.out.println(s1);
        System.out.println(s2);

    }
}
