package 创建者模式.builder;

public interface AirshipBuilder {
    Seat buildSeat();
    Engine buildEngine();
    EscapeTower buildEscapeTower();
}
