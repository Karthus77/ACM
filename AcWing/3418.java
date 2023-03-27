import java.io.*;


public class Main {
    static int n;
    public static long C(int a,int b)
    {
        long res=1;
        for(int i=a,j=1;j<=b;i--,j++)
        {
            res=res*i/j;
            if(res>n)
                return res;
        }
        return res;
    }
    public static boolean check(int k)
    {
        int l=2*k;
        int r=Math.max(l,n);
        while(l<r)
        {
            int mid=(l+r)>>1;
            if(C(mid,k)>=n)
            {
                r=mid;
            }
            else l=mid+1;
        }
        if(C(r,k)!=n)
            return false;
        else
            System.out.println((1+r)*(long)r/2+k+1);
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        for(int i=16;i>=0;i--)
        {
            if(check(i))
                break;
        }
    }
}