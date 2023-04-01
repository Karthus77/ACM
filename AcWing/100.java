import java.io.*;


public class Main {
    static int N=100010;
    static int[] a=new int[N];
    static int n;
    static int[] b=new int[N];//差分
    static long ans;
    static long pos;
    static long neg;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        a[1]=b[1]=Integer.parseInt(reader.readLine());
        for(int i=2;i<=n;i++)
        {
            a[i]=Integer.parseInt(reader.readLine());
            b[i]=a[i]-a[i-1];
            if(b[i]>0)
                pos+=b[i];
            else
                neg-=b[i];
        }
        System.out.println(Math.min(pos,neg)+Math.abs(pos-neg));
        System.out.println(Math.abs(pos-neg)+1);

    }
}