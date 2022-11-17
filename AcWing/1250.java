package com.Karhus.AcWing;

import java.io.*;
import java.util.Arrays;


public class Main {
    static int n, m;
    static final int N=40010;
    static int[] root=new int[N];
    static int[] size=new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = reader.readLine().split(" ");
        n=Integer.parseInt(param[0]);
        m=Integer.parseInt(param[1]);
        Arrays.fill(size,1);
        for(int i=1;i<=n*n;i++)
            root[i]=i;
        for(int i=1;i<=m;i++)
        {

            int index1,index2;
            String[] move=reader.readLine().split(" ");
            int row=Integer.parseInt(move[0]);
            int col=Integer.parseInt(move[1]);
            index1=(row-1)*n+col;
            if(move[2].equals("R"))
                index2=index1+1;
            else
                index2=index1+n;
            if(isConnect(index1,index2))
            {
                System.out.println(i);
                return ;
            }
            else
                union(index1,index2);
        }
        System.out.println("draw");
    }
    public static int find(int x)
    {
        if(x!=root[x])
            root[x]=find(root[x]);
        return root[x];
    }
    public static void union(int x,int y)
    {
        int rx=find(x);
        int ry=find(y);
        if(size[rx]>size[ry])
        {
            root[y]=rx;
            size[rx]+=size[ry];
        }
        else
        {
            root[x]=ry;
            size[ry]+=size[rx];
        }
    }
    public static boolean isConnect(int x,int y)
    {
        return find(x) == find(y);
    }
}

