package com.Karhus.AcWing;

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static final int N=110;
    static int[][] w=new int[N][N];
    static int[] level=new int[N];
    static int[] price=new int[N];
    static final int INF=0x3f3f3f3f;
    static boolean[] st=new boolean[N];
    static int[] dis=new int[N];
    static PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1],o2[1]);
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        m=Integer.parseInt(param[0]);
        n=Integer.parseInt(param[1]);
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(w[i],INF);
            w[i][i]=0;
        }
        for(int i=1;i<=n;i++)
        {
            String[] p2=reader.readLine().split(" ");
            price[i]=Integer.parseInt(p2[0]);
            w[0][i]=price[i];
            level[i]=Integer.parseInt(p2[1]);
            int x=Integer.parseInt(p2[2]);
            while(x--!=0)
            {
                String[] p3=reader.readLine().split(" ");
                int t=Integer.parseInt(p3[0]);
                int discount=Integer.parseInt(p3[1]);
                w[t][i]=Math.min(w[t][i],discount);
            }
        }
        int ans=INF;
        for(int l=level[1]-m;l<=level[1];l++)
        {
            ans=Math.min(ans,Dijkstra(l,l+m));
        }
        System.out.println(ans);
    }
    public static int Dijkstra(int l,int r)
    {
        Arrays.fill(dis,INF);
        Arrays.fill(st,false);
        dis[0]=0;
        queue.clear();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty())
        {
            int[] min= queue.poll();
            int k=min[0];
            if(st[k])continue;
            st[k]=true;
            for(int j=1;j<=n;j++)
            {
                if(level[j]>=l&&level[j]<=r)
                {
                   if(dis[k]+w[k][j]<dis[j])
                   {
                       dis[j]=dis[k]+w[k][j];
                       queue.offer(new int[]{j,dis[j]});
                   }
                }
            }
        }
        return dis[1];
    }
}
