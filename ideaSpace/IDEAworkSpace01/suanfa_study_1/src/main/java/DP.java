import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Scanner;

public class DP {
    private static int[] max_value;
    private static int[] value ={0,1,5,8,9,10,17,17,20,24,30};
    public static void run(){
        Scanner in =new Scanner(System.in);
        int n=4;
        max_value=new int[n+1];
        max_value[1]=1;
        for (int i =2; i <=n; i++) {
            max_value[i]=0;
            for (int j = 1; j <=i; j++) {
                if (j<=10)
                max_value[i]=Math.max(max_value[i],max_value[i-j]+value[j]);
                else
                    max_value[i]=Math.max(max_value[i],max_value[i-j]+max_value[j]);
            }
        }
        System.out.println(max_value[n]);
    }

    public static void main(String[] args) {
        new DP().run();
    }
}
