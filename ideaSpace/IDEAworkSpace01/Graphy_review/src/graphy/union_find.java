package graphy;
 public class union_find{
	 private int[] inde;
	 private int size[];
	 private int count;
	 public union_find(int N) {
		// TODO Auto-generated constructor stub
		 size=new int[N];
		 inde=new int[N];
		 count=N;
		 for (int i = 0; i < inde.length; i++) {
			inde[i]=i;
			size[i]=1;
		}
	 }
	 public int find(int p) {
		 while (p!=inde[p]) {
			p=inde[p];
		}
		 return p;
	 }
	 public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	 public void connect(int q,int p) {
		int i=find(q);
		int j=find(p);
		if (i==j) {
			return;
		}
		if (size[i]>size[j]) {
			inde[j]=i;
			size[j]+=size[i];
			count--;
		}
		else {
			inde[i]=j;
			size[i]+=size[j];
			count--;
		}
	}
 }