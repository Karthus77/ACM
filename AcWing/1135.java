import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int n,m;
    static final int INF=0x3f3f3f;
    static long res=0x3f3f3f3f;
    static final int N=50010;
    static final int M=200010;
    static int[] num=new int[6];
    static int x,y,t;
    static int[] e=new int[M];
    static int[] h=new int[N];
    static int[] ne=new int[M];
    static int[] w=new int[M];
    static boolean[] st=new boolean[N];
    static int[] dis=new int[N];
    static int[][] g=new int[6][6];
    static int idx=0;
    static boolean[] road=new boolean[6];
    static PriorityQueue<int[]> heap=new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1],o2[1]);
        }
    });
    public static void add(int a,int b,int c)
    {
        e[idx]=b;
        w[idx]=c;
        ne[idx]=h[a];
        h[a]=idx++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        String[] p2=reader.readLine().split(" ");
        Arrays.fill(h,-1);
        num[0]=1;
        for(int i=1;i<=p2.length;i++)
        {
            num[i]=Integer.parseInt(p2[i-1]);
        }
        for(int i=0;i<m;i++) {
            String[] edge = reader.readLine().split(" ");
            x = Integer.parseInt(edge[0]);
            y = Integer.parseInt(edge[1]);
            t = Integer.parseInt(edge[2]);
            add(x, y, t);
            add(y, x, t);
        }
        for(int i=0;i<6;i++)
        {
            Dijkstra(num[i]);
            for(int j=0;j<6;j++)
            {
                g[i][j]=dis[num[j]];
            }
        }
        dfs(0,1,0);
        System.out.println(res);
    }
    public static void dfs(int start,int deep,int ans)
    {
        if(deep==6)
            res=Math.min(res,ans);
        else
        {
            for(int i=1;i<6;i++)
            {
                if(!road[i])
                {
                    ans+=g[start][i];
                    road[i]=true;
                    dfs(i,deep+1,ans);
                    ans-=g[start][i];
                    road[i]=false;
                }
            }
        }
    }
    public static void Dijkstra(int a)
    {
        Arrays.fill(dis,INF);
        Arrays.fill(st,false);
        heap.clear();
        dis[a]=0;
        heap.add(new int[]{a,0});
        while(!heap.isEmpty()) {
            int[] p= heap.poll();
            int now=p[0];
            int nd=p[1];
            if(st[now])
                continue;
            st[now]=true;
            for (int i = h[now]; i != -1; i = ne[i]) {
                int time = w[i];
                int np = e[i];
                if(dis[np]>nd+time)
                {
                    dis[np] =  nd + time;
                    heap.add(new int[]{np, dis[np]});
                }
            }
        }
    }
}