package graphy;

import java.util.Scanner;
/*
 * 8 16
4 5 0.35
4 7 0.37
5 7 0.28
0 7 0.16
1 5 0.32
0 4 0.38
2 3 0.17
1 7 0.19
0 2 0.26
1 2 0.36
1 
3 0.29
2 7 0.34
6 2 0.40
3 6 0.52
6 0 0.58
6 4 0.93
 */
public class test {
	static Scanner in =new Scanner(System.in);
	public static void main(String[] args) {
		WeightGraphy graphy =new WeightGraphy(in.nextInt());
		int e=in.nextInt();
		for (int i = 0; i < e; i++) {
		graphy.addEdge(new WeightEdge(in.nextInt(), in.nextInt(), in.nextDouble()));
	}
		Ksi sKsi=new Ksi(graphy);
		sKsi.mstEdges.forEach(action->System.out.println(action));
	}
}
