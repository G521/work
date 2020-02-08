package 创建者模式.factory.simple_factory;

public class Aud implements Car{
    @Override
    public void run() {
        System.out.println("奥迪在跑！");
    }
}
