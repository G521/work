package 创建者模式.singleton;

/**
 * 懒汉式单例模式    lazy load
 *资源利用率高但是，每次调用getInstance（）方法都要同步，并发效率较低
 */
public class singlePattern_L {
    private  static singlePattern_L singlePattern_l;
    private singlePattern_L(){}
    public static synchronized singlePattern_L getInstance(){
        if (singlePattern_l==null){
            singlePattern_l=new singlePattern_L();
        }
        return singlePattern_l;
    }
    //反序列化
    private Object readResolve(){
        return getInstance();
    }
}
