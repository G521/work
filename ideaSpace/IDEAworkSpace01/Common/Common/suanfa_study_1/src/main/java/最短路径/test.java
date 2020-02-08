package 最短路径;

import java.util.Iterator;
import java.util.Scanner;
/*
8
15
4 5 0.35
5 4 0.35
4 7 0.37
5 7 0.28
7 5 0.28
5 1 0.32
 0 4 0.38
0 2 0.26
7 3 0.39
1 3 0.29
2 7 0.34
6 2 0.40
3 6 0.52
6 0 0.58
6 4 0.93
 */
public class test {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        DirWGraphy graphy=new DirWGraphy(in.nextInt());
        int e=in.nextInt();
        for (int i = 0; i < e; i++) {
            System.out.println("输入边：");
            graphy.addAdj(new DirWeightEdge(in.nextInt(),in.nextInt(),in.nextDouble()));
        }
        Djs djs=new Djs(graphy,0);
        while (in.hasNext()){
        for (Iterator<DirWeightEdge> it = djs.PathTo(in.nextInt()); it.hasNext(); ) {
            DirWeightEdge edge = it.next();
            System.out.print(edge);
        }
        System.out.println();
    }}
}
