
import java.io.*;


public class Main {
    static int t;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(reader.readLine());
        while(t--!=0)
        {
            n=Integer.parseInt(reader.readLine());
            if((n&1)==1)//å¥?
            {
                System.out.println(n/2+1);
            }
            else
            {
                System.out.println((n-1)/2+1);
            }
        }
    }
}

