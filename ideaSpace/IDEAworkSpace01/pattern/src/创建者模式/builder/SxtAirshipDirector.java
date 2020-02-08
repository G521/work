package 创建者模式.builder;

public class SxtAirshipDirector implements AirDirector {

    @Override
    public Airship directAir(AirshipBuilder builder) {
        Airship airship = new Airship();
        airship.setEngine(builder.buildEngine());
        airship.setEscapeTower(builder.buildEscapeTower());
        airship.setSeat(builder.buildSeat());
        return airship;
    }
}
