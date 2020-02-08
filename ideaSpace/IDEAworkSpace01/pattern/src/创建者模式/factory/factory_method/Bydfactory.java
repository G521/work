package 创建者模式.factory.factory_method;

public class Bydfactory implements carFactory {

    @Override
    public Car createCar() {
        return new Byd();
    }
}
