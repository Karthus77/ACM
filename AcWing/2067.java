import java.io.*;
public class Main {
    static int N=40;
    static int[][] f=new int[N][N];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        f[0][1]=1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
            {
                if(i%2==0&&j%2==0)
                    continue;
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        System.out.println(f[n][m]);
    }
}