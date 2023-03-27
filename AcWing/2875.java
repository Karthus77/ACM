import java.io.*;

public class Main {
    static int N=100010;
    static int[] w=new int[N];
    static int[] sum=new int[N];
    static int n;
    static long res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        String[] param=reader.readLine().split(" ");
        for(int i=0;i< param.length;i++)
        {
            w[i]=Integer.parseInt(param[i]);
            if(i==0)
            {
                sum[i]=w[i];
            }
            else
            {
                sum[i]=sum[i-1]+w[i];
            }
        }
        for(int i=1;i<n;i++)
        {
            res+= (long) w[i] *sum[i-1];
        }
        System.out.println(res);
    }
}