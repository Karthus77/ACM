import java.io.*;


public class Main {
    static int x,m,n;
    static int N=100010;
    static int M=1<<21;
    static int l,r;
    static int[] last=new int[M];//最后出现位置
    static int[] f=new int[N];//在1~k间不存在满足的数对最小下标
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        x=Integer.parseInt(param[2]);
        String[] num=reader.readLine().split(" ");
        for(int i=1;i<=n;i++)
        {
            int a=Integer.parseInt(num[i-1]);
            f[i]=Math.max(f[i-1],last[a^x]);//不满足的最小下界
            last[a]=i;
        }
        for(int i=0;i<m;i++)
        {
            String[] op=reader.readLine().split(" ");
            l=Integer.parseInt(op[0]);
            r=Integer.parseInt(op[1]);
            if(f[r]>=l)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}