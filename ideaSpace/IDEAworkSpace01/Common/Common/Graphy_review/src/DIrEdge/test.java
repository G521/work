package DIrEdge;
import java.util.Scanner;
public class test {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		diwiGraphy G=new diwiGraphy(scanner.nextInt());
//		sbGraphy G=new sbGraphy(scanner.nextInt());
//		int e=scanner.nextInt();
//		scanner.nextLine();
//		for (int i = 0; i < e; i++) {
//			G.addEdge(scanner.nextLine(),scanner.nextLine(),scanner.nextDouble());
//		}
//		diwiGraphy G=new diwiGraphy(scanner.nextInt());
		int e=scanner.nextInt();
		for (int i = 0; i < e; i++) {
			G.addAdj(new dirEdge(scanner.nextInt(), scanner.nextInt(),scanner.nextDouble()));
		}
		Dijkstra sDijkstra=new Dijkstra(G, 0);
		sDijkstra.pathTo(scanner.nextInt()).forEachRemaining(s->System.out.println(s));
	}
}
