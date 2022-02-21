import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class node{
    int i,j,dist;
    node(int i,int j,int dist){
        this.i=i;
        this.j=j;
        this.dist=dist;
    }
}
public class wallGate {

    public static void fill(int [][]grid,int n){
        Queue<node>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new node(i,j,0));
                }
            }
        }
        int []xdir={-1,0,1,0};
        int []ydir={0,1,0,-1};
        while (!q.isEmpty()){
            node curr=q.remove();
            for (int k=0;k<4;k++){
                int x=curr.i+xdir[k];
                int y=curr.j+ydir[k];
                if(x<0 || y<0 || x>=n || y>=n)
                    continue;
                if(grid[x][y]==-2){
                    grid[x][y]=curr.dist+1;
                    q.add(new node(x,y, curr.dist+1));
                }
            }
        }
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]grid=new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        fill(grid,n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
