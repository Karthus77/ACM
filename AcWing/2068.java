import java.io.*;
public class Main {
    static int N=100100;
    static int[] a=new int[N];
    static long ans;
    static int k;
    static int n;
    static int[][] s=new int[11][N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        k=Integer.parseInt(param[1]);
        String[] num=reader.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(num[i]);
        }
        for(int i=0;i<n;i++)
        {
            int t=a[i]%k;
            for(int j=0;j<11;j++)
            {
                s[j][t]++;
                t=t*10%k;
            }
        }
        for(int i=0;i<n;i++)
        {
            int l=Integer.toString(a[i]).length();
            int t=a[i]%k;
            ans+=s[l][(k-t)%k];
            int m=t;
            for(int j=0;j<l;j++)
            {
                m=m*10%k;
            }
            if(m==(k-t)%k)
                ans--;
        }
        System.out.println(ans);
    }
}