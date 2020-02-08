package 结构性模式.proxy.staticproxy;

public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void conFer() {
        System.out.println("ProxyStar.conFer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.sinContract");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney!");
    }
}
