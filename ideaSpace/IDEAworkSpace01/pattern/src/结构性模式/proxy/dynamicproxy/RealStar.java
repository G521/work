package 结构性模式.proxy.dynamicproxy;

public class RealStar implements Star {
    @Override
    public void conFer() {
        System.out.println("RealStar.conFer");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.sinContract");
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMondy");
    }
}
