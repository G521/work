package 结构性模式.adapter;

/**
 * 被适配的类
 * 相当于键盘
 */
public class Adaptee {
    public  void request(){
        System.out.println("可以完成客户端需要的功能！");
    }
}
