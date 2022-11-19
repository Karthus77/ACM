
import java.io.*;


public class Main {
    static int n;
    static String ans="Yes";
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        for(int i=0;i<30;i++)
        {
            ans+="Yes";
        }
        while(n--!=0)
        {
            String sub=reader.readLine();
            if (ans.contains(sub))
            {
                System.out.println("YES");
            }
            else
                System.out.println("NO");
        }
    }
}

