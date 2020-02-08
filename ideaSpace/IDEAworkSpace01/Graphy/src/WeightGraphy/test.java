package WeightGraphy;

import review_WeightGraphy.EdgeWeightGraphy;
import review_WeightGraphy.lazyPrim;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        lazyPrim prim=new lazyPrim(new EdgeWeightGraphy(in));
        System.out.println("prim = " + prim);
    }
}
