package 创建者模式.builder;

public class sxtAirshipBuilder implements AirshipBuilder {

    @Override
    public Seat buildSeat() {
        return new luxurySeat();
    }

    @Override
    public Engine buildEngine() {
        return new luxuryEngine();
    }

    @Override
    public EscapeTower buildEscapeTower() {
        return new LuxuryEscapeTower();
    }
}
