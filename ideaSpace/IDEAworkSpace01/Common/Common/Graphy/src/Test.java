import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        SG sg=new SG(new Scanner(System.in));
        Graphy graphy=sg.getG();
        for (Iterator<Integer> it = graphy.getIterator(4); it.hasNext(); ) {
            int k = it.next();
            System.out.println(sg.name(k));
        }
    }
}
