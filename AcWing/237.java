import java.io.*;
import java.util.HashMap;

public class Main {
    static int t;
    static int n;
    static final int N =100010;
    static HashMap<Integer,Integer> union=new HashMap<>();
    static HashMap<Integer,Integer> une=new HashMap<>();
    public static int find(int x)
    {
        if(union.get(x)!=x)
        {
            union.put(x,find(union.get(x)));
        }
        return union.get(x);
    }
    public static void connect(int x,int y)
    {
        int rx=find(x);
        int ry=find(y);
        if(rx!=ry)
            union.put(ry,rx);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(reader.readLine());
        for(int i=0;i<t;i++)
        {
            n=Integer.parseInt(reader.readLine());
            union.clear();
            une.clear();
            for(int j=0;j<n;j++)
            {
                String[] param=reader.readLine().split(" ");
                int x=Integer.parseInt(param[0]);
                int y=Integer.parseInt(param[1]);
                if(!union.containsKey(x))
                    union.put(x,x);
                if(!union.containsKey(y))
                    union.put(y,y);
                int e=Integer.parseInt(param[2]);
                if(e==1)
                    connect(x,y);
                else
                {
                    une.put(x,y);
                }
            }
            boolean valid=true;
            for(int x: une.keySet())
            {
                int y=une.get(x);
                int rx=find(x);
                int ry=find(y);
                if(rx==ry)
                {
                    valid=false;
                    break;
                }
            }
            if(valid)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}