
import java.io.*;

public class Main {
    static int t;
    static int l,r,x;
    static int a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(reader.readLine());
        while(t--!=0)
        {
            String[] p1=reader.readLine().split(" ");
            l=Integer.parseInt(p1[0]);
            r=Integer.parseInt(p1[1]);
            x=Integer.parseInt(p1[2]);
            String[] p2=reader.readLine().split(" ");
            a=Integer.parseInt(p2[0]);
            b=Integer.parseInt(p2[1]);
            int min=Math.min(a,b);
            int max=Math.max(a,b);
            if(max-min>=x)//跳一步
                System.out.println(1);
            else if(max==min)//不跳
                System.out.println(0);
            else if(r-max>=x||min-l>=x)//两端可达，2步
                System.out.println(2);
            else if(r-min>=x&&max-l>=x)//3步可达
                System.out.println(3);
            else
                System.out.println(-1);
        }
    }
}
