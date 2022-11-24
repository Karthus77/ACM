import java.io.*;

public class Main {
    static final int N=15;
    static final int M=3010;
    static int[] v=new int[N];
    static long[] dp=new long[M];//组成M值的方案个数
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        for(int i=0;i<n;i++)
        {
            v[i]=Integer.parseInt(reader.readLine());
        }
        dp[0]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=v[i];j<=m;j++)
                dp[j]+=dp[j-v[i]];
        }
        System.out.println(dp[m]);
    }
}
