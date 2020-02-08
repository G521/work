package 创建者模式.factory.simple_factory;

/**
 * 简单工厂类
 */
public class CarFactoty {
    /**
     * @param  type 表示所需汽车的种类
     *      * @return
     */
    public static Car getCar(String type){
        switch (type) {
            case "Aud": return new Aud();
            case "Byd": return new Byd();
            default: return null;
        }
    }
}
