package 结构性模式.adapter;

/**
 * 适配器
 * 相当于usb 和 ps/2 的转接器
 * 两种思路：
 * 1，直接继承 缺点：不够灵活，Java只有单继承
 * 类适配器方式
 *
 */
public class Adapter1 extends Adaptee implements USB{

    @Override
    public void handleReq() {
        super.request();
    }

}
