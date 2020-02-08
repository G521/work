package 创建者模式.factory.abstractFactory;

public class LuxuryCarFactory implements CarFactory {

    @Override
    public engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createtyre() {
        return new LuxuryTyre();
    }
}
