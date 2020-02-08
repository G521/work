package Lambda;

import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> lists = new LinkedList<>();
        for (int i = 0; i <10 ; i++) {
            lists.add((int) (Math.random()*100));
        }
        lists.forEach(System.out::println);
    }
}
