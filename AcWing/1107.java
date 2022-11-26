import java.io.*;
import java.util.*;
public class Main {
    static final int N=8;
    static String goal= "";
    static HashMap<String,String> st=new HashMap<>();
    static Queue<String> queue=new LinkedList<>();
    public static String change(String state)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=7;i>=0;i--)
            stringBuilder.append(state.charAt(i));
        return stringBuilder.toString();
    }
    public static String insert(String state)
    {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(state.charAt(3));
        for(int i=0;i<3;i++)
            stringBuilder.append(state.charAt(i));
        for(int i=5;i<=7;i++)
            stringBuilder.append(state.charAt(i));
        stringBuilder.append(state.charAt(4));
        return stringBuilder.toString();
    }
    public static String rotate(String state)
    {
        int[] num={0,6,1,3,4,2,5,7};
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<=7;i++)
            stringBuilder.append(state.charAt(num[i]));
        return stringBuilder.toString();
    }
    public static void bfs()
    {
        while(!queue.isEmpty())
        {
            String state=queue.poll();
            String op=st.get(state);
            if(state.equals(goal))
            {
                System.out.println(op.length());
                if(op.length()!=0)
                    System.out.println(op);
                return;
            }
            add(change(state),op+"A");
            add(insert(state),op+"B");
            add(rotate(state),op+"C");
        }
    }
    public static void add(String state,String op)
    {
        if (!st.containsKey(state))
        {
            st.put(state,op);
            queue.add(state);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String[] param=reader.readLine().split(" ");
        for(int i=0;i<8;i++)
        {
            goal+=param[i];
        }
        String start="12345678";
        queue.add(start);
        st.put(start,"");
        bfs();
    }
}
