package 创建者模式.factory.abstractFactory;

public class Test {
    CarFactory factory =new LuxuryCarFactory();
    engine engine =factory.createEngine();

}
