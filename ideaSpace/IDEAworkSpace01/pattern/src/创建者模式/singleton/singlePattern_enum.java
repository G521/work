package 创建者模式.singleton;

/**
 * 枚举实现反射
 * 缺点：没有延时实现，但能避免反射的问题
 */
public enum  singlePattern_enum {
    //这个枚举元素本身就是单例对象！
    INSTANCE;
    //添加自己需要的操作
    public void singleOperation(){
    }
}
