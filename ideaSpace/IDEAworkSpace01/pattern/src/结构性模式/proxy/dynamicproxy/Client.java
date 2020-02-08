package 结构性模式.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StartHandle handle = new StartHandle(realStar);
        Star proxy= (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},handle);
//        proxy.collectMoney();
        proxy.sing();
    }
}
