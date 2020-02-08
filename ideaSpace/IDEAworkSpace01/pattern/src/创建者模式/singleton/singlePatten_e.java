package 创建者模式.singleton;

/**
 * 测试饿汉式单例模式
 */
public class singlePatten_e {
    private static singlePatten_e instance =new singlePatten_e();
    private singlePatten_e(){}
    public singlePatten_e getInstance(){
        return instance;
    }
}
