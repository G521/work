import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Scanner;
public class SG {
     private Graphy g;
     private int E;
     HashMap<String,Integer> map;
    private String[] name;

    public Graphy getG() {
        return g;
    }

    public SG(Scanner in){
         this(in.nextInt());
         int e=in.nextInt();
         for (int i = 0; i <e ; i++){
             String v_name=in.nextLine();
             String w_name=in.nextLine();
             int v=map.size();
             map.put(v_name,map.size());
             int w=map.size();
             map.put(w_name,map.size());
             g.addAdj(v,w);
             name[E++]=v_name;
             name[E++]=w_name;
             System.out.println(0);
         }
    }
    public String name(int index){
         return name[index];
    }
    public int index(String name){
         return map.get(name);
    }
    public boolean contain(String name){return map.containsKey(name);}
    private SG(int v){
        name=new String[v*2];
        g=new Graphy(v);
        map=new HashMap<>();
    }
}
