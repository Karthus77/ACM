import java.io.*;


public class Main {
    static int r;
    static int n;
    static int N=5010;
    static int[][] s=new int[N][N];
    static int[][] w=new int[N][N];
    static int x,y,z;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        r=Integer.parseInt(param[1]);
        for(int i=0;i<n;i++)
        {
            String[] v=reader.readLine().split(" ");
            x=Integer.parseInt(v[0]);
            y=Integer.parseInt(v[1]);
            z=Integer.parseInt(v[2]);
            w[x+1][y+1]+=z;
        }
        for(int i=1;i<N;i++)
        {
            for(int j=1;j<N;j++)
            {
                s[i][j]=s[i-1][j]+s[i][j-1]-s[i-1][j-1]+w[i][j];
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                int x1=Math.min(N-1,i+r);
                int y1=Math.min(N-1,j+r);
                ans=Math.max(s[x1][y1]-s[i][y1]-s[x1][j]+s[i][j],ans);
            }
        }
        System.out.println(ans);
    }
}