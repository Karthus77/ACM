import java.io.*;
public class Main {
    static final int N=1000;
    static char[] ans=new char[N];
    static char[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        f=reader.readLine().toCharArray();
        char tmp=f[0];
        for(int i=0;i<f.length;i++)
        {
            if(f[i]>'0'&&f[i]<='9')
            {
                int k=f[i]-'0'-1;
                while(k--!=0)
                {
                    System.out.print(tmp);
                }
            }
            else {
                tmp=f[i];
                System.out.print(tmp);
            }
        }
    }
}