package 结构性模式.adapter;

/**
 * 适配器（对象适配器，使用了组合的方式跟被适配对象整合）
 */
public class Adapter2 implements USB{
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
