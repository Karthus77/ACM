import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int N=1010;
    static char[][] g=new char[N][N];
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] dis=new int[N][N];
    static boolean[][] st=new boolean[N][N];
    static int n,m;
    static Queue<int[]> queue=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] p1=reader.readLine().split(" ");
        n=Integer.parseInt(p1[0]);
        m=Integer.parseInt(p1[1]);
        for(int i=0;i<n;i++)
        {
            g[i]=reader.readLine().toCharArray();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(g[i][j]=='1')
                {
                    st[i][j]=true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        bfs();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                out.write(dis[i][j]+" ");
            out.write("\n");
        }
        out.flush();
    }
    public static void bfs()
    {
        while (!queue.isEmpty())
        {
            int[] now= queue.poll();
            for(int i=0;i<4;i++)
            {
                int n_x=now[0]+dx[i];
                int n_y=now[1]+dy[i];
                int n_d=dis[now[0]][now[1]]+1;
                if(n_x>=0&&n_x<n&&n_y<m&&n_y>=0&&!st[n_x][n_y])
                {
                    queue.add(new int[]{n_x,n_y});
                    st[n_x][n_y]=true;
                    dis[n_x][n_y]=n_d;
                }
            }
        }
    }
}
