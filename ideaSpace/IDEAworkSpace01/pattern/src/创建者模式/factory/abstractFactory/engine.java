package 创建者模式.factory.abstractFactory;

public interface engine {
    void run();
    void start();
}
class LuxuryEngine implements engine{

    @Override
    public void run() {
        System.out.println("转的快！");
    }

    @Override
    public void start() {
        System.out.println("启动快， 可以自动停止！");
    }
}
