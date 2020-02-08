package review;

import java.util.Iterator;
import java.util.Scanner;
/*
6 8
0 1 0 2 0 5 1 2 2 3 2 4 3 5 3 4
测试用
 */
public class test {
    public static void main(String[] args) {
        Graphy graphy = new Graphy(new Scanner(System.in));
        DepthFirstPath depthFirstPath=new DepthFirstPath(graphy,0);
        BreadFirstPath breadFirstPath=new BreadFirstPath(graphy,0);
        for (Iterator<Integer> it = depthFirstPath.pathTo(4); it.hasNext(); ) {
            int k = it.next();
            System.out.println("k = " + k);


        }
        System.out.println("++++++++++++++++++++++++++");
        for (Iterator<Integer> it = breadFirstPath.pathTo(4); it.hasNext(); ) {
            int k = it.next();
            System.out.println("k = " + k);

        }
    }
}
