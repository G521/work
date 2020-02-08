package 创建者模式.factory.abstractFactory;

public interface Seat {
    void massage();
}
class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("可以按摩");
    }
}
class OrdinarySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("普通座椅！");
    }
}
