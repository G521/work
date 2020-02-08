package 创建者模式.factory.abstractFactory;

public interface CarFactory {
    engine createEngine();
    Seat createSeat();
    Tyre createtyre();
}
