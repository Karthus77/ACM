import java.io.*;


public class Main {
    static int N=100010;
    static int[] h=new int[N];
    static int x;
    static int[] s=new int[N];
    static int n;
    public static boolean check(int y)
    {
        for(int i=1;i+y<=n;i++)
        {
            if(s[i+y-1]-s[i-1]<2*x)//存在落脚点
                return false;
        }
        return true;
    }
    public static int find()
    {
        int l=0;
        int r=n;
        while(l<r)
        {
            int mid=(l+r)>>1;
            if(check(mid))
            {
                r=mid;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        x=Integer.parseInt(param[1]);
        String[] height=reader.readLine().split(" ");
        for(int i=1;i<n;i++)
        {
            h[i]=Integer.parseInt(height[i-1]);
            s[i]=h[i]+s[i-1];
        }
        s[n]=s[n-1];
        int ans=find();
        System.out.println(ans);
    }
}