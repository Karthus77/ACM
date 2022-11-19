
import java.io.*;
import java.util.Vector;


public class Main {
    static int t;
    static int m,s;
    static int max=0;
    static Vector<Integer> array=new Vector<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(reader.readLine());
        while(t--!=0)
        {
            array.clear();
            String[] param=reader.readLine().split(" ");
            m=Integer.parseInt(param[0]);
            s=Integer.parseInt(param[1]);
            max=0;
            String[] bs=reader.readLine().split(" ");
            for(int i=0;i<m;i++)
            {
                int b=Integer.parseInt(bs[i]);
                max=Math.max(b,max);
                array.add(b);
            }
            if(find(s))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static boolean find(int s)
    {
        int tmp=0;
        for(int i=1;i<=max;i++)
        {
            if (!array.contains(i))
            {
                tmp+=i;
            }
        }
        if(tmp==s)
        {
            return true;
        }
        else
        {
            for(int i=max+1;tmp<s;i++)
            {
                tmp+=i;
                if(tmp==s)
                    return true;
            }
            return false;
        }
    }
}

