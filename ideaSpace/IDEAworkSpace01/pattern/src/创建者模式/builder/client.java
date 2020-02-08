package 创建者模式.builder;

public class client {
    public static void main(String[] args) {
        SxtAirshipDirector director = new SxtAirshipDirector();
        Airship airship=director.directAir(new sxtAirshipBuilder());
        airship.getEngine().start();
    }
}
