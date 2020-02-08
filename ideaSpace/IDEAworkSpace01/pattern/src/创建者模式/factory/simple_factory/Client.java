package 创建者模式.factory.simple_factory;

public class Client {
    public static void main(String[] args) {
        Car c1 =CarFactoty.getCar("Byd");
        Car c2 = CarFactoty.getCar("Aud");
        c1.run();
        c2.run();
    }
}
