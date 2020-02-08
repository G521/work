package com.example;
import com.sobte.cqp.jcq.entity.CoolQ;

import java.io.*;
import java.util.*;
public class dissmsg {
    private CoolQ CQ;
    private File name_data;
    private File msg_data;
    private File num_data;
    private File languages_data;
   public static HashMap<String,String>langMap;
    private HashMap<Long,String>msgMap;
    private HashMap<Long,String>nameMap;
    private TreeMap<Long,Integer> numMap;
    private HashMap<String,String>wordsMap;
    private String from ="中文简体";
    private String to ="英语";
    private File words_data;
    public dissmsg(CoolQ c) {
        this.CQ=c;
        name_data=new File(CQ.getAppDirectory()+"name_data.txt");
        msg_data=new File(CQ.getAppDirectory()+"msg_data.txt");
        num_data=new File(CQ.getAppDirectory()+"num_data.txt");
        words_data=new File(CQ.getAppDirectory()+"words.txt");
        languages_data=new File(CQ.getAppDirectory()+"language_kinds.txt");
        if (name_data==null) { try { name_data.createNewFile(); } catch (IOException e) { } }
        if (msg_data==null) { try { msg_data.createNewFile(); } catch (IOException e) { } }
        if (num_data==null) { try { num_data.createNewFile(); } catch (IOException e) {  } }
        this.initdata();
    }
    private void initdata()  {
        try {
            ObjectInput name=new ObjectInputStream(new FileInputStream(name_data));
            nameMap= (HashMap<Long, String>) name.readObject();
            ObjectInput msg=new ObjectInputStream(new FileInputStream(msg_data));
            msgMap= (HashMap<Long, String>) msg.readObject();
            ObjectInput num=new ObjectInputStream(new FileInputStream(num_data));
            numMap= (TreeMap<Long, Integer>) num.readObject();
            ObjectInput words=new ObjectInputStream(new FileInputStream(words_data));
            wordsMap= (HashMap<String, String>) words.readObject();
            ObjectInputStream lang=new ObjectInputStream(new FileInputStream(languages_data));
            langMap= (HashMap<String, String>) lang.readObject();
            name.close();
            lang.close();
            num.close();
             msg.close();
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }finally {
            if (nameMap==null)nameMap=new HashMap<Long, String>();
            if (msgMap==null)msgMap=new HashMap<Long, String>();
            if (numMap==null)numMap= new TreeMap<Long, Integer>();
        }
    }
    public void receive(String msg, long fromgroup, long fromqq){
        if (msg.startsWith("名字")){
            String string=msg.substring(2);
            this.setName(string,fromgroup,fromqq);
        }
        else if (msg.contains("查名字")){
            CQ.sendGroupMsg(fromgroup,"你的昵称是："+this.getNicheng(fromqq));
        }
        else if (msg.contains("help")){
                this.help(fromgroup,fromqq);
            }
//        else if (msg.startsWith("今日单词")) this.wordsEverday(fromgroup,fromqq);
        else if (msg.startsWith("决斗")){
            int count=0;
            String string=msg.substring(2);
            if (string.length()==0)count=10;
            for (char c : string.toCharArray()) {
                if (!Character.isDigit(c)) { count = 10; } }if (count==0){ count=Integer.parseInt(string); }
            if(count>30)count=30;
            CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+"[CQ:face,id=169]决斗开始[CQ:face,id=169]\n"+war(fromqq,count));
        return;
        }
        else if (msg.startsWith("排行榜")){
            CQ.sendGroupMsg(fromgroup,number_order(fromqq));
        }
        else if(msg.startsWith("小笨蛋")){
            CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+"\n你才笨呢，我可是聪明的机器人\n哼！！");
            CQ.sendPrivateMsg(fromqq,"大坏蛋！！！");
        }
        else if (msg.startsWith("你真棒")){
            this.KuaKua(fromgroup,fromqq);
        }
       else {
            try {
                CQ.sendGroupMsg(fromgroup,tuling.talk(msg));
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
    }
//    private void wordsEverday(long fromgroup,long fromqq){
//        CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+"呀，这么努力啊~\n[CQ:face,id=60]今日单词来了：\n"+getWords());
//    }
//    private String getWords(){
//        String str = null;
//        int count= (int) (wordsMap.size()*Math.random());
//        Iterator<Map.Entry<String, String>> iterator=wordsMap.entrySet().iterator();
//        for (int i = 0; i < count&&iterator.hasNext(); i++) {
//            str=  iterator.next().getKey();
//        }
//        str+="\n"+(translation.translate(str.split("\\\\s")[0]).startsWith("不好意思，")?
//                "":translation.translate(str.split("\\\\s")[0]))+"\n"+wordsMap.get(str);
//        return str;
//    }
    private void KuaKua(long fromgroup, long fromqq) {
        String word1="[CQ:face,id=175]谢谢~，我会继续努力的~";
        String word2="[CQ:face,id=49][CQ:face,id=49]不客气哦,亲~";
        String word3="[CQ:face,id=79][CQ:face,id=79]哈哈哈，谢谢啦~";
        String word=Math.random()>0.3?word1:Math.random()>0.5?word2:word3;
       CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+"\n"+word);
    }
    public void help(long fromgroup,long fromqq){
        String str="\r\n[CQ:face,id=63]有以下几种功能哦:\r\n &名字***：设置你的昵称\r\n&查名字 ：查看你设置的昵称：\r\n#单词：查单词（支持英汉互译哦~） \r\n&决斗**（次数） 开始决斗\r\n &排行榜： 查看决斗排行榜\n" +
                " &今日单词： 推送今日单词~\r\n欢迎尝试~~\n[CQ:face,id=63][CQ:face,id=63][CQ:face,id=63][CQ:face,id=63][CQ:face,id=63]";
    CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+str);
    }
    /*
    决斗
     */
    private String war(long fromqq ,int count){
       String he="";
       String me="";
        StringBuilder result=new StringBuilder();
        int sum_he = 0;
        int sum_me = 0;
        int x,y;
        for (int i = 0; i < count; i++) {
            x=(int)(Math.random()*557);
            he+=x+" ";
            sum_he+=x;
            y=(int)(Math.random()*999);
            sum_me+=y;
            me+=y+" ";
        }
        if (sum_he>sum_me){
            if (numMap.containsKey(fromqq))
                    numMap.put(fromqq, numMap.get(fromqq) + 1);
            else numMap.put(fromqq, 1);
        }
        result.append(sum_he>sum_me?"什么！！？？你竟然赢了，\n好吧，是我疏忽了，\n再来,我就不信了，还玩不过你了！！！":"看，我就说了，\n你不会赢得，啦啦啦啦啦~~~\n");
        result.append("你的情况：\n"+he+"\n");
        result.append("你的得分："+sum_he+"\n");
        result.append("我的情况：\n"+me+"\n");
        result.append("我的得分："+sum_me+"\n");
        result.append("你现在的得分为："+numMap.get(fromqq));
        return result.toString();
    }
    /*排行榜

     */
    private String number_order(long fromqq){
        TreeMap<Integer,Long> VSbanh=new TreeMap<Integer, Long>();
        for (Map.Entry<Long, Integer> entry : numMap.entrySet()) {
            VSbanh.put(entry.getValue(),entry.getKey());
        }
        StringBuilder result=new StringBuilder();
        result.append( Common.CC.at(fromqq)+"\n"+"[CQ:face,id=144]排行榜[CQ:face,id=144]\n");
        int count=1;
        while (VSbanh.size()>0){
            Map.Entry map= VSbanh.pollLastEntry();
            result.append("第"+(count++)+"名，得分："+map.getKey()+"名字："+(nameMap.containsKey(map.getValue())?this.getName((Long) map.getValue())+"\n"+map.getValue():map.getValue())+"\n");
        }
        return result.toString();
    }
    public void fanyi(String str,long fromgroup,long fromqq) {
        if (!str.matches("[^a~zA~Z]"))
            CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+str+"的意思是：\n"+translation.translate(str));
        else CQ.sendGroupMsg(fromgroup,Common.CC.at(fromqq)+"");

    }
    public String getNicheng(long fromqq){
        return nameMap.containsKey(fromqq)?nameMap.get(fromqq):"你还没有设置昵称哦~";
    }
    public void setName(String name,long groupid,long fromqq){
        CQ.sendGroupMsg(groupid,fromqq+"你的昵设置为："+name);
       nameMap.put(fromqq,name);
    }
    public String getName(long fromqq){
        return nameMap.containsKey(fromqq)?nameMap.get(fromqq):fromqq+"";
    }
    public void close(){
        try {
            ObjectOutputStream name=new ObjectOutputStream(new FileOutputStream(this.name_data));
            ObjectOutputStream msg =new ObjectOutputStream(new FileOutputStream(this.msg_data));
            ObjectOutputStream num=new ObjectOutputStream(new FileOutputStream(this.num_data));
            name.writeObject(nameMap);
            msg.writeObject(msgMap);
            num.writeObject(numMap);
            num.flush();
            msg.flush();
            name.flush();
            num.close();
            msg.close();
            name.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }
}
