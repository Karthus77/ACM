import java.io.*;

public class Main {
    static char[][] start =new char[5][5];
    static char[][] g=new char[5][5];
    static int[] dx= {-1,0,1,0,0};
    static int[] dy= {0,0,0,-1,1};
    static int res=0;
    static int n;
    public static void turn(char[][] m,int r,int c)
    {
        for(int i=0;i<5;i++)
        {
            int x=r+dx[i];
            int y=c+dy[i];
            if(x>=0&&x<5&&y>=0&&y<5)
            {
                m[x][y]^=1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        while(n--!=0)
        {
            res=Integer.MAX_VALUE;
            for(int i=0;i<5;i++)
            {
                start[i]=reader.readLine().toCharArray();
            }
            for(int op=0;op<32;op++)
            {
                int cnt=0;
                for(int i=0;i<5;i++)
                {
                    g[i]=start[i].clone();
                }
                for(int i=0;i<5;i++)
                {
                    if((op>>i&1)==1)
                    {
                        turn(g,0,i);
                        cnt++;
                    }
                }
                for(int i=0;i<4;i++)
                {
                    for(int j=0;j<5;j++)
                    {
                        if(g[i][j]=='0') {
                            turn(g, i + 1, j);
                            cnt++;
                        }
                    }
                }
                boolean goal=true;
                for(int i=0;i<5;i++)
                {
                    if (g[4][i] == '0') {
                        goal = false;
                        break;
                    }
                }
                if(goal)
                    res=Math.min(res,cnt);
            }
            if(res>6)
                System.out.println(-1);
            else
                System.out.println(res);
            reader.readLine();
        }
    }
}