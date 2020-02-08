package translation;

import java.util.Scanner;

public  class Main{
    private static String from="zh";
    private static String to="en";
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("欢迎使用张张翻译机！");
        System.out.println("汉译英请输入ch\n英译汉输入en");
        System.out.println("如果输入超过一行请加上 + \n如:  ch+  en+");
        String choose=in.nextLine();
        if (choose.contains("ch")){
          from="zh";
          to="en";
        }
        else if (choose.contains("en")){
            from="en";
            to="zh";
        }
        if (choose.contains("+")){
            while (true){
                System.out.println("请输入翻译内容 以#号结束！");
                StringBuilder targer=new StringBuilder();
                String s=in.nextLine();
                while (!s.equals("#")){
                    targer.append(s);
                    s=in.nextLine();
                }
                System.out.println(translate.result(targer.toString(),from,to));
                System.out.println("=======================================");
            }
        }else
        while (true){
            System.out.println("请输入翻译内容：");
            String result=translate.result(in.nextLine(), from, to);
            if (result.startsWith("{\"error")){
                System.out.println("输入有误，请重试！");
                continue;
            }else
                System.out.println(result);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();}
    }
}
