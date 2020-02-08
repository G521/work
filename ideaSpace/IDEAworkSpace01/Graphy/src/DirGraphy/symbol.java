package DirGraphy;

import java.util.HashMap;
import java.util.Scanner;

public class symbol {
    private dirGraphy G;
    private String[] keys;
    Scanner in =new Scanner(System.in);
    private HashMap<String,Integer> map=new HashMap<>();
    public symbol(dirGraphy g,String sp){
        keys=new String[g.getE()];
        map=new HashMap<>();
        G=new dirGraphy(in);
        for (int i = 0; i <g.getE() ; i++) {
            String[] a=in.nextLine().split(sp);
            for (int j = 0; j <a.length ;) {
                if (!map.containsKey(a[j])){
                    map.put(a[j++],map.size());
                keys[j-1]=a[j-1];
                }
                if (!map.containsKey(a[j])){
                    map.put(a[j++],map.size());
                    keys[j-1]=a[j-1];
                }
                G.addEdge(j-2,j-1);
            }
        }
    }
    public boolean contains(String s){
        return map.containsKey(s);
    }
    public int index(String s){
        return map.get(s);
    }
    public String name(int index){
        return keys[index];
    }
    public dirGraphy getG(){
        return G;
    }
}
