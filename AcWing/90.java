package com.Karhus.AcWing;

import java.io.*;


public class Main {
    static long a,b,p;
    static long ans=0;
    static long qsm(long a,long x)
    {
        long tmp=0;
        while(x!=0)
        {
            if((x&1)==1)
            {
                tmp=(tmp%p+a%p)%p;
            }
            a=(a%p+a%p)%p;
            x>>=1;
        }
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a=Long.parseLong(reader.readLine());
        b=Long.parseLong(reader.readLine());
        p=Long.parseLong(reader.readLine());
        System.out.println(qsm(a,b));
    }
}

