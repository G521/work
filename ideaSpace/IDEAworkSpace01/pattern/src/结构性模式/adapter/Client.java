package 结构性模式.adapter;

/**
 * 客户端
 * 相当于笔记本，只有USB 接口
 */
public class Client {
    public void test1(USB usb){
        usb.handleReq();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Adaptee adaptee = new Adaptee();
        USB usb = new Adapter1();
        client.test1(usb);
        Adapter2 adapter2 = new Adapter2(adaptee);
        client.test1(adapter2);
    }
}
