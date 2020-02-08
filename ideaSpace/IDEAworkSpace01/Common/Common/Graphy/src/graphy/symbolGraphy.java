package graphy;
import java.util.HashMap;
import java.util.Scanner;
public class symbolGraphy {
    HashMap<String, Integer> map=new HashMap<>();
    private String keys[];
    private  graphy g;
    private int x;
    public symbolGraphy(Scanner in,String sp){
        g=new graphy(in.nextInt());
        int E=in.nextInt();
        keys=new String[E];
        in.nextLine();
        String[] a=in.nextLine().split(sp);
        System.out.println("a.length = " + a.length);
        for (int j = 0; j <a.length;){
            if (!map.containsKey(a[j])){
                map.put(a[j],map.size());
                keys[x++]=a[j]; }
            j++;
            if (!map.containsKey(a[j])){
                keys[x++]=a[j];
                map.put(a[j],map.size()); }
            j++;
         g.addAdj(map.get(a[j-2]),map.get(a[j-1]));
        }
    }
    public int index(String s){
        return map.get(s);
    }
    public String name(int index){
        return keys[index];
    }
    public graphy getG(){
        return g;
    }
}
