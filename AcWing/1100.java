import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int n;
    static int k;
    static final int N=100010;
    static int[] cost=new int[N];
    static boolean[] st=new boolean[N];
    static Queue<Integer> queue=new LinkedList<>();
    static int[] move={-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        k=Integer.parseInt(param[1]);
        queue.add(n);
        st[n]=true;
        bfs();
        System.out.println(cost[k]);
    }
    public static void bfs()
    {
        while(!queue.isEmpty())
        {
            int now= queue.poll();
            for(int i=0;i<move.length;i++)
            {
                int ne=now+move[i];
                if(ne>=0&&ne<N&&!st[ne])//合法
                {
                    st[ne]=true;
                    cost[ne]=cost[now]+1;
                    queue.add(ne);
                }
            }
            if(now*2<N&&!st[now*2])
            {
                st[now*2]=true;
                cost[now*2]=cost[now]+1;
                queue.add(now*2);
            }
        }
    }
}

