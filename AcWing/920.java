import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int n;
    static int m;
    static final int N=510;
    static int[][] g=new int[N][N];
    static Queue<Integer> queue=new LinkedList<>();
    static int[] dis=new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = reader.readLine().split(" ");
        m=Integer.parseInt(param[0]);
        n=Integer.parseInt(param[1]);
        Arrays.fill(dis,-1);
        while (m--!=0)
        {
            String[] way=reader.readLine().split(" ");
            for(int i=0;i< way.length;i++)
            {
                int from=Integer.parseInt(way[i]);
                for(int j=i+1;j< way.length;j++)
                {
                    int to=Integer.parseInt(way[j]);
                    g[from][to]=1;
                }
            }
        }
        queue.add(1);
        dis[1]=0;
        bfs();
        if(dis[n]==-1)
            System.out.println("NO");
        else
            System.out.println(dis[n]-1);
    }
    public static void bfs()
    {
        while (!queue.isEmpty())
        {
            int now= queue.poll();
            for(int i=1;i<N;i++)
            {
                if(g[now][i]==1&&dis[i]==-1)
                {
                    queue.add(i);
                    dis[i]=dis[now]+1;
                }
            }
        }
    }
}

