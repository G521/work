import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {
    private static int R=26;
    public static void main(String[] args) {
        new Huffman().compress();
    }
    public static void compress(){
        Scanner in =new Scanner(System.in);
        String text=in.nextLine();
        char[] freq=new char[R];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)-'a']++;
        }
        node root=buildTree(freq);
        String[] st=new String[R];
        buildCode(st,root,"");
        for (int i = 0; i < st.length; i++) {
            System.out.println((char) (i + 'a') + " " + st[i]);
        }
    }

    private static void buildCode(String[] st, node x, String s) {
    if (x.isLeaf()){
        st[x.c-'a']=s;
    return;
    }
    buildCode(st,x.left,s+"0");
    buildCode(st,x.right,s+"1");

    }
    private static node buildTree(char[] freq) {
        PriorityQueue<node> pq= new PriorityQueue<node>();
        for (int i = 0; i < R; i++) {
            if (freq[i]>0)pq.add(new node((char)(i+'a'),freq[i],null,null));
        }
        while (pq.size()>1){
           node x=pq.poll();
           node y=pq.poll();
           node parent=new node('\0',x.getFreq()+y.getFreq(),x,y);
           pq.add(parent);
        }
        return pq.poll();
    }
}
class node implements Comparable<node>{
    public node left,right;
    public boolean isLeaf;
    private int freq;
    public char c;
    public node(char c, int freq, node left, node right) {
        this.left = left;
        this.c=c;
        this.right = right;
        this.freq = freq;
    }
    public boolean isLeaf(){
        return c!='\0';
    }

    public int getFreq() {
        return freq;
    }

    @Override
    public int compareTo(node node) {
        return this.freq-node.freq;
    }
}
