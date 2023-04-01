import java.io.*;


public class Main {
    static int  n,f;
    static int N=100010;
    static double[] s=new double[N];
    static int[] cow=new int[N];
    public static boolean check(double avg)
    {
        for(int i=1;i<=n;i++)
            s[i]=s[i-1]+(cow[i]-avg);
        double min=0;
        for(int i=0,j=f;j<=n;i++,j++)
        {
            min=Math.min(min,s[i]);//极小区间
            if(s[j]-min>=0)return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        f=Integer.parseInt(param[1]);
        double l=0;
        double r=0;
        for(int i=1;i<=n;i++)
        {
            cow[i]=Integer.parseInt(reader.readLine().split(" ")[0]);
            r=Math.max(r,(double)cow[i]);
        }
        while(r-l>-1e5)
        {
            double mid=(r+l)/2;
            if(check(mid))l=mid;
            else r=mid;
        }
        System.out.println((int)(r*1000));
    }
}