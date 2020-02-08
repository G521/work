package 结构性模式.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.conFer();
        proxy.signContract();
        proxy.sing();
        proxy.collectMoney();
    }
}
