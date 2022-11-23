import java.io.*;

public class Main {
    static int a,b;
    static final int MOD=9901;
    static int res=1;
    public static int qsm(int k,int n)
    {
        k%=MOD;
        int tmp=1;
        while(n!=0)
        {
            if((n&1)==1)
            {
                tmp=tmp*k%MOD;
            }
            n>>=1;
            k=k*k%MOD;
        }
        return tmp;
    }
    public static int sum(int p,int k)
    {
        if(k==0)
            return 1;
        else
        {
            if(k%2==0)
                return ((p%MOD*sum(p,k-1)+1)%MOD);
            else
                return (qsm(p,k/2+1)+1)*sum(p,k/2)%MOD;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        a=Integer.parseInt(param[0]);
        b=Integer.parseInt(param[1]);
        for(int i=2;i<=a;i++)
        {
            int s=0;
            while(a%i==0)
            {
                a/=i;
                s++;
            }
            if(s!=0)
                res=res*sum(i,s*b)%MOD;
        }
        if(a==0)
            System.out.println(0);
        else
            System.out.println(res);
    }
}
