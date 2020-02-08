package 创建者模式.singleton;

/**
 * 静态内部类实现
 * 具有延时加载 和线程安全 调用效率高
 */
public class singlePattern_3 {
    private static class singlePattern{
        public static singlePattern_3 instance=new singlePattern_3();
    }
    private singlePattern_3(){}
    public static singlePattern_3 getInstance(){
        return singlePattern.instance;
    }
}
