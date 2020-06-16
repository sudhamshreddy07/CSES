import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.io.*;
public class Building_Roads {
    public static void main(String args[])throws Exception
    {
     //   File file = new File("C:\\Users\\munna\\Desktop\\test.txt");
       // BufferedReader br=new BufferedReader(new FileReader(file));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String s[]=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        boolean b[]=new boolean[n+1];
        LinkedList<LinkedList<Integer>> a=new LinkedList<>();
        for(int i=0;i<=n;i++)
            a.add(new LinkedList<>());
        while(m-->0)
        {
            String s1[]=br.readLine().split(" ");
            int x=Integer.parseInt(s1[0]);
            int y=Integer.parseInt(s1[1]);
            a.get(x).addFirst(y);
            a.get(y).addFirst(x);
        }
        LinkedList<Integer> ans=new LinkedList<>();
        for(int i=1;i<=n;i++)
        {
            if(!b[i])
                b[i]=true;
            else
                continue;
            ans.addFirst(i);
            Stack<Integer> st=new Stack<>();
            st.push(i);
            while(!st.empty()){
                int p=st.pop();
                LinkedList<Integer> x=a.get(p);
                for(int j=0;j<x.size();j++)
                {
                    int y=x.get(j);
                    if(!b[y])
                    {
                        b[y]=true;
                        st.push(y);
                    }
                }
            }
        }
        bw.write(ans.size()-1+"\n");
        for(int i=0;i<ans.size()-1;i++)
        {
            bw.write(ans.get(i)+" "+ans.get(i+1)+"\n");
        }
        bw.flush();
    }
}
