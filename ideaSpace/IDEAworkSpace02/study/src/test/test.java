package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;

public class test{
    static public int money[]={0,1,3,7,8,13,15,16,17,19,20};
    public static void main(String[] args) {
        Scanner in =new Scanner(new BufferedInputStream(System.in));
        int n=in.nextInt();
        int[] result=new int[n+1];
        result[0]=0;
        result[1]=money[1];
        if(n<=10)
        for (int i = 1; i <=n ; i++) {
            int max=0;
            for (int j = 1; j <=i/2 ; j++) {
            max=result[j]+result[i-j]>max?result[j]+result[i-j]:max;
            }
            max=Math.max(max,money[i]);
            result[i]=max;
        }
//        else{
//            result=(n/10)*result[10]+result[n%10]
//            }
//        }
//        System.out.println(result[n]);
    }
}