package 创建者模式.factory.factory_method;

import 创建者模式.factory.abstractFactory.CarFactory;

public class AudiFactory implements carFactory {

    @Override
    public Car createCar() {
        return new Audi();
    }
}
