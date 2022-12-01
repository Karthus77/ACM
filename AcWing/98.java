import java.io.*;

public class Main {
    static int n;
    static long a,b,N;
    static long[] posA=new long[2];
    static long[] posB=new long[2];
    public static long[] cal(long t,long m)
    {
        if(t==0)
            return new long[]{0,0};
        long len=(long)1<<(t-1);//子块长
        long cnt=(long)1<<(2*t-2);//子块中的点数
        long cnk=m/cnt;//子块号
        long idx=m%cnt;//在子块中的编号
        long[] ne=cal(t-1,idx);
        long x=ne[0];
        long y=ne[1];
        if(cnk==0)
            return new long[]{y,x};
        if(cnk==1)
            return new long[]{x,y+len};
        if(cnk==2)
            return new long[]{x+len,y+len};
        return new long[]{len*2-y-1,len-x-1};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        for(int i=0;i<n;i++)
        {
            String[] p=reader.readLine().split(" ");
            N=Long.parseLong(p[0]);
            a=Long.parseLong(p[1]);
            b=Long.parseLong(p[2]);
            posA=cal(N,a-1);
            posB=cal(N,b-1);
            long disX=posA[0]-posB[0];
            long disY=posA[1]-posB[1];
            double ans=Math.sqrt((disX*disX+disY*disY))*10;
            long round=Math.round(ans);
            System.out.println(round);
        }
    }
}