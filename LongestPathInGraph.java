import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class  Graph{
    int n;
    ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
    Graph(int n){
        this.n=n;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
    }
    void addEdge(int u,int v){
        adj.get(u-1).add(v-1);
    }
    void printGraph(){
        for(int i=0;i<n;i++){
            System.out.print(i+" -->");
            for(int k:adj.get(i))
                System.out.print(k+" , ");
            System.out.println();
        }

    }
}
public class LongestPathInGraph {
    static int []dp;
    public static int find(Graph g,int i,int n){
        if(i>=n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int ans=Integer.MIN_VALUE;
        if(g.adj.get(i)==null)
            ans=0;
        else {
            for (int k : g.adj.get(i)) {
                ans = Math.max(ans, find(g, k, n));

            }
        }
        dp[i]=ans;
        return dp[i];
    }
    public  static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Graph g=new Graph(n);
        //g.printGraph();
        for(int i=0;i<m;i++){
            g.addEdge(sc.nextInt(),sc.nextInt());
        }
        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=find(g,0,n);
        ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,dp[i]);
        System.out.println(ans);

    }
}
