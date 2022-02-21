import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]arr=new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            arr[i][2]=sc.nextInt();
        }
       int [][]dp=new int[n][3];
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];
        for (int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][1]+arr[i][0],dp[i-1][2]+arr[i][0]);
            dp[i][1]=Math.max(dp[i-1][0]+arr[i][1],dp[i-1][2]+arr[i][1]);
            dp[i][2]=Math.max(dp[i-1][1]+arr[i][2],dp[i-1][0]+arr[i][2]);
        }
        int max=-1;
        for(int i=0;i<3;i++)
            max=Math.max(max,dp[n-1][i]);
        System.out.println(max);
    }
}
