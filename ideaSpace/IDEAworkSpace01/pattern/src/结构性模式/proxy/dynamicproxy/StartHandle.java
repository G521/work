package 结构性模式.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StartHandle implements InvocationHandler {
    private Star realStar;

    public StartHandle(Star realStar) {
        this.realStar = realStar;
    }

    /**
     * 调用代理类方法都会再此处理！
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真正的方法执行前");
        System.out.println("面谈，签合同，预付款");
        System.out.println("args = " + args);
//        System.out.println("proxy = " + proxy);
        System.out.println("method = " + method);
        if (method.getName().equals("sing")){
            object = method.invoke(realStar);
        }
        System.out.println("真正的方法执行后");
        System.out.println("收尾款");
        return object;
    }
}
