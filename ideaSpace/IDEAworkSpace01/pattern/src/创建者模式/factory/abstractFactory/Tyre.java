package 创建者模式.factory.abstractFactory;

public interface Tyre {
    void revolve();
}
class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("不磨损");
    }
}
class LowTyre implements Tyre{


    @Override
    public void revolve() {
        System.out.println("磨损严重！");
    }
}
