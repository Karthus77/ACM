import java.io.*;


public class Main {
    static int t;
    static int n;
    static long ans;
    static final int N=100010;
    static char[] diverse=new char[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(reader.readLine());
        while(t--!=0)
        {
            ans=0;
            n=Integer.parseInt(reader.readLine());
            String in=reader.readLine();
            for(int i=0;i<n;i++)
            {
                diverse[i]=in.charAt(i);
                forward(i);
            }
            System.out.println(ans);
        }
    }
    public static void forward(int x)
    {
        int distinct=0;
        boolean[] have=new boolean[10];
        int[] cnt = new int[10];
        int max=0;
        for(int i=x;i>=0&&i>x-100;i--)
        {
            int ne=Integer.parseInt(String.valueOf(diverse[i]));
            if(!have[ne])
            {
                distinct++;
                have[ne]=true;
            }
            cnt[ne]++;
            max=Math.max(max,cnt[ne]);
            if(max<=distinct)
                ans++;
            else if(max>10)
                break;
        }
    }
}

