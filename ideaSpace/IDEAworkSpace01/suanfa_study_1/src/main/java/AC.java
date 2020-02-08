import java.util.*;

public class  AC{
        private HashSet<String> targer=new HashSet<>();
        private void buildTree(){
            for (String s : targer) {
                this.insert(root,s);
            }
        }
        private TriedNode root=new TriedNode();
        public void insert(TriedNode node,String s){
            TriedNode p=node;
            for (int i = 0; i < s.length(); i++) {
                int c=s.charAt(i)-'a';
                if (p.childNodes[c]==null) {
                    p.childNodes[c]=new TriedNode();
                }
            p=p.childNodes[c];
            }
            p.str=s;
        }
        public AC(HashSet<String> targer){
            this.targer=targer;
            this.buildTree();
            this.buildAC();
        }
        private void buildAC(){
            LinkedList<TriedNode> queue=new LinkedList<>();
            for (TriedNode node : root.childNodes) {
                if (node!=null){
                    node.fail=root;
                    queue.add(node);
                }
            }
            while (!queue.isEmpty()){
                TriedNode curr=queue.poll();
                for (int i = 0; i < curr.childNodes.length; i++) {
                    if (curr.childNodes[i] == null) continue;
                    else {
                        queue.addLast(curr.childNodes[i]);
                        TriedNode failTo=curr.fail;
                        while (true){
                            if (failTo==null){
                                curr.childNodes[i].fail=root;
                                break;
                            }
                            if (failTo.childNodes[i]!=null){
                                curr.childNodes[i].fail=failTo.childNodes[i];
                                break;
                            }else {
                                failTo=failTo.fail;
                            }
                        }
                    }
                }
            }
        }
   public HashMap<String,LinkedList<Integer>> find(String text){
            HashMap<String,LinkedList<Integer>> result=new HashMap<>();
      TriedNode curr=root;
       for (int i = 0; i < text.length(); i++) {
           int index=text.charAt(i)-'a';
           if (curr.childNodes[index]!=null){
               curr=curr.childNodes[index];
               if (curr.isWord()){
                   if (!result.containsKey(curr.str))result.put(curr.str,new LinkedList<Integer>());
                   result.get(curr.str).add(i-curr.str.length()+1);
               }else if (curr.fail.isWord()){
                   if (!result.containsKey(curr.fail.str))result.put(curr.fail.str,new LinkedList<Integer>());
                   result.get(curr.fail.str).add(i-curr.fail.str.length()+1);
               }
           }else {
               curr=curr.fail;
               i--;
               if (curr==null){
                   curr =root;
               }
           }
       }
       return result;
   }
    public static void main(String[] args) {
            HashSet<String> targer=new HashSet<>();
            targer.add("asssdf");
            AC ac=new AC(targer);
            HashMap<String,LinkedList<Integer>> result=ac.find("asssdfasssdfasssdfasssdfasssdfasssdfasssdfasssdfasssdfasssdf");
            for (Map.Entry<String,LinkedList<Integer>> p:result.entrySet()){
                System.out.println(p.getKey() + " " + p.getValue());
            }
        }
}