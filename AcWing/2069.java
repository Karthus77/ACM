import java.io.*;
public class Main {
    static int N=10010;
    static int[] w=new int[N];
    static int[] root=new int[N];
    static int n,m;
    public static void union(int a,int b)
    {
        int ra=find(a);
        int rb=find(b);
        if(ra!=rb) {
            w[ra]-=w[rb];
            root[ra]=rb;
        }
    }
    public static int find(int x)
    {
        if(root[x]==x||root[root[x]]==root[x])
            return root[x];
        int r=find(root[x]);
        w[x]+=w[root[x]];
        root[x]=r;
        return r;
    }
    static int a,b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        for(int i=0;i<=n;i++)
        {
            root[i]=i;
        }
        while(m--!=0)
        {
            String[] op=reader.readLine().split(" ");
            a=Integer.parseInt(op[0]);
            b=Integer.parseInt(op[1]);
            c=Integer.parseInt(op[2]);
            if(a==1)
            {
                union(b,c);
            }
            else
            {
                w[find(b)]+=c;
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(find(i)==i)
                System.out.print(w[i]+" ");
            else
                System.out.print(w[i]+w[find(i)]+" ");
        }
    }
}