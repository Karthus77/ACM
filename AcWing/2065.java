import java.io.*;
import java.util.*;
public class Main {
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        n=Long.parseLong(reader.readLine());
        while(n>0)
        {
            System.out.print(n+" ");
            n/=2;
        }
    }
}