package com.Karhus.AcWing;

import java.io.*;

public class Main {
    static int n,m;
    static int w;
    static final int N=10010;
    static int[] c=new int[N];
    static int[] d=new int[N];
    static int[] root=new int[N];
    static int[] dp=new int[N];
    public static void connect(int x,int y)
    {
        int rx=find(x);
        int ry=find(y);
        if(rx!=ry)
        {

            d[rx]+=d[ry];
            c[rx]+=c[ry];
            root[ry]=rx;
        }
    }
    public static int find(int x)
    {
        if(root[x]!=x)
            root[x]=find(root[x]);
        return root[x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        w=Integer.parseInt(param[2]);
        for(int i=1;i<=n;i++)
        {
            root[i]=i;
            String[] p1=reader.readLine().split(" ");
            c[i]=Integer.parseInt(p1[0]);
            d[i]=Integer.parseInt(p1[1]);
        }
        for(int i=0;i<m;i++)
        {
            String[] p2= reader.readLine().split(" ");
            int x=Integer.parseInt(p2[0]);
            int y=Integer.parseInt(p2[1]);
            connect(x,y);
        }

        for(int i=1;i<=n;i++)
        {
            if(root[i]==i)
            for(int j=w;j>=c[i];j--)
            {
                dp[j]=Math.max(dp[j],dp[j-c[i]]+d[i]);
            }
        }
        System.out.println(dp[w]);
    }
}
