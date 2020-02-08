import java.util.HashSet;
import java.util.Set;

public class TriedNode {
    public TriedNode[] childNodes;
    public String str;
    public TriedNode fail;
    public TriedNode() {
        childNodes=new TriedNode[26];
        str="";
    }
    public boolean isWord(){
        return !str.equals("");
    }
}
