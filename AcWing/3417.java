import java.io.*;


public class Main {
    static int n;
    static int N=110;
    static int M=200010;
    static int[] w=new int[N];
    static boolean[][] f=new boolean[N][M];
    static int sum=0;
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        String[] param=reader.readLine().split(" ");
        for(int i=1;i<=n;i++)
        {
            w[i]=Integer.parseInt(param[i-1]);
            sum+=w[i];
        }
        f[0][0]=true;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                f[i][j]=f[i-1][j]||f[i-1][j+w[i]]||f[i-1][Math.abs(j-w[i])];
            }
        }
        for(int i=1;i<=sum;i++)
        {
            if (f[n][i])res++;
        }
        System.out.println(res);
    }
}