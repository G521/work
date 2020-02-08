package 创建者模式.prototype;

public class client2 {
    public static void new_test(int size){
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Map map = new Map();
        }
        long end = System.currentTimeMillis();
        System.out.println("new :"+(end-start));
    }
    public static void clone_test(int size)  {
        long start = System.currentTimeMillis();
        Map map = new Map();
        for (int i = 0; i < size-1; i++) {
            try {
                Map map1 = (Map) map.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("clone :"+(end-start));
    }

    public static void main(String[] args) {
        new_test(1000);
        clone_test(1000);
    }
}

class Map implements Cloneable{
    public Map() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}