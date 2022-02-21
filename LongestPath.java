import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class cell{
    int val;
    int weight;
    cell(int v,int w){
        val=v;
        weight=w;
    }
}
class graph{
    int n;
    ArrayList<ArrayList<cell>>adj=new ArrayList<>();
    graph(int n){
    this.n=n;
    for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u,int v,int w){
    adj.get(u).add(new cell(v,w));
    }
    int maxDistance(int []distance,boolean []visited){
        int index=-1;
        int dist=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist<distance[i] && !visited[i]){
                dist=distance[i];
                index=i;
            }
        }
        return index;
    }
    int findLongestPath(){
        int []distance=new int[n];
        Arrays.fill(distance,Integer.MIN_VALUE);
        distance[0]=0;
        int count=0;
        boolean []visited=new boolean[n];
        while (count<n){
            int max_index=maxDistance(distance,visited);
            visited[max_index]=true;
            for(cell k:adj.get(max_index)){
                if(distance[k.val]<distance[max_index]+k.weight){
                    distance[k.val]=distance[max_index]+k.weight;
                }
            }
            count++;
        }
        int longestPath=0;
        for(int i=0;i<n;i++){
            if(longestPath<distance[i])
                longestPath=distance[i];
        }
        System.out.println(Arrays.toString(distance));
        return longestPath;
    }
}
public class LongestPath {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        graph g=new graph(n);
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int w=sc.nextInt();
            g.addEdge(a,b,w);
        }
        System.out.println(g.findLongestPath());
    }
}
