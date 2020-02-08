

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
       static class result implements Comparable<result>{
                int inde,pro;
                public result(int inde, int pro) {
                        this.inde = inde;
                        this.pro = pro;
                }
                public int getInde() {
                        return inde;
                }
                public int getPro() {
                        return pro;
                }
               @Override
               public int compareTo(result result) {
                       if (this.getPro()>result.getPro())return 1;
                       if (this.getPro()<result.getPro())return -1;
                       return 0;
               }
       }
        public static void main(String[] args) {
                Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int n=in.nextInt();
                LinkedList<result> results=new LinkedList<>();
                List<result> set=new LinkedList<>();
                int count=0;
                for (int i = 0; i < n; i++) {
                        int k=in.nextInt();
                        int a=in.nextInt();
                        int x=in.nextInt();
                        int y=in.nextInt();
                        int m=in.nextInt();
                        int r[]=new int[k];
                        r[0]=a;
                        set.add(new result(i+1,a));
                        for (int i1 = 1; i1 <k; i1++) {
                                r[i1]=Math.floorMod(r[i1-1]*x+y,m);
                                if (r[i1]<r[i1-1])count++;
                                set.add(new result(i+1,r[i1]));
                        }
                }
                Collections.sort(set);
                result x1=set.get(0);
                set.remove(0);
                while (!set.isEmpty()){
                        result x2=set.get(0);
                        set.remove(0);
                        results.add(x1);
                        x1=x2;
                }
                results.add(x1);
                System.out.println(count);
                if (results.size()<200000){
                        for (result result : results) {
                                System.out.println(result.getPro() + " " + result.getInde());
                        }
                }
        }
}